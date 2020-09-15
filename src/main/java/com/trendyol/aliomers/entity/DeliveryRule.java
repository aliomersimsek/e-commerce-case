package com.trendyol.aliomers.entity;

/**
 * @author aliomers on 13.09.2020
 */

public class DeliveryRule extends AbstractEntity {

    private final Integer controlValue;
    private final Integer increaseRateValue;
    private final RuleType ruleType;

    public enum RuleType {PRODUCT_COUNT, DELIVERY_COUNT;}

    public DeliveryRule(Integer controlValue, Integer increaseRateValue, RuleType ruleType) {
        if (controlValue == null) throw new IllegalArgumentException("ControlValue is not valid!");
        if (controlValue <= 0) throw new IllegalArgumentException("ControlValue value can not be negative or zero!");
        if (increaseRateValue == null) throw new IllegalArgumentException("IncreaseRateValue is not valid!");
        if (increaseRateValue <= 0)
            throw new IllegalArgumentException("IncreaseRateValue value can not be negative or zero!");
        if (ruleType == null) throw new IllegalArgumentException("RuleType is not valid!");

        this.controlValue = controlValue;
        this.increaseRateValue = increaseRateValue;
        this.ruleType = ruleType;
    }

    public Integer getControlValue() {
        return controlValue;
    }

    public Integer getIncreaseRateValue() {
        return increaseRateValue;
    }

    public RuleType getRuleType() {
        return ruleType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DeliveryRule) {
            return this.controlValue.equals(((DeliveryRule) obj).controlValue)
                    && this.increaseRateValue.equals(((DeliveryRule) obj).increaseRateValue)
                    && this.ruleType.equals(((DeliveryRule) obj).ruleType);
        }
        return false;
    }

    @Override
    public String toString() {
        return "DeliveryRule{" +
                "controlValue=" + controlValue +
                ", increaseRateValue=" + increaseRateValue +
                ", ruleType=" + ruleType +
                '}';
    }
}
