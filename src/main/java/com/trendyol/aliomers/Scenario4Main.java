package com.trendyol.aliomers;

import com.trendyol.aliomers.handler.Handler;
import com.trendyol.aliomers.model.Cart;

import static com.trendyol.aliomers.creature.ProductCreature.APPLE;
import static com.trendyol.aliomers.creature.ProductCreature.WATER;

/**
 * @author aliomers on 13.09.2020
 */

public class Scenario4Main {

    private static final Handler handler = Handler.getInstance();

    public static void main(String[] args) {
        try {
            final Cart cart = new Cart();
            handler.addProduct(cart, WATER, 2);

            handler.removeCoupon(cart);

            handler.removeProduct(cart, APPLE);

            handler.printCart(cart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
