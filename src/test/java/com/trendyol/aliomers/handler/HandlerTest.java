package com.trendyol.aliomers.handler;

import com.trendyol.aliomers.entity.Coupon;
import com.trendyol.aliomers.entity.Delivery;
import com.trendyol.aliomers.entity.Product;
import com.trendyol.aliomers.model.Cart;
import com.trendyol.aliomers.model.CartItem;
import com.trendyol.aliomers.service.CouponService;
import com.trendyol.aliomers.service.DeliveryService;
import com.trendyol.aliomers.service.ProductService;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static com.trendyol.aliomers.creature.CouponCreature.*;
import static com.trendyol.aliomers.creature.ProductCreature.*;

/**
 * @author aliomers on 14.09.2020
 */

public class HandlerTest {

    private static Handler handler = Handler.getInstance();

    private static ProductService productService = ProductService.getInstance();
    private static Optional<Product> product = productService.list().stream().findAny();

    private static CouponService couponService = CouponService.getInstance();
    private static Optional<Coupon> coupon = couponService.list().stream().findAny();

    private static DeliveryService deliveryService = DeliveryService.getInstance();
    private static Optional<Delivery> delivery = deliveryService.list().stream().findAny();

    private static Cart cart;

    @Test
    public void successfulAddProductTest() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 3);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddProductTest1() {
        try {
            cart = new Cart();
            handler.addProduct(null, product.get(), 3);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddProductTest2() {
        try {
            cart = new Cart();
            handler.addProduct(cart, null, 3);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddProductTest3() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), -1);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Quantity value can not be negative or zero!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfulRemoveProductTest() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 3);
            handler.removeProduct(cart, product.get());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidRemoveProductTest1() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 3);
            handler.removeProduct(null, product.get());
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidRemoveProductTest2() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 3);
            handler.removeProduct(cart, null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfullApplyCampaignsTest() {
        try {
            cart = new Cart();
            handler.applyCampaigns(cart);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidApplyCampaignsTest() {
        try {
            cart = new Cart();
            handler.applyCampaigns(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfullApplyCouponTest() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 23);
            handler.applyCoupon(cart, coupon.get());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidApplyCouponTest1() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 23);
            handler.applyCoupon(null, coupon.get());
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidApplyCouponTest2() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 23);
            handler.applyCoupon(cart, null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfullRemoveCouponTest() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 23);
            handler.applyCoupon(cart, coupon.get());
            handler.removeCoupon(cart);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidRemoveCouponTest1() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 23);
            handler.applyCoupon(cart, coupon.get());
            handler.removeCoupon(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfullAddDeliveryTest() {
        try {
            cart = new Cart();
            handler.addDelivery(cart, delivery.get());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddDeliveryTest1() {
        try {
            cart = new Cart();
            handler.addDelivery(null, delivery.get());
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddDeliveryTest2() {
        try {
            cart = new Cart();
            handler.addDelivery(cart, null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfullRemoveDeliveryTest() {
        try {
            cart = new Cart();
            handler.addDelivery(cart, delivery.get());
            handler.removeDelivery(cart, delivery.get());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidRemoveDeliveryTest1() {
        try {
            cart = new Cart();
            handler.addDelivery(cart, delivery.get());
            handler.removeDelivery(null, delivery.get());
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidRemoveDeliveryTest2() {
        try {
            cart = new Cart();
            handler.addDelivery(cart, delivery.get());
            handler.removeDelivery(cart, null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfullPrintCartTest() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 23);
            handler.applyCoupon(cart, coupon.get());
            handler.printCart(cart);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidPrintCartTest() {
        try {
            cart = new Cart();
            handler.addProduct(cart, product.get(), 23);
            handler.applyCoupon(cart, coupon.get());
            handler.printCart(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void applyCouponScenario1() {
        try {
            cart = new Cart();
            handler.addProduct(cart, APPLE, 11); // Cost 110
            handler.addProduct(cart, ALMONDS, 8); // Cost 120
            handler.applyCoupon(cart, COUPON_150);
            handler.applyCoupon(cart, COUPON_100);
            handler.removeProduct(cart, ALMONDS);

            Assert.assertEquals(COUPON_100, cart.getAppliedCoupon());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void notApplyCouponScenario1() {
        try {
            cart = new Cart();
            handler.addProduct(cart, APPLE, 13); // Cost 130
            handler.applyCoupon(cart, COUPON_200);

            Assert.assertEquals(null, cart.getAppliedCoupon());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void notApplyCouponScenario2() {
        try {
            cart = new Cart();
            handler.addProduct(cart, APPLE, 8); // Cost 80
            handler.addProduct(cart, ALMONDS, 8); // Cost 120
            handler.applyCoupon(cart, COUPON_150);
            handler.removeProduct(cart, ALMONDS);

            Assert.assertEquals(null, cart.getAppliedCoupon());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void notApplyCouponScenario3() {
        try {
            cart = new Cart();
            handler.addProduct(cart, APPLE, 11); // Cost 110
            handler.addProduct(cart, ALMONDS, 8); // Cost 120
            handler.applyCoupon(cart, COUPON_100);
            handler.applyCoupon(cart, COUPON_150);
            handler.removeProduct(cart, ALMONDS);

            Assert.assertEquals(null, cart.getAppliedCoupon());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void notApplyCouponScenario4() {
        try {
            cart = new Cart();
            handler.addProduct(cart, APPLE, 20); // Cost 200 - Cost With Discount 194
            handler.addProduct(cart, CAKE, 1); // Cost 5
            handler.applyCoupon(cart, COUPON_200);

            Assert.assertEquals(null, cart.getAppliedCoupon());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void applyCampaignScenario() {
        try {
            cart = new Cart();
            handler.addProduct(cart, APPLE, 20);
            handler.addProduct(cart, CAKE, 1);

            Optional<CartItem> appleInCart = cart.getProducts().stream().filter(p -> p.equals(APPLE)).findAny();
            BigDecimal appleCostForOne = Optional.ofNullable(appleInCart.get().getPriceWithDiscount()).orElse(appleInCart.get().getPrice());
            BigDecimal appleCost = appleCostForOne.multiply(BigDecimal.valueOf(appleInCart.get().getQuantity()));
            Optional<CartItem> cakeInCart = cart.getProducts().stream().filter(p -> p.equals(CAKE)).findAny();
            BigDecimal cakeCostForOne = Optional.ofNullable(cakeInCart.get().getPriceWithDiscount()).orElse(cakeInCart.get().getPrice());
            BigDecimal cakeCost = cakeCostForOne.multiply(BigDecimal.valueOf(cakeInCart.get().getQuantity()));

            Assert.assertEquals("194.00", appleCost.toString());
            Assert.assertEquals("4.85", cakeCost.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void notApplyCampaignScenario() {
        try {
            cart = new Cart();
            handler.addProduct(cart, APPLE, 2);
            handler.addProduct(cart, CAKE, 1);

            Optional<CartItem> appleInCart = cart.getProducts().stream().filter(p -> p.equals(APPLE)).findAny();
            BigDecimal appleCostForOne = Optional.ofNullable(appleInCart.get().getPriceWithDiscount()).orElse(appleInCart.get().getPrice());
            BigDecimal appleCost = appleCostForOne.multiply(BigDecimal.valueOf(appleInCart.get().getQuantity()));
            Optional<CartItem> cakeInCart = cart.getProducts().stream().filter(p -> p.equals(CAKE)).findAny();
            BigDecimal cakeCostForOne = Optional.ofNullable(cakeInCart.get().getPriceWithDiscount()).orElse(cakeInCart.get().getPrice());
            BigDecimal cakeCost = cakeCostForOne.multiply(BigDecimal.valueOf(cakeInCart.get().getQuantity()));

            Assert.assertEquals("20", appleCost.toString());
            Assert.assertEquals("5", cakeCost.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
