package com.trendyol.aliomers.creature;

import com.trendyol.aliomers.entity.Delivery;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @author aliomers on 14.09.2020
 */

public class DeliveryCreatureTest {

    private static DeliveryCreature deliveryCreature = new DeliveryCreature();

    @Test
    public void successfulAddTest() {
        try {
            deliveryCreature.add(new Delivery("DeliveryCreatureTest_successfulAddTest",
                    "DeliveryCreatureTest_successfulAddTest",
                    "DeliveryCreatureTest_successfulAddTest"));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddDeliveryTest1() {
        try {
            deliveryCreature.add(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("Delivery can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddDeliveryTest2() {
        try {
            Optional<Delivery> delivery = deliveryCreature.getList().stream().findFirst();
            deliveryCreature.add(delivery.get());
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Delivery is already exists!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteDeliveryTest1() {
        try {
            deliveryCreature.delete(null);
            Assert.fail("An exception is excepted here!");
        } catch (NullPointerException e) {
            Assert.assertEquals("Delivery can not be null!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeleteDeliveryTest2() {
        try {
            deliveryCreature.delete(new Delivery(
                    "DeliveryCreatureTest_invalidDeleteDeliveryTest2",
                    "DeliveryCreatureTest_invalidDeleteDeliveryTest2",
                    "DeliveryCreatureTest_invalidDeleteDeliveryTest2"));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Delivery is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
