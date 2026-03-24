package com.bookmystay.app.service;

import com.bookmystay.app.inventory.RoomInventory;
import com.bookmystay.app.rooms.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles read-only search operations for available rooms.
 */
public class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void displayAvailableRooms() {

        System.out.println("\n===== Available Rooms =====");

        // Create room objects (domain layer)
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.type);

            // Only show available rooms
            if (available > 0) {
                System.out.println("\n--- " + room.type + " ---");
                room.displayDetails();
                System.out.println("Available: " + available);
            }
        }
    }
}