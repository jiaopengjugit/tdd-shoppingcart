package com.jiao.shopping;

/**
 * Created by jiaopengju on 16/3/20.
 */
public enum Product {

    ORANGE("orange", 5.01), BANANA("banana", 6.02), APPLE("apple", 1.3);

    private String name;
    private double price;

    private Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
