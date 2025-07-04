package com.mohab.ecommerce.service;

import com.mohab.ecommerce.model.Product;
import com.mohab.ecommerce.shipping.IShippable;
import com.mohab.ecommerce.shipping.IShippingProvider;
import com.mohab.ecommerce.shipping.Shippable;

import java.util.List;

public class ShippingService {
    private static ShippingService instance;
    private IShippingProvider shippingProvider;

    private ShippingService() {}

    public static ShippingService getInstance() {
        if (instance == null) instance = new ShippingService();
        return instance;
    }

    public void setShippingProvider(IShippingProvider sp) {
        this.shippingProvider = sp;
    }

    public double calculateShippingPrice(List<IShippable> items){
        return this.shippingProvider.calculateShippingPrice(items);
    }
}