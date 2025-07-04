package com.mohab.ecommerce.expiry;

public class NonExpirable implements IExpiry {
    public boolean isExpired() {
        return false;
    }
}