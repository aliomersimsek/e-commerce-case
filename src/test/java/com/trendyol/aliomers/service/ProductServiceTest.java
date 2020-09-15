package com.trendyol.aliomers.service;

import com.trendyol.aliomers.creature.CategoryCreature;
import com.trendyol.aliomers.entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author aliomers on 14.09.2020
 */

public class ProductServiceTest {

    private static ProductService productService = ProductService.getInstance();

    @Test
    public void successfulAddTest() {
        try {
            productService.add(new Product("ProductServiceTest_successfulAddTest", BigDecimal.valueOf(10), CategoryCreature.C_FOOD));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddProductTest1() {
        try {
            productService.add(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("Product can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddProductTest2() {
        try {
            Optional<Product> product = productService.list().stream().findFirst();
            productService.add(product.get());
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Product is already exists!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteProductTest1() {
        try {
            productService.delete(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("Product can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteProductTest2() {
        try {
            productService.delete(new Product("invalidDeleteProductTest2", BigDecimal.valueOf(10), CategoryCreature.C_FOOD));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Product is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
