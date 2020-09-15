package com.trendyol.aliomers.entity;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author aliomers on 13.09.2020
 */

public class CouponTest {

    @Test
    public void successfulInstanceCreationTest() {
        try {
            new Coupon(BigDecimal.valueOf(10), BigDecimal.valueOf(100));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCouponPriceDiscountTest1() {
        try {
            new Coupon(null, BigDecimal.valueOf(100));
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("PriceDiscount is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCouponPriceDiscountTest2() {
        try {
            new Coupon(BigDecimal.valueOf(-1), BigDecimal.valueOf(100));
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("PriceDiscount value can not be negative or zero!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCouponMinOfCartAmountTest1() {
        try {
            new Coupon(BigDecimal.valueOf(10), null);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("MinOfCartAmount is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCouponMinOfCartAmountTest2() {
        try {
            new Coupon(BigDecimal.valueOf(10), BigDecimal.valueOf(-1));
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("MinOfCartAmount value can not be negative or zero!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCouponPriceDiscountAndMinOfCartAmountTest2() {
        try {
            new Coupon(BigDecimal.valueOf(100), BigDecimal.valueOf(10));
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("PriceDiscount value can not be equal or greater than MinOfCartAmount value!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
