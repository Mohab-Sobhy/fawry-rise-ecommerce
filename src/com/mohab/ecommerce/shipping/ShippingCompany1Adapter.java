package com.mohab.ecommerce.shipping;

import java.util.List;

public class ShippingCompany1Adapter implements IShippingProvider {
    private ShippingCompany1 shippingCompany1;

    public ShippingCompany1Adapter(ShippingCompany1 company1) {
        this.shippingCompany1 = company1;
    }

    public double calculateShippingPrice(List<IShippable> shippingList) {
        try {
            double totalWeight = 0;

            for (IShippable shippable : shippingList) {
                double weight = shippable.getWeight();
                if (weight < 0) {
                    throw new IllegalArgumentException("Item weight cannot be negative.");
                }
                totalWeight += weight;
            }

            if (totalWeight < 500) {
                return 25.0;
            } else if (totalWeight < 1000) {
                return 35.0;
            } else {
                double extraKilos = Math.floor((totalWeight - 1000) / 1000);
                return 35.0 + (extraKilos * 10);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error in shipping calculation: " + e.getMessage());
            return -1;
        } catch (Exception e) {
            System.out.println("Unexpected error in shipping calculation: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public void sendShippingRequest(String requestText) {
        shippingCompany1.sendShippingRequest(requestText);
    }

    public String convertToAppropriateDataFormat(IShippable[] items) {
        return "converted data";
    }
}