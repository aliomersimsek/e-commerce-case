package com.trendyol.aliomers.service;

import com.trendyol.aliomers.creature.ProductCreature;
import com.trendyol.aliomers.entity.Product;

import java.util.List;

/**
 * @author aliomers on 13.09.2020
 */

public class ProductService extends AbstractService<Product> {

    private static ProductService instance;
    private ProductCreature productCreature;

    private ProductService() {
        this.productCreature = new ProductCreature();
    }

    public static ProductService getInstance() {
        if (instance == null)
            instance = new ProductService();
        return instance;
    }

    // Override Methods
    @Override
    public void add(Product product) {
        if (product == null) throw new NullPointerException("Product can not be null!");
        if (list().stream().anyMatch(p -> p.equals(product))) throw new RuntimeException("Product is already exists!");

        if (!productCreature.getList().contains(product)) {
            productCreature.add(product);
        }
    }

    @Override
    public void addAll(List<Product> products) {
        if (products == null) throw new NullPointerException("Products can not be null!");

        products.forEach(this::add);
    }

    @Override
    public void delete(Product product) {
        if (product == null) throw new NullPointerException("Product can not be null!");
        if (list().stream().noneMatch(c -> c.equals(product))) throw new RuntimeException("Product is not found!");

        productCreature.delete(product);
    }

    @Override
    public List<Product> list() {
        return productCreature.getList();
    }

}
