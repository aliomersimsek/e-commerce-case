package com.trendyol.aliomers.service;

import com.trendyol.aliomers.entity.Campaign;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static com.trendyol.aliomers.creature.CategoryCreature.C_FOOD;

/**
 * @author aliomers on 14.09.2020
 */

public class CampaignServiceTest {

    private static CampaignService campaignService = CampaignService.getInstance();

    @Test
    public void successfulAddTest() {
        try {
            campaignService.add(new Campaign(C_FOOD, 100, 3));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddCampaignTest1() {
        try {
            campaignService.add(null);
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
            Optional<Campaign> campaign = campaignService.list().stream().findFirst();
            campaignService.add(campaign.get());
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
            campaignService.delete(null);
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
            campaignService.delete(new Campaign(C_FOOD, 1, 1));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Campaign is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
