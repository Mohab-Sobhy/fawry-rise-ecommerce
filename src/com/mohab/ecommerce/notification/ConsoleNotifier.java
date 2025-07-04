package com.mohab.ecommerce.notification;

import com.mohab.ecommerce.Util.ReceiptFormatter;

public class ConsoleNotifier implements ISubscriber {
    public void notify(CheckoutNotification notification) {
        String shipmentNotice = ReceiptFormatter.buildCheckoutReceipt(notification);
        String checkoutReceipt = ReceiptFormatter.buildShipmentNotice(notification);
        System.out.println(checkoutReceipt);
        System.out.println(shipmentNotice);

    }
}