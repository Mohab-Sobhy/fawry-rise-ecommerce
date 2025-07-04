package com.mohab.ecommerce.shipping;

import java.util.List;

public interface IShippingProvider {
    double calculateShippingPrice(List<IShippable> items);
    void sendShippingRequest(String requestText);
    String convertToAppropriateDataFormat(IShippable[] items);
}