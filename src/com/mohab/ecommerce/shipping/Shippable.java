package com.mohab.ecommerce.shipping;

public class Shippable implements IShippable {
    private int weight;

    public Shippable(int weight) {
        this.weight = weight;
    }

    public boolean isShippable() {
        return true;
    }

    public int getWeight() {
        return weight;
    }
}