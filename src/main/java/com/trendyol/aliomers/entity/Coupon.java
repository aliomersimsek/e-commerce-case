package com.trendyol.aliomers.entity;

import java.math.BigDecimal;

/**
 * @author aliomers on 12.09.2020
 */

public class Coupon extends AbstractEntity {

    private final BigDecimal priceDiscount;
    private final BigDecimal minOfCartAmount;

    public Coupon(BigDecimal priceDiscount, BigDecimal minOfCartAmount) {
        if (priceDiscount == null) throw new IllegalArgumentException("PriceDiscount is not valid!");
        if (priceDiscount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("PriceDiscount value can not be negative or zero!");
        if (minOfCartAmount == null) throw new IllegalArgumentException("MinOfCartAmount is not valid!");
        if (minOfCartAmount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("MinOfCartAmount value can not be negative or zero!");
        if (priceDiscount.compareTo(minOfCartAmount) >= 0)
            throw new IllegalArgumentException("PriceDiscount value can not be equal or greater than MinOfCartAmount value!");

        this.priceDiscount = priceDiscount;
        this.minOfCartAmount = minOfCartAmount;
    }

    public BigDecimal getPriceDiscount() {
        return priceDiscount;
    }

    public BigDecimal getMinOfCartAmount() {
        return minOfCartAmount;
    }

    @Override
    public String toString() {
        return "Coupon {" +
                "PriceDiscount: " + priceDiscount +
                ", MinOfCartAmount: " + minOfCartAmount +
                "}";
    }
}
