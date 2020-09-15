package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.Category;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @author aliomers on 14.09.2020
 */

public class CategoryCreatureTest {

    private static CategoryCreature categoryCreature = new CategoryCreature();

    @Test
    public void successfulAddTest1() {
        try {
            categoryCreature.add(new Category("successfulAddTest1", null));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfulAddTest2() {
        try {
            Optional<Category> category = categoryCreature.getList().stream().findAny();
            categoryCreature.add(new Category("successfulAddTest2", category.get()));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddCategoryTest1() {
        try {
            categoryCreature.add(null);
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
            Optional<Category> category = categoryCreature.getList().stream().findFirst();
            categoryCreature.add(category.get());
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
            categoryCreature.delete(null);
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
            categoryCreature.delete(new Category("category", null));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Category is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
