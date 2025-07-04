package com.mohab.ecommerce.model;

import com.mohab.ecommerce.shipping.IShippable;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        double unitPrice = product.getPrice();

        return String.format("%d x %-5s : \t", quantity, product.getName());
    }

}