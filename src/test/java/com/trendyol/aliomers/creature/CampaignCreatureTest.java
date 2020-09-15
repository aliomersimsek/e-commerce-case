package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.Campaign;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static com.trendyol.aliomers.creature.CategoryCreature.C_FOOD;

/**
 * @author aliomers on 14.09.2020
 */

public class CampaignCreatureTest {

    private static CampaignCreature campaignCreature = new CampaignCreature();

    @Test
    public void successfulAddTest() {
        try {
            campaignCreature.add(new Campaign(C_FOOD, 10, 3));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddCampaignTest1() {
        try {
            campaignCreature.add(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("Campaign can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddCampaignTest2() {
        try {
            Optional<Campaign> campaign = campaignCreature.getList().stream().findFirst();
            campaignCreature.add(campaign.get());
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Campaign is already exists!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteCampaignTest1() {
        try {
            campaignCreature.delete(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("Campaign can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteCampaignTest2() {
        try {
            campaignCreature.delete(new Campaign(C_FOOD, 1, 1));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Campaign is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
