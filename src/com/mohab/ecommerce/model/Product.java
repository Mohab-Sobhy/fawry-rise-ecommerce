package com.mohab.ecommerce.model;

import com.mohab.ecommerce.expiry.IExpiry;
import com.mohab.ecommerce.shipping.IShippable;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private IExpiry expiry;
    private IShippable shippable;

    public Product(String name, double price, int quantity, IExpiry expiry, IShippable shippable) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        if (expiry == null) {
            throw new IllegalArgumentException("Expiry strategy cannot be null.");
        }
        if (shippable == null) {
            throw new IllegalArgumentException("Shippable strategy cannot be null.");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiry = expiry;
        this.shippable = shippable;
    }

    public boolean isExpired() {
        return expiry.isExpired();
    }

    public boolean isShippable() {
        return shippable.isShippable();
    }

    public double getWeight() {
        return shippable.getWeight();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public IShippable getShippable() {
        return shippable;
    }

    public int getQuantity() {
        return quantity;
    }
}