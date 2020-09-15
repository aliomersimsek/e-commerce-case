package com.trendyol.aliomers.entity;

import org.junit.Assert;
import org.junit.Test;

import static com.trendyol.aliomers.creature.CategoryCreature.C_FOOD;

/**
 * @author aliomers on 13.09.2020
 */

public class CategoryTest {

    @Test
    public void successfulInstanceCreationTest1() {
        try {
            new Category("category");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfulInstanceCreationTest2() {
        try {
            new Category("category", C_FOOD);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCategoryTitleTest1() {
        try {
            new Category(null);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Title is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCategoryTitleTest2() {
        try {
            new Category("");
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Title is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCategoryTitleTest3() {
        try {
            new Category(" ");
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Title is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCategoryTitleTest4() {
        try {
            new Category(null, C_FOOD);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Title is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCategoryTitleTest5() {
        try {
            new Category("", C_FOOD);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Title is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCategoryTitleTest6() {
        try {
            new Category(" ", C_FOOD);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Title is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
