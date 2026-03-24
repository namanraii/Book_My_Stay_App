package com.bookmystay.app.service;

import com.bookmystay.app.inventory.RoomInventory;
import com.bookmystay.app.rooms.*;

import java.util.ArrayList;
import java.util.List;

/**
 * UC4: Room Search & Availability Check
 * Handles read-only operations to display available rooms.
 */
public class RoomSearchService {

    private final RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("RoomInventory cannot be null");
        }
        this.inventory = inventory;
    }

    public void displayAvailableRooms() {

        System.out.println("\n===== Available Rooms =====");

        // Domain objects (no duplication of data)
        List<Room> rooms = List.of(
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        );

        boolean found = false;

        for (Room room : rooms) {

            // 🔹 Read-only access (no modification)
            int available = inventory.getAvailability(room.getType());

            // 🔹 Validation logic (filter unavailable rooms)
            if (available > 0) {
                found = true;

                System.out.println("\n--- " + room.getType() + " ---");
                room.displayDetails();
                System.out.println("Available: " + available);
            }
        }

        if (!found) {
            System.out.println("\nNo rooms available at the moment.");
        }
    }
}