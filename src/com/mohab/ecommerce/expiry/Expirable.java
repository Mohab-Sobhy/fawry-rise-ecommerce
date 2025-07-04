package com.mohab.ecommerce.expiry;

import java.time.LocalDate;

public class Expirable implements IExpiry {
    private LocalDate expiryDate;

    public Expirable(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}