package com.mohab.ecommerce.Util;

import com.mohab.ecommerce.model.CartItem;
import com.mohab.ecommerce.notification.CheckoutNotification;

public class ReceiptFormatter {

    public static String buildCheckoutReceipt(CheckoutNotification notification) {
        StringBuilder sb = new StringBuilder();

        sb.append("== Receipt ==\n");

        for (CartItem item : notification.getCart().getAll()) {
            int qty = item.getQuantity();
            String name = item.getProduct().getName();
            double total = item.getProduct().getPrice() * qty;

            sb.append(qty).append(" x ").append(name)
                    .append(" = ").append(String.format("%.2f", total)).append("\n");
        }

        sb.append("\nSubtotal    : ").append(String.format("%.2f", notification.getSubtotal())).append("\n");
        sb.append("Shipping    : ").append(String.format("%.2f", notification.getShippingFee())).append("\n");
        sb.append("Total Paid  : ").append(String.format("%.2f",
                notification.getSubtotal() + notification.getShippingFee())).append("\n");

        // Weight Summary
        int totalWeight = notification.getCart().getAll().stream()
                .mapToInt(item -> item.getProduct().getShippable().getWeight() * item.getQuantity())
                .sum();
        sb.append("Total Weight: ").append(totalWeight).append("g\n");

        sb.append("=============\n");
        return sb.toString();
    }

    public static String buildShipmentNotice(CheckoutNotification notification) {
        StringBuilder sb = new StringBuilder();

        sb.append("== Shipment Notice ==\n");

        for (CartItem item : notification.getCart().getAll()) {
            int qty = item.getQuantity();
            String name = item.getProduct().getName();
            int weight = item.getProduct().getShippable().getWeight() * qty;

            sb.append(qty).append(" x ").append(name)
                    .append(" = ").append(weight).append("g\n");
        }

        return sb.toString();
    }
}
