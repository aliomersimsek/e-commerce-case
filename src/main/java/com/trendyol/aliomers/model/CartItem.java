package com.trendyol.aliomers.model;

import com.trendyol.aliomers.entity.Product;

import java.math.BigDecimal;

/**
 * @author aliomers on 12.09.2020
 */

public class CartItem extends Product {

    private Integer quantity;
    private BigDecimal cost;
    private Integer discountRate;
    private BigDecimal priceWithDiscount = null;

    public CartItem(Product product, Integer quantity) {
        super(product.getTitle(), product.getPrice(), product.getCategory());

        if (quantity == null) throw new IllegalArgumentException("Quantity is not valid!");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity value can not be negative or zero!");

        this.quantity = quantity;
        this.cost = this.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    // Getters
    public Product getProduct() {
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    // Setters
    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public void addQuantityAndCost(Integer quantity) {
        this.quantity = this.quantity + quantity;
        this.cost = this.cost.add(this.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return quantity + " x " +
                "{" +
                getTitle() + "(" +
                getCategory() + "): " +
                getPrice() + " $ " +
                (priceWithDiscount != null ? String.format("-> with %%%s discount : %s $", discountRate, priceWithDiscount) : "") +
                "}";
    }
}
