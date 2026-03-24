package com.bookmystay.app.history;

import com.bookmystay.app.reservation.Reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * UC8: Booking History
 * Stores confirmed reservations in insertion order.
 */
public class BookingHistory {

    private final List<Reservation> history;

    public BookingHistory() {
        this.history = new ArrayList<>();
    }

    // 🔹 Add confirmed reservation
    public void addReservation(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation cannot be null");
        }
        history.add(reservation);
    }

    // 🔹 Retrieve history (read-only)
    public List<Reservation> getAllReservations() {
        return Collections.unmodifiableList(history);
    }

    // 🔹 Display history
    public void displayHistory() {
        System.out.println("\n===== Booking History =====");

        if (history.isEmpty()) {
            System.out.println("No bookings recorded.");
            return;
        }

        for (Reservation r : history) {
            r.display();
        }
    }
}