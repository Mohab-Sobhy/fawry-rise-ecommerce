package com.mohab.ecommerce.notification;

public interface ISubscriber {
    void notify(CheckoutNotification notification);
}