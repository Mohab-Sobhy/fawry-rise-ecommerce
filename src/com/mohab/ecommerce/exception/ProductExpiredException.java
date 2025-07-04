package com.mohab.ecommerce.exception;

public class ProductExpiredException extends Exception {
    public ProductExpiredException(String message) {
        super(message);
    }
}