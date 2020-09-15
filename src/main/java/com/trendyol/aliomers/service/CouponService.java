package com.trendyol.aliomers.service;

import com.trendyol.aliomers.creature.CouponCreature;
import com.trendyol.aliomers.entity.Coupon;

import java.util.List;

/**
 * @author aliomers on 13.09.2020
 */

public class CouponService extends AbstractService<Coupon> {

    private static CouponService instance;
    private final CouponCreature couponCreature;

    private CouponService() {
        this.couponCreature = new CouponCreature();
    }

    public static CouponService getInstance() {
        if (instance == null)
            instance = new CouponService();
        return instance;
    }

    // Override Methods
    @Override
    public void add(Coupon coupon) {
        if (coupon == null) throw new NullPointerException("Coupon can not be null!");
        if (list().stream().anyMatch(c -> c.equals(coupon))) throw new RuntimeException("Coupon is already exists!");

        if (!couponCreature.getList().contains(coupon)) {
            couponCreature.add(coupon);
        }
    }

    @Override
    public void addAll(List<Coupon> coupons) {
        if (coupons == null) throw new NullPointerException("Coupons can not be null!");

        coupons.forEach(this::add);
    }

    @Override
    public void delete(Coupon coupon) {
        if (coupon == null) throw new NullPointerException("Coupon can not be null!");
        if (list().stream().noneMatch(c -> c.equals(coupon))) throw new RuntimeException("Coupon is not found!");

        couponCreature.delete(coupon);
    }

    @Override
    public List<Coupon> list() {
        return couponCreature.getList();
    }

}
