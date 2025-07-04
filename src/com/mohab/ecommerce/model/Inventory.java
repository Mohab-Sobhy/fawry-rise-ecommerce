package com.mohab.ecommerce.model;

import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private List<Product> products;

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductByName(String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}