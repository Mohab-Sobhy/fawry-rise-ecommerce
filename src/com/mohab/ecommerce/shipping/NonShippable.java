package com.mohab.ecommerce.shipping;

public class NonShippable implements IShippable {
    public boolean isShippable() {
        return false;
    }

    public int getWeight() {
        return 0;
    }
}