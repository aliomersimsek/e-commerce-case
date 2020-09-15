package com.trendyol.aliomers.service;

import com.trendyol.aliomers.creature.CampaignCreature;
import com.trendyol.aliomers.entity.Campaign;

import java.util.List;

/**
 * @author aliomers on 13.09.2020
 */

public class CampaignService extends AbstractService<Campaign> {

    private static CampaignService instance;
    private final CampaignCreature campaignCreature;

    private CampaignService() {
        this.campaignCreature = new CampaignCreature();
    }

    public static CampaignService getInstance() {
        if (instance == null)
            instance = new CampaignService();
        return instance;
    }

    // Override Methods
    @Override
    public void add(Campaign campaign) {
        if (campaign == null) throw new NullPointerException("Campaign can not be null!");
        if (list().stream().anyMatch(c -> c.equals(campaign)))
            throw new RuntimeException("Campaign is already exists!");

        if (!campaignCreature.getList().contains(campaign)) {
            campaignCreature.add(campaign);
        }
    }

    @Override
    public void addAll(List<Campaign> campaigns) {
        if (campaigns == null) throw new NullPointerException("Campaigns can not be null!");

        campaigns.forEach(this::add);
    }

    @Override
    public void delete(Campaign campaign) {
        if (campaign == null) throw new NullPointerException("Campaign can not be null!");
        if (list().stream().noneMatch(c -> c.equals(campaign))) throw new RuntimeException("Campaign is not found!");

        campaignCreature.delete(campaign);
    }

    @Override
    public List<Campaign> list() {
        return campaignCreature.getList();
    }

}
