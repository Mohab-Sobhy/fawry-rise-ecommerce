package com.mohab.ecommerce.notification;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogNotifier implements ISubscriber {

    private static final String LOG_FILENAME = "checkouts.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void notify(CheckoutNotification notification) {
        File logFile = new File(LOG_FILENAME);

        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {
            String timestamp = LocalDateTime.now().format(formatter);
            double subtotal = notification.getSubtotal();
            double shipping = notification.getShippingFee();
            double total = subtotal + shipping;

            writer.printf(
                    "%s | Subtotal: %.2f | Shipping: %.2f | Total: %.2f%n",
                    timestamp, subtotal, shipping, total
            );

            System.out.println("Checkout saved successfully at: [" + logFile.getAbsolutePath() + "]");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
