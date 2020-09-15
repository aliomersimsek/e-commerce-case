package com.trendyol.aliomers.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author aliomers on 13.09.2020
 */

public class DeliveryRuleTest {

    @Test
    public void successfulInstanceCreationTest() {
        try {
            new DeliveryRule(10, 3, DeliveryRule.RuleType.DELIVERY_COUNT);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryRuleControlValueTest1() {
        try {
            new DeliveryRule(null, 3, DeliveryRule.RuleType.DELIVERY_COUNT);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("ControlValue is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryRuleControlValueTest2() {
        try {
            new DeliveryRule(-1, 3, DeliveryRule.RuleType.DELIVERY_COUNT);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("ControlValue value can not be negative or zero!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryRuleIncreaseRateValueTest1() {
        try {
            new DeliveryRule(10, null, DeliveryRule.RuleType.DELIVERY_COUNT);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("IncreaseRateValue is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryRuleIncreaseRateValueTest2() {
        try {
            new DeliveryRule(10, -1, DeliveryRule.RuleType.DELIVERY_COUNT);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("IncreaseRateValue value can not be negative or zero!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryRuleRuleTypeTest() {
        try {
            new DeliveryRule(10, 3, null);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("RuleType is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
