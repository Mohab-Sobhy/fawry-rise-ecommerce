package com.mohab.ecommerce.notification;

import com.mohab.ecommerce.model.Cart;

public class CheckoutNotification implements INotification {
    private Cart cart;
    private double subtotal;
    private double shippingFee;

    public CheckoutNotification(Cart cart, double subtotal, double shippingFee) {
        this.cart = cart;
        this.subtotal = subtotal;
        this.shippingFee = shippingFee;
    }

    public Cart getCart() {
        return cart;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getShippingFee() {
        return shippingFee;
    }

}