package com.bookmystay.app.addon;

/**
 * Represents an optional service (e.g., Breakfast, Spa).
 */
public class AddOnService {

    private final String name;
    private final double price;

    public AddOnService(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Service name cannot be empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println(name + " (₹" + price + ")");
    }
}