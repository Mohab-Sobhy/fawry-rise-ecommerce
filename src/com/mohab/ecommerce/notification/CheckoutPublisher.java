package com.mohab.ecommerce.notification;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPublisher {
    private static CheckoutPublisher checkoutPublisher;
    private List<ISubscriber> subscribers = new ArrayList<>();

    public static CheckoutPublisher getInstance() {
        if (checkoutPublisher == null) checkoutPublisher = new CheckoutPublisher();
        return checkoutPublisher;
    }

    public void subscribe(ISubscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(ISubscriber s) {
        subscribers.remove(s);
    }

    public void notifySubscribers(CheckoutNotification notification) {
        for (ISubscriber s : subscribers) {
            s.notify(notification);
        }
    }
}