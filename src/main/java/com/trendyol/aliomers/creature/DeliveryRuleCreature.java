package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.DeliveryRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aliomers on 14.09.2020
 */

public class DeliveryRuleCreature extends AbstractCreature<DeliveryRule> {

    private static List<DeliveryRule> deliveryRules = new ArrayList<>();

    // DeliveryRule Cost Rules
    public final static DeliveryRule FACTOR_NUM_OF_DELIVERY_RULE = new DeliveryRule(2, 3, DeliveryRule.RuleType.DELIVERY_COUNT);
    public final static DeliveryRule FACTOR_NUM_OF_PRODUCT_1 = new DeliveryRule(10, 2, DeliveryRule.RuleType.PRODUCT_COUNT);
    public final static DeliveryRule FACTOR_NUM_OF_PRODUCT_2 = new DeliveryRule(20, 3, DeliveryRule.RuleType.PRODUCT_COUNT);

    static {
        deliveryRules.addAll(Arrays.asList(FACTOR_NUM_OF_DELIVERY_RULE, FACTOR_NUM_OF_PRODUCT_1, FACTOR_NUM_OF_PRODUCT_2));
    }

    @Override
    public List<DeliveryRule> getList() {
        return new ArrayList<>(deliveryRules);
    }

    @Override
    public void add(DeliveryRule deliveryRule) {
        if (deliveryRule == null) throw new NullPointerException("DeliveryRule can not be null!");
        if (getList().stream().anyMatch(d -> d.equals(deliveryRule)))
            throw new RuntimeException("DeliveryRule is already exists!");
        deliveryRules.add(deliveryRule);
    }

    @Override
    public void delete(DeliveryRule deliveryRule) {
        if (deliveryRule == null) throw new NullPointerException("DeliveryRule can not be null!");
        if (getList().stream().noneMatch(d -> d.equals(deliveryRule)))
            throw new RuntimeException("DeliveryRule is not found!");
        getList().removeIf(d -> d.equals(deliveryRule));
    }

}