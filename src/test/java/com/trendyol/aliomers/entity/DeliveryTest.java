package com.trendyol.aliomers.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author aliomers on 13.09.2020
 */

public class DeliveryTest {

    @Test
    public void successfulInstanceCreationTest() {
        try {
            new Delivery("successfulInstanceCreationTest",
                    "successfulInstanceCreationTest",
                    "successfulInstanceCreationTest");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryCountryTest1() {
        try {
            new Delivery(null,
                    "successfulInstanceCreationTest",
                    "successfulInstanceCreationTest");
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Country is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryCountryTest2() {
        try {
            new Delivery("",
                    "successfulInstanceCreationTest",
                    "successfulInstanceCreationTest");
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Country is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryCountryTest3() {
        try {
            new Delivery(" ",
                    "successfulInstanceCreationTest",
                    "successfulInstanceCreationTest");
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Country is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryCityTest1() {
        try {
            new Delivery("successfulInstanceCreationTest",
                    null,
                    "successfulInstanceCreationTest");
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("City is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryCityTest2() {
        try {
            new Delivery("successfulInstanceCreationTest",
                    "",
                    "successfulInstanceCreationTest");
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("City is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryCityTest3() {
        try {
            new Delivery("successfulInstanceCreationTest",
                    " ",
                    "successfulInstanceCreationTest");
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("City is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryZipCodeTest1() {
        try {
            new Delivery("successfulInstanceCreationTest",
                    "successfulInstanceCreationTest",
                    null);
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("ZipCode is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryZipCodeTest2() {
        try {
            new Delivery("successfulInstanceCreationTest",
                    "successfulInstanceCreationTest",
                    "");
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("ZipCode is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidDeliveryZipCodeTest3() {
        try {
            new Delivery("successfulInstanceCreationTest",
                    "successfulInstanceCreationTest",
                    " ");
            Assert.fail("An exception is excepted here!");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("ZipCode is not valid!", e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
