package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aliomers on 13.09.2020
 */

public class CategoryCreature extends AbstractCreature<Category> {

    private static List<Category> categories = new ArrayList<>();

    // Categories
    public final static Category C_FOOD = new Category("food");
    public final static Category C_TEXTILE = new Category("textile");
    public final static Category C_TECH = new Category("tech");
    public final static Category C_DRINKS = new Category("drinks");
    public final static Category C_HOT_DRINKS = new Category("hot_drinks", C_DRINKS);
    public final static Category C_COLD_DRINKS = new Category("cold_drinks", C_DRINKS);
    public final static Category C_COLD_COFFEE_DRINKS = new Category("cold_coffee_drinks", C_COLD_DRINKS);

    static {
        categories.addAll(Arrays.asList(C_FOOD, C_TEXTILE, C_TECH, C_DRINKS, C_HOT_DRINKS, C_COLD_DRINKS, C_COLD_COFFEE_DRINKS));
    }

    @Override
    public List<Category> getList() {
        return new ArrayList<>(categories);
    }

    @Override
    public void add(Category category) {
        if (category == null) throw new NullPointerException("Category can not be null!");
        if (getList().stream().anyMatch(c -> c.equals(category)))
            throw new RuntimeException("Category is already exists!");
        categories.add(category);
    }

    @Override
    public void delete(Category category) {
        if (category == null) throw new NullPointerException("Category can not be null!");
        if (getList().stream().noneMatch(c -> c.equals(category))) throw new RuntimeException("Category is not found!");
        getList().removeIf(c -> c.equals(category));
    }

}
