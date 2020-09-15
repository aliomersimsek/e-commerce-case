package com.trendyol.aliomers.entity;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static com.trendyol.aliomers.creature.CategoryCreature.C_FOOD;

/**
 * @author aliomers on 13.09.2020
 */

public class ProductTest {

    @Test
    public void successfulInstanceCreationTest() {
        try {
            new Product("product", BigDecimal.valueOf(11), C_FOOD);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidProductTitleTest1() {
        try {
            new Product(null, BigDecimal.valueOf(11), C_FOOD);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Title is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidProductTitleTest2() {
        try {
            new Product("", BigDecimal.valueOf(11), C_FOOD);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Title is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidProductTitleTest3() {
        try {
            new Product(" ", BigDecimal.valueOf(11), C_FOOD);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Title is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidProductPriceTest1() {
        try {
            new Product("title", null, C_FOOD);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Price is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidProductPriceTest2() {
        try {
            new Product("title", BigDecimal.valueOf(-1), C_FOOD);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Price value can not be negative or zero!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidProductCategoryTest1() {
        try {
            new Product("title", BigDecimal.valueOf(15), null);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Category can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
