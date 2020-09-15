package com.trendyol.aliomers.entity;

/**
 * @author aliomers on 13.09.2020
 */

public class Delivery extends AbstractEntity {

    private final String country;
    private final String city;
    private final String zipCode;

    public Delivery(String country, String city, String zipCode) {
        if (country == null || country.trim().isEmpty()) throw new IllegalArgumentException("Country is not valid!");
        if (city == null || city.trim().isEmpty()) throw new IllegalArgumentException("City is not valid!");
        if (zipCode == null || zipCode.trim().isEmpty()) throw new IllegalArgumentException("ZipCode is not valid!");

        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Delivery) {
            return this.country.equals(((Delivery) obj).country)
                    && this.city.equals(((Delivery) obj).city)
                    && this.zipCode.equals(((Delivery) obj).zipCode);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Delivery {" +
                "country: '" + country + '\'' +
                ", city: '" + city + '\'' +
                ", zipCode: '" + zipCode + '\'' +
                "}";
    }
}
