package com.mohab.ecommerce.exception;

public class EmptyCartException extends Exception {
    public EmptyCartException(String message) {
        super(message);
    }
}