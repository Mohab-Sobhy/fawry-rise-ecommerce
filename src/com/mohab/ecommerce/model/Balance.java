package com.mohab.ecommerce.model;

public class Balance {
    private double amount;

    public void charged(double value) {
        this.amount += value;
    }

    public void debit(double value) {
        this.amount -= value;
    }

    public boolean isThisAmountAvailable(double value) {
        return this.amount >= value;
    }

    public double getAmount() {
        return this.amount;
    }
}