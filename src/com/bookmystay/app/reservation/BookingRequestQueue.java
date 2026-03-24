package com.bookmystay.app.service;

import com.bookmystay.app.reservation.Reservation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * UC5: Booking Request Queue (FIFO)
 * Handles incoming booking requests without modifying inventory.
 */
public class BookingRequestQueue {

    private final Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        this.requestQueue = new LinkedList<>();
    }

    // 🔹 Add request (Guest action)
    public void addRequest(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation cannot be null");
        }

        requestQueue.offer(reservation);

        System.out.println("\nRequest added to queue:");
        reservation.display();
    }

    // 🔹 View queue (for debugging/demo)
    public void displayQueue() {
        System.out.println("\n===== Booking Request Queue =====");

        if (requestQueue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        for (Reservation r : requestQueue) {
            r.display();
        }
    }

    // 🔹 Peek next request (FIFO)
    public Reservation peekNextRequest() {
        return requestQueue.peek();
    }

    // 🔹 Remove next request (used in UC6)
    public Reservation pollNextRequest() {
        return requestQueue.poll();
    }

    public boolean isEmpty() {
        return requestQueue.isEmpty();
    }
}