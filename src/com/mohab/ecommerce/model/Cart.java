package com.mohab.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getAll() {
        return items;
    }

    public void add(CartItem item) {
        items.add(item);
    }

    public void remove(CartItem item) {
        items.remove(item);
    }

    @Override
    public String toString() {
        StringBuilder finalText = new StringBuilder();
        for (CartItem item : items) {
            finalText.append(item.toString()).append("\n");
        }
        return finalText.toString();
    }

}