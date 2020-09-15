package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.DeliveryRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @author aliomers on 14.09.2020
 */

public class DeliveryRuleCreatureTest {

    private static DeliveryRuleCreature deliveryRuleCreature = new DeliveryRuleCreature();

    @Test
    public void successfulAddTest() {
        try {
            deliveryRuleCreature.add(new DeliveryRule(10, 3, DeliveryRule.RuleType.DELIVERY_COUNT));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddDeliveryRuleTest1() {
        try {
            deliveryRuleCreature.add(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("DeliveryRule can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddDeliveryRuleTest2() {
        try {
            Optional<DeliveryRule> deliveryRule = deliveryRuleCreature.getList().stream().findFirst();
            deliveryRuleCreature.add(deliveryRule.get());
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("DeliveryRule is already exists!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteDeliveryRuleTest1() {
        try {
            deliveryRuleCreature.delete(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("DeliveryRule can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteDeliveryRuleTest2() {
        try {
            deliveryRuleCreature.delete(new DeliveryRule(1, 1, DeliveryRule.RuleType.DELIVERY_COUNT));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("DeliveryRule is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
