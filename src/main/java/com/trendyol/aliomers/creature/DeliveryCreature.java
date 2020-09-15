package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.Delivery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aliomers on 14.09.2020
 */

public class DeliveryCreature extends AbstractCreature<Delivery> {

    private final BigDecimal DELIVERY_COST_CONSTANT = BigDecimal.TEN;
    private static List<Delivery> deliverys = new ArrayList<>();

    // Delivery Cost Rules
    public final static Delivery TURKEY_ANKARA_06800 = new Delivery("Turkey", "Ankara", "06800");
    public final static Delivery TURKEY_ISTANBUL_34500 = new Delivery("Turkey", "Istanbul", "34500");
    public final static Delivery TURKEY_ANKARA_06850 = new Delivery("Turkey", "Ankara", "06850");
    public final static Delivery TURKEY_ISTANBUL_34700 = new Delivery("Turkey", "Istanbul", "34700");

    static {
        deliverys.addAll(Arrays.asList(TURKEY_ANKARA_06800, TURKEY_ISTANBUL_34500, TURKEY_ANKARA_06850, TURKEY_ISTANBUL_34700));
    }

    @Override
    public List<Delivery> getList() {
        return new ArrayList<>(deliverys);
    }

    @Override
    public void add(Delivery delivery) {
        if (delivery == null) throw new NullPointerException("Delivery can not be null!");
        if (getList().stream().anyMatch(d -> d.equals(delivery)))
            throw new RuntimeException("Delivery is already exists!");
        deliverys.add(delivery);
    }

    @Override
    public void delete(Delivery delivery) {
        if (delivery == null) throw new NullPointerException("Delivery can not be null!");
        if (getList().stream().noneMatch(d -> d.equals(delivery))) throw new RuntimeException("Delivery is not found!");
        getList().removeIf(d -> d.equals(delivery));
    }

    public BigDecimal getDeliveryCostConstant() {
        return DELIVERY_COST_CONSTANT;
    }
}