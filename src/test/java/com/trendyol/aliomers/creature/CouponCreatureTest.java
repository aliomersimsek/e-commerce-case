package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.Coupon;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author aliomers on 14.09.2020
 */

public class CouponCreatureTest {

    private static CouponCreature couponCreature = new CouponCreature();

    @Test
    public void successfulAddTest() {
        try {
            couponCreature.add(new Coupon(BigDecimal.valueOf(10), BigDecimal.valueOf(100)));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddCouponTest1() {
        try {
            couponCreature.add(null);
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
            Optional<Coupon> coupon = couponCreature.getList().stream().findFirst();
            couponCreature.add(coupon.get());
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
            couponCreature.delete(null);
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
            couponCreature.delete(new Coupon(BigDecimal.valueOf(100), BigDecimal.valueOf(1000)));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Coupon is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
