package com.bookmystay.app.service;

import com.bookmystay.app.addon.AddOnService;

import java.util.*;

/**
 * UC7: Add-On Service Manager
 * Manages services attached to reservations (no inventory/booking mutation).
 */
public class AddOnServiceManager {

    // 🔹 reservationId → list of services
    private final Map<String, List<AddOnService>> reservationServices;

    public AddOnServiceManager() {
        this.reservationServices = new HashMap<>();
    }

    // 🔹 Attach a service to a reservation
    public void addService(String reservationId, AddOnService service) {
        if (reservationId == null || reservationId.isBlank()) {
            throw new IllegalArgumentException("Reservation ID cannot be empty");
        }
        if (service == null) {
            throw new IllegalArgumentException("Service cannot be null");
        }

        reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);

        System.out.println("➕ Added service to " + reservationId + ": " + service.getName());
    }

    // 🔹 Get services for a reservation
    public List<AddOnService> getServices(String reservationId) {
        return reservationServices.getOrDefault(reservationId, Collections.emptyList());
    }

    // 🔹 Calculate total add-on cost
    public double calculateTotalCost(String reservationId) {
        double total = 0.0;
        for (AddOnService s : getServices(reservationId)) {
            total += s.getPrice();
        }
        return total;
    }

    // 🔹 Display services for a reservation
    public void displayServices(String reservationId) {
        System.out.println("\n===== Add-On Services for " + reservationId + " =====");

        List<AddOnService> services = getServices(reservationId);

        if (services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        for (AddOnService s : services) {
            s.display();
        }

        System.out.println("Total Add-On Cost: ₹" + calculateTotalCost(reservationId));
    }
}