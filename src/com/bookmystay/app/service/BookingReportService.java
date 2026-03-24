package com.bookmystay.app.service;

import com.bookmystay.app.history.BookingHistory;
import com.bookmystay.app.reservation.Reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UC8: Booking Report Service
 * Generates reports from booking history.
 */
public class BookingReportService {

    private final BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // 🔹 Total bookings
    public void generateSummary() {
        List<Reservation> reservations = history.getAllReservations();

        System.out.println("\n===== Booking Summary =====");
        System.out.println("Total Bookings: " + reservations.size());
    }

    // 🔹 Bookings per room type
    public void generateRoomTypeReport() {
        List<Reservation> reservations = history.getAllReservations();

        Map<String, Integer> countMap = new HashMap<>();

        for (Reservation r : reservations) {
            String type = r.getRoomType();
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        System.out.println("\n===== Bookings by Room Type =====");

        if (countMap.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        for (String type : countMap.keySet()) {
            System.out.println(type + ": " + countMap.get(type));
        }
    }
}