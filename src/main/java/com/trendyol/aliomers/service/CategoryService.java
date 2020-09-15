package com.trendyol.aliomers.service;

import com.trendyol.aliomers.creature.CategoryCreature;
import com.trendyol.aliomers.entity.Category;

import java.util.List;

/**
 * @author aliomers on 13.09.2020
 */

public class CategoryService extends AbstractService<Category> {

    private static CategoryService instance;
    private CategoryCreature categoryCreature;

    private CategoryService() {
        this.categoryCreature = new CategoryCreature();
    }

    public static CategoryService getInstance() {
        if (instance == null)
            instance = new CategoryService();
        return instance;
    }

    // Override Methods
    @Override
    public void add(Category category) {
        if (category == null) throw new NullPointerException("Category can not be null!");
        if (list().stream().anyMatch(c -> c.equals(category)))
            throw new RuntimeException("Category is already exists!");

        if (!categoryCreature.getList().contains(category)) {
            categoryCreature.add(category);
        }
    }

    @Override
    public void addAll(List<Category> categories) {
        if (categories == null) throw new NullPointerException("Categories can not be null!");

        categories.forEach(this::add);
    }

    @Override
    public void delete(Category category) {
        if (category == null) throw new NullPointerException("Category can not be null!");
        if (list().stream().noneMatch(c -> c.equals(category))) throw new RuntimeException("Category is not found!");

        categoryCreature.delete(category);
    }

    @Override
    public List<Category> list() {
        return categoryCreature.getList();
    }

}
