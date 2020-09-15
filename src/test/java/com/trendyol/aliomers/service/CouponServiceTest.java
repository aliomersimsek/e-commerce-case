package com.trendyol.aliomers.service;

import com.trendyol.aliomers.entity.Coupon;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author aliomers on 14.09.2020
 */

public class CouponServiceTest {

    private static CouponService couponService = CouponService.getInstance();

    @Test
    public void successfulAddTest() {
        try {
            couponService.add(new Coupon(BigDecimal.valueOf(10), BigDecimal.valueOf(100)));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddCouponTest1() {
        try {
            couponService.add(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("Coupon can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddCouponTest2() {
        try {
            Optional<Coupon> coupon = couponService.list().stream().findFirst();
            couponService.add(coupon.get());
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Coupon is already exists!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteCouponTest1() {
        try {
            couponService.delete(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("Coupon can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteCouponTest2() {
        try {
            couponService.delete(new Coupon(BigDecimal.valueOf(100), BigDecimal.valueOf(1000)));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Coupon is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
