package com.bookmystay.app.service;

import com.bookmystay.app.inventory.RoomInventory;
import com.bookmystay.app.reservation.Reservation;

import java.util.*;

/**
 * UC6: Reservation Confirmation & Room Allocation
 * Processes booking requests and allocates rooms safely.
 */
public class BookingService {

    private final RoomInventory inventory;
    private final BookingRequestQueue queue;

    // 🔹 Track allocated room IDs (global uniqueness)
    private final Set<String> allocatedRoomIds;

    // 🔹 Map room type → allocated room IDs
    private final Map<String, Set<String>> roomAllocations;

    public BookingService(RoomInventory inventory, BookingRequestQueue queue) {
        this.inventory = inventory;
        this.queue = queue;
        this.allocatedRoomIds = new HashSet<>();
        this.roomAllocations = new HashMap<>();
    }

    // 🔥 Process next booking request (FIFO)
    public void processNextRequest() {

        if (queue.isEmpty()) {
            System.out.println("\nNo pending booking requests.");
            return;
        }

        Reservation reservation = queue.pollNextRequest();

        String roomType = reservation.getRoomType();
        String guestName = reservation.getGuestName();

        int available = inventory.getAvailability(roomType);

        System.out.println("\nProcessing request for " + guestName + " (" + roomType + ")");

        // 🔹 Check availability
        if (available <= 0) {
            System.out.println("❌ No rooms available for " + roomType);
            return;
        }

        // 🔹 Generate unique room ID
        String roomId = generateRoomId(roomType);

        // 🔹 Ensure uniqueness (Set check)
        while (allocatedRoomIds.contains(roomId)) {
            roomId = generateRoomId(roomType);
        }

        // 🔹 Store allocation
        allocatedRoomIds.add(roomId);

        roomAllocations
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        // 🔹 Update inventory (CRITICAL)
        inventory.setAvailability(roomType, available - 1);

        // 🔹 Confirm booking
        System.out.println("✅ Booking Confirmed!");
        System.out.println("Guest: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Room ID: " + roomId);
    }

    // 🔹 Helper: Generate room ID
    private String generateRoomId(String roomType) {
        return roomType.substring(0, 1).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 5);
    }

    // 🔹 View all allocations
    public void displayAllocations() {
        System.out.println("\n===== Room Allocations =====");

        if (roomAllocations.isEmpty()) {
            System.out.println("No allocations yet.");
            return;
        }

        for (String type : roomAllocations.keySet()) {
            System.out.println("\n" + type + ": " + roomAllocations.get(type));
        }
    }
}