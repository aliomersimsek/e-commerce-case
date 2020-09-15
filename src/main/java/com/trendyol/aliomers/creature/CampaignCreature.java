package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.Campaign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.trendyol.aliomers.creature.CategoryCreature.*;

/**
 * @author aliomers on 13.09.2020
 */

public class CampaignCreature extends AbstractCreature<Campaign> {

    private static List<Campaign> campaigns = new ArrayList<>();

    // Campaigns
    public final static Campaign CAMPAIGN_FOOD = new Campaign(C_FOOD, 10, 2);
    public final static Campaign CAMPAIGN_FOOD_2 = new Campaign(C_FOOD, 20, 3);
    public final static Campaign CAMPAIGN_TECH = new Campaign(C_TECH, 5, 3);
    public final static Campaign CAMPAIGN_DRINKS = new Campaign(C_DRINKS, 7, 4);
    public final static Campaign CAMPAIGN_TEXTILE = new Campaign(C_TEXTILE, 6, 5);

    static {
        campaigns.addAll(Arrays.asList(CAMPAIGN_FOOD, CAMPAIGN_FOOD_2, CAMPAIGN_TECH, CAMPAIGN_DRINKS, CAMPAIGN_TEXTILE));
    }

    @Override
    public List<Campaign> getList() {
        return new ArrayList<>(campaigns);
    }

    @Override
    public void add(Campaign campaign) {
        if (campaign == null) throw new NullPointerException("Campaign can not be null!");
        if (getList().stream().anyMatch(c -> c.equals(campaign)))
            throw new RuntimeException("Campaign is already exists!");
        campaigns.add(campaign);
    }

    @Override
    public void delete(Campaign campaign) {
        if (campaign == null) throw new NullPointerException("Campaign can not be null!");
        if (getList().stream().noneMatch(c -> c.equals(campaign))) throw new RuntimeException("Campaign is not found!");
        getList().removeIf(c -> c.equals(campaign));
    }

}
