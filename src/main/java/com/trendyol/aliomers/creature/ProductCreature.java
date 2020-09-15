package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aliomers on 13.09.2020
 */

public class ProductCreature extends AbstractCreature<Product> {

    private static List<Product> products = new ArrayList<>();

    // Products
    public final static Product APPLE = new Product("Apple", BigDecimal.valueOf(10), CategoryCreature.C_FOOD);
    public final static Product CAKE = new Product("Cake", BigDecimal.valueOf(5), CategoryCreature.C_FOOD);
    public final static Product ALMONDS = new Product("Almonds", BigDecimal.valueOf(15), CategoryCreature.C_FOOD);
    public final static Product MOTHERBOARD = new Product("Motherboard", BigDecimal.valueOf(2200), CategoryCreature.C_TECH);
    public final static Product HDD = new Product("HDD", BigDecimal.valueOf(1100), CategoryCreature.C_TECH);
    public final static Product CPU = new Product("CPU", BigDecimal.valueOf(1850), CategoryCreature.C_TECH);
    public final static Product TSHIRT = new Product("T-Shirt", BigDecimal.valueOf(14.99), CategoryCreature.C_TEXTILE);
    public final static Product SHIRT = new Product("Shirt", BigDecimal.valueOf(17.99), CategoryCreature.C_TEXTILE);
    public final static Product WATER = new Product("Water", BigDecimal.valueOf(2.9), CategoryCreature.C_DRINKS);
    public final static Product TEA = new Product("Tea", BigDecimal.valueOf(9.9), CategoryCreature.C_HOT_DRINKS);
    public final static Product COFFEE = new Product("Coffee", BigDecimal.valueOf(12.9), CategoryCreature.C_HOT_DRINKS);
    public final static Product ICELATTE = new Product("Ice-Latte", BigDecimal.valueOf(14.9), CategoryCreature.C_COLD_COFFEE_DRINKS);

    static {
        products.addAll(Arrays.asList(APPLE, ALMONDS, MOTHERBOARD, HDD, CPU, TSHIRT, SHIRT, WATER, TEA, COFFEE, ICELATTE));
    }

    @Override
    public List<Product> getList() {
        return new ArrayList<>(products);
    }

    @Override
    public void add(Product product) {
        if (product == null) throw new NullPointerException("Product can not be null!");
        if (getList().stream().anyMatch(p -> p.equals(product)))
            throw new RuntimeException("Product is already exists!");
        products.add(product);
    }

    @Override
    public void delete(Product product) {
        if (product == null) throw new NullPointerException("Product can not be null!");
        if (getList().stream().noneMatch(p -> p.equals(product))) throw new RuntimeException("Product is not found!");
        getList().removeIf(c -> c.equals(product));
    }

}
