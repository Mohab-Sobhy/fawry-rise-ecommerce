package com.mohab.ecommerce.model;

public class Customer {
    private String name;
    private Balance balance;
    private Cart cart;

    public Customer(String name, Balance balance, Cart cart) {
        this.name = name;
        this.balance = balance;
        this.cart = cart;
    }

    public Balance getBalance() {
        return balance;
    }

    // Getters and setters
}