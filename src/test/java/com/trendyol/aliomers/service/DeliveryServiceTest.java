package com.trendyol.aliomers.service;

import com.trendyol.aliomers.entity.Delivery;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @author aliomers on 14.09.2020
 */

public class DeliveryServiceTest {

    private static DeliveryService deliveryService = DeliveryService.getInstance();

    @Test
    public void successfulAddTest() {
        try {
            deliveryService.add(new Delivery("DeliveryServiceTest_successfulAddTest",
                    "DeliveryServiceTest_successfulAddTest",
                    "DeliveryServiceTest_successfulAddTest"));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddDeliveryTest1() {
        try {
            deliveryService.add(null);
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
            Optional<Delivery> delivery = deliveryService.list().stream().findFirst();
            deliveryService.add(delivery.get());
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
            deliveryService.delete(null);
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
            deliveryService.delete(new Delivery(
                    "DeliveryServiceTest_invalidDeleteDeliveryTest2",
                    "DeliveryServiceTest_invalidDeleteDeliveryTest2",
                    "DeliveryServiceTest_invalidDeleteDeliveryTest2"));
            Assert.fail("An exception is excepted here!");
        } catch (RuntimeException e) {
            Assert.assertEquals("Delivery is not found!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
