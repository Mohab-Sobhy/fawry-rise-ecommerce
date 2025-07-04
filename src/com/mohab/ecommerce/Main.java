package com.mohab.ecommerce;

import com.mohab.ecommerce.expiry.Expirable;
import com.mohab.ecommerce.expiry.NonExpirable;
import com.mohab.ecommerce.model.*;
import com.mohab.ecommerce.notification.CheckoutPublisher;
import com.mohab.ecommerce.notification.ConsoleNotifier;
import com.mohab.ecommerce.notification.LogNotifier;
import com.mohab.ecommerce.service.CheckoutService;
import com.mohab.ecommerce.service.ShippingService;
import com.mohab.ecommerce.shipping.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Create Products
        // Expirable + Shippable
        Product product1 = new Product(
                "Milk",
                15,
                20,
                new Expirable(LocalDate.now().plusDays(7)),
                new Shippable(500)
        );

        // NonExpirable + Shippable
        Product product2 = new Product(
                "Laptop",
                15000,
                5,
                new NonExpirable(),
                new Shippable(2500)
        );

        // Expirable + NonShippable
        Product product3 = new Product(
                "Recharge Card",
                30,
                100,
                new Expirable(LocalDate.now().plusDays(30)),
                new NonShippable()
        );

        // NonExpirable + NonShippable
        Product product4 = new Product(
                "Software License Key",
                300,
                100,
                new NonExpirable(),
                new NonShippable()
        );


        // Add Products To Cart
        Cart cart = new Cart();
        cart.add(new CartItem(product1, 3));
        cart.add(new CartItem(product2, 1));
        cart.add(new CartItem(product4, 2));

        // Instantiation Balance and Customer
        Balance balance = new Balance();
        balance.charged(20000);
        Customer customer = new Customer("Mohab", balance, cart);

        // Instantiation shipping service
        ShippingCompany1 company1 = new ShippingCompany1();
        IShippingProvider shippingAdapter = new ShippingCompany1Adapter(company1);
        ShippingService.getInstance().setShippingProvider(shippingAdapter);

        // Notifications
        CheckoutPublisher publisher = CheckoutPublisher.getInstance();
        publisher.subscribe(new ConsoleNotifier());
        publisher.subscribe(new LogNotifier());

        // checkout process
        CheckoutService.getInstance().checkout(customer, cart);
    }

}

