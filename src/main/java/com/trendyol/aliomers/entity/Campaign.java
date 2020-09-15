package com.trendyol.aliomers.entity;

/**
 * @author aliomers on 12.09.2020
 */

public class Campaign extends AbstractEntity {

    private final Category applicableCategory;
    private final Integer numOfProduct;
    private final Integer discountFactor;

    public Campaign(Category category, Integer numOfProduct, Integer discountFactor) {
        if (category == null) throw new IllegalArgumentException("Category can not be null!");
        if (numOfProduct == null) throw new IllegalArgumentException("NumOfProduct is not valid!");
        if (numOfProduct <= 0) throw new IllegalArgumentException("NumOfProduct value can not be negative or zero!");
        if (discountFactor == null) throw new IllegalArgumentException("DiscountFactor is not valid!");
        if (discountFactor <= 0)
            throw new IllegalArgumentException("DiscountFactor value can not be negative or zero!");

        this.applicableCategory = category;
        this.numOfProduct = numOfProduct;
        this.discountFactor = discountFactor;
    }

    public Category getApplicableCategory() {
        return applicableCategory;
    }

    public Integer getNumOfProduct() {
        return numOfProduct;
    }

    public Integer getDiscountFactor() {
        return discountFactor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Campaign) {
            return this.applicableCategory.equals(((Campaign) obj).applicableCategory)
                    && this.numOfProduct.equals(((Campaign) obj).numOfProduct)
                    && this.discountFactor.equals(((Campaign) obj).discountFactor);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Campaign {" +
                "Applicable Category: " + applicableCategory +
                ", Product Count : " + numOfProduct +
                ", Discount Factor: " + discountFactor +
                "}";
    }
}
