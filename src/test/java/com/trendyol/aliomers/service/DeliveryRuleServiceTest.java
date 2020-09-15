package com.trendyol.aliomers.service;

import com.trendyol.aliomers.entity.DeliveryRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @author aliomers on 14.09.2020
 */

public class DeliveryRuleServiceTest {

    private static DeliveryRuleService deliveryRuleService = DeliveryRuleService.getInstance();

    @Test
    public void successfulAddTest() {
        try {
            deliveryRuleService.add(new DeliveryRule(100, 3, DeliveryRule.RuleType.DELIVERY_COUNT));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddDeliveryTest1() {
        try {
            deliveryRuleService.add(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("DeliveryRule can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddDeliveryTest2() {
        try {
            Optional<DeliveryRule> delivery = deliveryRuleService.list().stream().findFirst();
            deliveryRuleService.add(delivery.get());
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("DeliveryRule is already exists!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteDeliveryTest1() {
        try {
            deliveryRuleService.delete(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("DeliveryRule can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteDeliveryTest2() {
        try {
            deliveryRuleService.delete(new DeliveryRule(1, 1, DeliveryRule.RuleType.DELIVERY_COUNT));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("DeliveryRule is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
