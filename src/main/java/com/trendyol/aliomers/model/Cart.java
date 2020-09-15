package com.trendyol.aliomers.model;

import com.trendyol.aliomers.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aliomers on 12.09.2020
 */

public class Cart {

    private List<CartItem> products = new ArrayList<>();
    private Coupon appliedCoupon;
    private List<Campaign> campaignList = new ArrayList<>();
    private List<DeliveryRule> deliveryRuleList = new ArrayList<>();
    private List<Delivery> deliveryList = new ArrayList<>();


    // Getters
    public List<CartItem> getProducts() {
        return products;
    }

    public Coupon getAppliedCoupon() {
        return appliedCoupon;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public List<DeliveryRule> getDeliveryRuleList() {
        return deliveryRuleList;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    // Setters
    public void setAppliedCoupon(Coupon appliedCoupon) {
        this.appliedCoupon = appliedCoupon;
    }

    // Other methods
    public void addProduct(CartItem cartItem) {
        if (cartItem == null) throw new NullPointerException();

        this.products.add(cartItem);
    }

    public void removeProduct(Product product) {
        if (product == null) throw new NullPointerException();

        this.products.removeIf(p -> p.equals(product));
    }

    public void addCampaign(Campaign campaign) {
        if (campaign == null) throw new NullPointerException();

        /* TODO aliomers 14.09.2020 00:12 - 9 product varken 10 olduğunda bir üst pakete geçmesi için aynı kategori sildik yenisini ekledik. */
        campaignList.removeIf(c -> c.getApplicableCategory().equals(campaign.getApplicableCategory()));
        campaignList.add(campaign);
    }

    public void removeCampaign(Category category) {
        if (category == null) throw new NullPointerException();

        campaignList.removeIf(c -> c.getApplicableCategory().equals(category));
    }

    public Integer getNumOfProducts() {
        Integer total = 0;
        for (CartItem cartItem : this.products) {
            total = total + cartItem.getQuantity();
        }
        return total;
    }

}
