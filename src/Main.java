package com.bookmystay.app;

/**
 * Entry point for the Book My Stay application.
 * This class initializes the system and displays a welcome message.
 *
 * <p>This demonstrates the basic structure of a Java application,
 * including the main method, console output, and execution flow.</p>
 *
 * @author Naman Rai
 * @version 1.0
 */
public class Main {

    /**
     * Main method - starting point of the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Application details
        String appName = "Book My Stay";
        String version = "v1.0";

        // Welcome message
        System.out.println("=================================");
        System.out.println(" Welcome to " + appName);
        System.out.println(" Version: " + version);
        System.out.println("=================================");
        System.out.println("Your hotel booking journey starts here!");

    }
}