package com.trendyol.aliomers.entity;

import org.junit.Assert;
import org.junit.Test;

import static com.trendyol.aliomers.creature.CategoryCreature.C_FOOD;

/**
 * @author aliomers on 13.09.2020
 */

public class CampaignTest {

    @Test
    public void successfulInstanceCreationTest() {
        try {
            new Campaign(C_FOOD, 10, 3);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCampaignApplicableCategoryTest1() {
        try {
            new Campaign(null, 10, 3);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Category can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCampaignNumOfProductTest1() {
        try {
            new Campaign(C_FOOD, null, 3);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("NumOfProduct is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCampaignNumOfProductTest2() {
        try {
            new Campaign(C_FOOD, -1, 3);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("NumOfProduct value can not be negative or zero!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCampaignDiscountFactorTest1() {
        try {
            new Campaign(C_FOOD, 10, null);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("DiscountFactor is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidCampaignDiscountFactorTest2() {
        try {
            new Campaign(C_FOOD, 10, -1);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("DiscountFactor value can not be negative or zero!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
