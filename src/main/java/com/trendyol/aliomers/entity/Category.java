package com.trendyol.aliomers.entity;

/**
 * @author aliomers on 12.09.2020
 */

public class Category extends AbstractEntity {

    private final String title;
    private final Category parentCategory;

    public Category(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title is not valid!");

        this.title = title;
        this.parentCategory = null;
    }

    public Category(String title, Category category) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title is not valid!");

        this.title = title;
        this.parentCategory = category;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Category) {
            return this.title.equals(((Category) obj).title);
        }
        return false;
    }
}
