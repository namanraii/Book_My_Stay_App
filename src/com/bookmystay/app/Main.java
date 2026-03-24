package com.bookmystay.app;

import com.bookmystay.app.inventory.RoomInventory;
import com.bookmystay.app.reservation.Reservation;
import com.bookmystay.app.service.BookingRequestQueue;
import com.bookmystay.app.service.BookingService;
import com.bookmystay.app.service.RoomSearchService;

/**
 * Entry point for Book My Stay application.
 * Demonstrates UC1 → UC5.
 *
 * UC1: Welcome
 * UC2: Room Types (used via objects)
 * UC3: Inventory
 * UC4: Search
 * UC5: Booking Request Queue
 *
 * @author Naman Rai
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        // ===== UC1: Welcome =====
        String appName = "Book My Stay";
        String version = "v1.0";

        System.out.println("=================================");
        System.out.println(" Welcome to " + appName);
        System.out.println(" Version: " + version);
        System.out.println("=================================");
        System.out.println("Your hotel booking journey starts here!");

        // ===== UC3: Centralized Inventory =====
        RoomInventory inventory = new RoomInventory();

        // Sample inventory setup
        inventory.setAvailability("Single Room", 3);
        inventory.setAvailability("Double Room", 2);
        inventory.setAvailability("Suite Room", 1);

        System.out.println("\n===== Inventory Snapshot =====");
        inventory.displayInventory();

        // ===== UC4: Room Search =====
        RoomSearchService searchService = new RoomSearchService(inventory);
        searchService.displayAvailableRooms();

        // ===== UC5: Booking Request Queue =====
        BookingRequestQueue queue = new BookingRequestQueue();

        System.out.println("\n===== Booking Requests =====");

        queue.addRequest(new Reservation("Naman", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Double Room"));
        queue.addRequest(new Reservation("Ananya", "Suite Room"));

        // Display queue (FIFO order)
        queue.displayQueue();

        // ===== UC6: Reservation Processing =====
        BookingService bookingService = new BookingService(inventory, queue);

        System.out.println("\n===== Processing Bookings =====");

// Process all requests (FIFO)
        while (!queue.isEmpty()) {
            bookingService.processNextRequest();
        }

// Show final allocations
        bookingService.displayAllocations();

// Show updated inventory
        System.out.println("\n===== Updated Inventory =====");
        inventory.displayInventory();
    }
}