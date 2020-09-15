package com.trendyol.aliomers.service;

import com.trendyol.aliomers.creature.DeliveryRuleCreature;
import com.trendyol.aliomers.entity.DeliveryRule;

import java.util.List;

/**
 * @author aliomers on 13.09.2020
 */

public class DeliveryRuleService extends AbstractService<DeliveryRule> {

    private static DeliveryRuleService instance;
    private final DeliveryRuleCreature deliveryRuleCreature;

    private DeliveryRuleService() {
        this.deliveryRuleCreature = new DeliveryRuleCreature();
    }

    public static DeliveryRuleService getInstance() {
        if (instance == null)
            instance = new DeliveryRuleService();
        return instance;
    }

    @Override
    public void add(DeliveryRule deliveryRule) {
        if (deliveryRule == null) throw new NullPointerException("DeliveryRule can not be null!");
        if (list().stream().anyMatch(d -> d.equals(deliveryRule)))
            throw new RuntimeException("DeliveryRule is already exists!");

        if (!deliveryRuleCreature.getList().contains(deliveryRule)) {
            deliveryRuleCreature.add(deliveryRule);
        }
    }

    @Override
    public void addAll(List<DeliveryRule> deliveryRules) {
        if (deliveryRules == null) throw new NullPointerException("DeliveryRules can not be null!");

        deliveryRules.forEach(this::add);
    }

    @Override
    public void delete(DeliveryRule deliveryRule) {
        if (deliveryRule == null) throw new NullPointerException("DeliveryRule can not be null!");
        if (list().stream().noneMatch(c -> c.equals(deliveryRule)))
            throw new RuntimeException("DeliveryRule is not found!");

        deliveryRuleCreature.delete(deliveryRule);
    }

    @Override
    public List<DeliveryRule> list() {
        return deliveryRuleCreature.getList();
    }
}
