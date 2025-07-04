package com.mohab.ecommerce.service;

import com.mohab.ecommerce.exception.EmptyCartException;
import com.mohab.ecommerce.exception.InsufficientBalanceException;
import com.mohab.ecommerce.exception.OutOfStockException;
import com.mohab.ecommerce.exception.ProductExpiredException;
import com.mohab.ecommerce.model.Cart;
import com.mohab.ecommerce.model.CartItem;
import com.mohab.ecommerce.model.Customer;
import com.mohab.ecommerce.model.Product;
import com.mohab.ecommerce.notification.CheckoutNotification;
import com.mohab.ecommerce.notification.CheckoutPublisher;
import com.mohab.ecommerce.shipping.IShippable;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private static CheckoutService checkoutService;
    private ShippingService shippingService = ShippingService.getInstance();

    private CheckoutService() {}

    public static CheckoutService getInstance() {
        if (checkoutService == null) checkoutService = new CheckoutService();
        return checkoutService;
    }

    public void checkout(Customer customer, Cart cart) {
        CheckoutPublisher publisher = CheckoutPublisher.getInstance();

        try {
            if (customer == null || cart == null) {
                throw new IllegalArgumentException("Customer or Cart cannot be null.");
            }

            if (cart.getAll().isEmpty()) {
                throw new EmptyCartException("Cart is empty.");
            }

            double subtotal = 0;
            List<IShippable> shippableItems = new ArrayList<>();

            for (CartItem item : cart.getAll()) {
                Product product = item.getProduct();
                if (product == null) {
                    throw new NullPointerException("Cart item contains null product.");
                }
                if (product.isExpired()) {
                    throw new ProductExpiredException("Product " + product.getName() + " is expired.");
                }
                if (product.getQuantity() < item.getQuantity()) {
                    throw new OutOfStockException("Product " + product.getName() + " is out of stock.");
                }

                subtotal += product.getPrice() * item.getQuantity();
                shippableItems.add(product.getShippable());
            }

            double shippingFee = shippingService.calculateShippingPrice(shippableItems);
            double total = subtotal + shippingFee;

            if (!customer.getBalance().isThisAmountAvailable(total)) {
                throw new InsufficientBalanceException("Customer balance is not enough for checkout.");
            }

            customer.getBalance().debit(total);

            CheckoutNotification notification = new CheckoutNotification(cart, subtotal, shippingFee);
            CheckoutPublisher.getInstance().notifySubscribers(notification);

        } catch (EmptyCartException | ProductExpiredException | OutOfStockException | InsufficientBalanceException e) {
            System.out.println("Checkout error: " + e.getMessage());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error during checkout: " + e.getMessage());
            e.printStackTrace();
        }
    }
}