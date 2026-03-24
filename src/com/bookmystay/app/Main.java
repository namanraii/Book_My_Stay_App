package com.bookmystay.app;

import com.bookmystay.app.inventory.RoomInventory;

/**
 * Entry point for the Book My Stay application.
 * Demonstrates UC1 (welcome) + UC3 (centralized inventory).
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

        // Display all rooms
        inventory.displayInventory();

        // Example check
        System.out.println("\nChecking availability for Single Room:");
        System.out.println("Available: " + inventory.getAvailability("Single Room"));
    }
}