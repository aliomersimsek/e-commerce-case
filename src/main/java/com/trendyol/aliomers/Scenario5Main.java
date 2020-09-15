package com.trendyol.aliomers;

import com.trendyol.aliomers.creature.CouponCreature;
import com.trendyol.aliomers.handler.Handler;
import com.trendyol.aliomers.model.Cart;

import static com.trendyol.aliomers.creature.DeliveryCreature.TURKEY_ANKARA_06800;
import static com.trendyol.aliomers.creature.DeliveryCreature.TURKEY_ANKARA_06850;
import static com.trendyol.aliomers.creature.ProductCreature.*;

/**
 * @author aliomers on 13.09.2020
 */

public class Scenario5Main {

    private static final Handler handler = Handler.getInstance();

    public static void main(String[] args) {
        try {
            final Cart cart = new Cart();
            handler.addDelivery(cart, TURKEY_ANKARA_06850);
            handler.addDelivery(cart, TURKEY_ANKARA_06800);
            handler.removeDelivery(cart, TURKEY_ANKARA_06850);

            handler.addProduct(cart, WATER, 2);
            handler.addProduct(cart, TEA, 3);
            handler.addProduct(cart, SHIRT, 3);
            handler.addProduct(cart, SHIRT, 4);
            handler.addProduct(cart, APPLE, 6);
            handler.addProduct(cart, WATER, 6);
            handler.addProduct(cart, APPLE, 6);

            handler.applyCoupon(cart, CouponCreature.COUPON_150);
            handler.applyCoupon(cart, CouponCreature.COUPON_100);

            handler.addProduct(cart, CPU, 7);

            handler.addDelivery(cart, TURKEY_ANKARA_06800);
            handler.addDelivery(cart, TURKEY_ANKARA_06850);

            handler.printCart(cart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
