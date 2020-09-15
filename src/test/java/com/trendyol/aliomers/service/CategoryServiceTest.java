package com.trendyol.aliomers.service;

import com.trendyol.aliomers.entity.Category;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @author aliomers on 14.09.2020
 */

public class CategoryServiceTest {

    private static CategoryService categoryService = CategoryService.getInstance();

    @Test
    public void successfulAddTest1() {
        try {
            categoryService.add(new Category("CategoryServiceTest_successfulAddTest1", null));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfulAddTest2() {
        try {
            Optional<Category> category = categoryService.list().stream().findAny();
            categoryService.add(new Category("CategoryServiceTest_successfulAddTest2", category.get()));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddCategoryTest1() {
        try {
            categoryService.add(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("Category can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddCategoryTest2() {
        try {
            Optional<Category> category = categoryService.list().stream().findFirst();
            categoryService.add(category.get());
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Category is already exists!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteCategoryTest1() {
        try {
            categoryService.delete(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("Category can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteCategoryTest2() {
        try {
            categoryService.delete(new Category("category", null));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Category is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
