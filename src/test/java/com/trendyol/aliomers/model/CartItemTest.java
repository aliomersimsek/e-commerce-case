package com.trendyol.aliomers.model;

import com.trendyol.aliomers.entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static com.trendyol.aliomers.creature.CategoryCreature.C_FOOD;

/**
 * @author aliomers on 13.09.2020
 */

public class CartItemTest {

    @Test
    public void successfulInstanceCreationTest() {
        try {
            Product product = new Product("product", BigDecimal.valueOf(11), C_FOOD);
            new CartItem(product, 7);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCartItemProductTest1() {
        try {
            new CartItem(null, 7);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCartItemQuantityTest1() {
        try {
            Product product = new Product("product", BigDecimal.valueOf(11), C_FOOD);
            new CartItem(product, null);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Quantity is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCartItemQuantityTest2() {
        try {
            Product product = new Product("product", BigDecimal.valueOf(11), C_FOOD);
            new CartItem(product, -1);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Quantity value can not be negative or zero!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
