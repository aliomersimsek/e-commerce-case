package com.trendyol.aliomers.service;

import com.trendyol.aliomers.creature.DeliveryCreature;
import com.trendyol.aliomers.entity.Delivery;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author aliomers on 13.09.2020
 */

public class DeliveryService extends AbstractService<Delivery> {

    private static DeliveryService instance;
    private final DeliveryCreature deliveryCreature;

    private DeliveryService() {
        this.deliveryCreature = new DeliveryCreature();
    }

    public static DeliveryService getInstance() {
        if (instance == null)
            instance = new DeliveryService();
        return instance;
    }

    public BigDecimal getDeliveryCostConstant() {
        return deliveryCreature.getDeliveryCostConstant();
    }

    @Override
    public void add(Delivery delivery) {
        if (delivery == null) throw new NullPointerException("Delivery can not be null!");
        if (list().stream().anyMatch(d -> d.equals(delivery)))
            throw new RuntimeException("Delivery is already exists!");

        if (!deliveryCreature.getList().contains(delivery)) {
            deliveryCreature.add(delivery);
        }
    }

    @Override
    public void addAll(List<Delivery> deliverys) {
        if (deliverys == null) throw new NullPointerException("Deliverys can not be null!");

        deliverys.forEach(this::add);
    }

    @Override
    public void delete(Delivery delivery) {
        if (delivery == null) throw new NullPointerException("Delivery can not be null!");
        if (list().stream().noneMatch(c -> c.equals(delivery))) throw new RuntimeException("Delivery is not found!");

        deliveryCreature.delete(delivery);
    }

    @Override
    public List<Delivery> list() {
        return deliveryCreature.getList();
    }
}
