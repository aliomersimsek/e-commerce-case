package com.trendyol.aliomers.entity;

import java.math.BigDecimal;

/**
 * @author aliomers on 12.09.2020
 */

public class Product extends AbstractEntity {

    private final String title;
    private final BigDecimal price;
    private final Category category;

    public Product(String title, BigDecimal price, Category category) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title is not valid!");
        if (price == null) throw new IllegalArgumentException("Price is not valid!");
        if (price.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Price value can not be negative or zero!");
        if (category == null) throw new IllegalArgumentException("Category can not be null!");

        this.title = title;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "{" + title + " - " + category + " : " + price + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            return this.title.equals(((Product) obj).title)
                    && this.price.equals(((Product) obj).price)
                    && this.category.equals(((Product) obj).category);
        }
        return false;
    }
}
