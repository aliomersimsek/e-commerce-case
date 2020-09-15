package com.trendyol.aliomers.handler;

import com.trendyol.aliomers.entity.*;
import com.trendyol.aliomers.model.Cart;
import com.trendyol.aliomers.model.CartItem;
import com.trendyol.aliomers.service.CampaignService;
import com.trendyol.aliomers.service.DeliveryRuleService;
import com.trendyol.aliomers.service.DeliveryService;
import com.trendyol.aliomers.util.Util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author aliomers on 13.09.2020
 */

public class Handler {

    private static Handler instance;

    private CampaignService campaignService = CampaignService.getInstance();
    private DeliveryService deliveryService = DeliveryService.getInstance();
    private DeliveryRuleService deliveryRuleService = DeliveryRuleService.getInstance();

    private Handler() {

    }

    public static Handler getInstance() {
        if (instance == null)
            instance = new Handler();
        return instance;
    }

    // Product methods
    public void addProduct(Cart cart, Product product, int quantity) {
        if (cart == null || product == null) throw new NullPointerException();
        if (quantity <= 0) throw new IllegalArgumentException("Quantity value can not be negative or zero!");

        boolean isFound = findProductAndAddQuantity(cart, product, quantity);
        if (!isFound) {
            cart.addProduct(new CartItem(product, quantity));
        }
        updateCampaigns(cart);
        applyCampaigns(cart);

    }

    public void removeProduct(Cart cart, Product product) {
        if (cart == null || product == null) throw new NullPointerException();

        cart.removeProduct(product);
        cart.removeCampaign(product.getCategory());
        updateCampaigns(cart);
        applyCampaigns(cart);

        checkAndUpdateCoupon(cart);
    }

    private boolean findProductAndAddQuantity(Cart cart, Product product, Integer quantity) {
        for (CartItem p : cart.getProducts()) {
            if (p.getProduct().equals(product)) {
                p.addQuantityAndCost(quantity);
                return true;
            }
        }
        return false;
    }

    // Campaign methods
    public void applyCampaigns(Cart cart) {
        if (cart == null) throw new NullPointerException();

        for (Campaign campaign : cart.getCampaignList()) {
            for (CartItem cartItem : cart.getProducts()) {
                if (!cartItem.getCategory().equals(campaign.getApplicableCategory())) {
                    continue;
                }
                cartItem.setDiscountRate(campaign.getDiscountFactor());
                BigDecimal multiply = BigDecimal.valueOf(100 - campaign.getDiscountFactor()).divide(BigDecimal.valueOf(100));
                cartItem.setPriceWithDiscount(cartItem.getPrice().multiply(multiply));
            }
        }
    }

    private void updateCampaigns(Cart cart) {
        Map<Category, Integer> categoryQuantityMap = getCategoryQuantityMap(cart);
        for (Category c : categoryQuantityMap.keySet()) {
            Optional<Campaign> campaign = getCampaignByCategory(c, categoryQuantityMap.get(c));
            campaign.ifPresent(cart::addCampaign);
        }
    }

    private Optional<Campaign> getCampaignByCategory(Category category, int quantity) {
        return campaignService.list().stream()
                .filter(c -> c.getApplicableCategory().equals(category) && c.getNumOfProduct() <= quantity)
                .sorted((f1, f2) -> Long.compare(f2.getNumOfProduct(), f1.getNumOfProduct()))
                .findFirst();
    }

    private Map<Category, Integer> getCategoryQuantityMap(Cart cart) {
        Map<Category, Integer> resp = new HashMap<>();
        cart.getProducts().forEach(p -> resp.put(p.getCategory(), p.getQuantity()));
        return resp;
    }

    // Coupon methods
    public void applyCoupon(Cart cart, Coupon coupon) {
        if (cart == null || coupon == null) throw new NullPointerException();
        if (coupon.getMinOfCartAmount().compareTo(getCartTotalAmountWithCampaignsDiscounts(cart)) <= 0) {
            cart.setAppliedCoupon(coupon);
        }
    }

    private void checkAndUpdateCoupon(Cart cart) {
        if (cart == null) throw new NullPointerException();
        if (cart.getAppliedCoupon() != null && cart.getAppliedCoupon().getMinOfCartAmount().compareTo(getCartTotalAmountWithCampaignsDiscounts(cart)) > 0) {
            removeCoupon(cart);
        }
    }

    public void removeCoupon(Cart cart) {
        if (cart == null) throw new NullPointerException();

        cart.setAppliedCoupon(null);
    }

    // DeliveryRule methods
    private List<DeliveryRule> getDeliveryRules(Cart cart) {
        List<DeliveryRule> collect = deliveryRuleService.list().stream()
                .filter(d -> d.getRuleType().equals(DeliveryRule.RuleType.PRODUCT_COUNT) && d.getControlValue() <= cart.getNumOfProducts())
                .sorted((f1, f2) -> Long.compare(f2.getControlValue(), f1.getControlValue()))
                .filter(Util.distinctByKey(DeliveryRule::getRuleType))
                .collect(Collectors.toList());

        List<DeliveryRule> collect2 = deliveryRuleService.list().stream()
                .filter(d -> d.getRuleType().equals(DeliveryRule.RuleType.DELIVERY_COUNT) && d.getControlValue() <= getDeliveries(cart).size())
                .sorted((f1, f2) -> Long.compare(f2.getControlValue(), f1.getControlValue()))
                .filter(Util.distinctByKey(DeliveryRule::getRuleType))
                .collect(Collectors.toList());

        // Merge two list
        collect.addAll(collect2);
        return collect;
    }

    // Delivery methods
    public void addDelivery(Cart cart, Delivery delivery) {
        if (cart == null || delivery == null) throw new NullPointerException();

        if (cart.getDeliveryList().stream().noneMatch(d -> d.equals(delivery)))
            cart.getDeliveryList().add(delivery);
    }

    public void removeDelivery(Cart cart, Delivery delivery) {
        if (cart == null || delivery == null) throw new NullPointerException();

        cart.getDeliveryList().removeIf(d -> d.equals(delivery));
    }

    private List<Delivery> getDeliveries(Cart cart) {
        return cart.getDeliveryList();
    }

    // Cost methods
    private BigDecimal getCartTotalAmount(Cart cart) {
        applyCampaigns(cart);
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : cart.getProducts()) {
            total = total.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return total;
    }

    private BigDecimal getCartTotalAmountWithCampaignsDiscounts(Cart cart) {
        applyCampaigns(cart);
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : cart.getProducts()) {
            BigDecimal cost = Optional.ofNullable(item.getPriceWithDiscount()).orElse(item.getPrice());
            total = total.add(cost.multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return total;
    }

    private BigDecimal getTotalCampaignDiscount(Cart cart) {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem cartItem : cart.getProducts()) {
            BigDecimal costWithDiscount = Optional.ofNullable(cartItem.getPriceWithDiscount()).orElse(cartItem.getPrice());
            BigDecimal multiply = cartItem.getPrice().subtract(costWithDiscount);
            total = total.add(BigDecimal.valueOf(cartItem.getQuantity()).multiply(multiply));
        }
        return total;
    }

    private BigDecimal getTotalCouponDiscount(Cart cart) {
        return cart.getAppliedCoupon() != null ? cart.getAppliedCoupon().getPriceDiscount() : BigDecimal.ZERO;
    }

    private BigDecimal getTotalDeliveryCost(Cart cart) {
        BigDecimal delivery = deliveryService.getDeliveryCostConstant();
        for (DeliveryRule d : getDeliveryRules(cart)) {
            BigDecimal increaseRate4ProductCount = BigDecimal.valueOf(d.getIncreaseRateValue()).divide(BigDecimal.valueOf(100));
            delivery = delivery.add(deliveryService.getDeliveryCostConstant().multiply(increaseRate4ProductCount));
        }
        return delivery;
    }

    private BigDecimal getTotalCost(Cart cart) {
        return getCartTotalAmount(cart)
                .add(getTotalDeliveryCost(cart))
                .subtract(getTotalCampaignDiscount(cart))
                .subtract(getTotalCouponDiscount(cart));
    }

    public void printCart(Cart cart) {
        if (cart == null) throw new NullPointerException();

        System.out.println("\nSHOPPING CART");
        cart.getProducts().forEach(System.out::println);

        System.out.println("\nCAMPAIGNS");
        cart.getCampaignList().forEach(System.out::println);

        System.out.println("\nCOUPON");
        if (cart.getAppliedCoupon() != null)
            System.out.println(cart.getAppliedCoupon());

        System.out.println("\nDELIVERY RULE INFO");
        getDeliveryRules(cart).forEach(System.out::println);

        System.out.println("\nDELIVERY INFO");
        cart.getDeliveryList().forEach(System.out::println);

        System.out.println("\nBILL");
        System.out.println(String.format("Cost: %s $", getCartTotalAmount(cart)));
        if (!cart.getCampaignList().isEmpty())
            System.out.println(String.format("Total Campaign Discount: %s $", getTotalCampaignDiscount(cart)));
        if (cart.getAppliedCoupon() != null)
            System.out.println(String.format("Total Coupon Discount: %s $", getTotalCouponDiscount(cart)));
        System.out.println(String.format("DeliveryRule Cost: %s $", getTotalDeliveryCost(cart)));
        System.out.println(String.format("Total Cost: %s $", getTotalCost(cart)));

    }

}
