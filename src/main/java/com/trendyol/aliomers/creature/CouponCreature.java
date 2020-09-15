package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.Coupon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aliomers on 13.09.2020
 */

public class CouponCreature extends AbstractCreature<Coupon> {

    private static List<Coupon> coupons = new ArrayList<>();

    // Coupons
    public final static Coupon COUPON_100 = new Coupon(BigDecimal.valueOf(10), BigDecimal.valueOf(100));
    public final static Coupon COUPON_150 = new Coupon(BigDecimal.valueOf(15), BigDecimal.valueOf(150));
    public final static Coupon COUPON_200 = new Coupon(BigDecimal.valueOf(20), BigDecimal.valueOf(200));

    static {
        coupons.addAll(Arrays.asList(COUPON_100, COUPON_150, COUPON_200));
    }

    @Override
    public List<Coupon> getList() {
        return new ArrayList<>(coupons);
    }

    @Override
    public void add(Coupon coupon) {
        if (coupon == null) throw new NullPointerException("Coupon can not be null!");
        if (getList().stream().anyMatch(c -> c.equals(coupon))) throw new RuntimeException("Coupon is already exists!");
        coupons.add(coupon);
    }

    @Override
    public void delete(Coupon coupon) {
        if (coupon == null) throw new NullPointerException("Coupon can not be null!");
        if (getList().stream().noneMatch(c -> c.equals(coupon))) throw new RuntimeException("Coupon is not found!");
        getList().removeIf(c -> c.equals(coupon));
    }

}
