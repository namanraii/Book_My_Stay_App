package com.bookmystay.app.service;

import com.bookmystay.app.exception.InvalidBookingException;
import com.bookmystay.app.exception.InvalidRoomTypeException;
import com.bookmystay.app.inventory.RoomInventory;
import com.bookmystay.app.reservation.Reservation;

import java.util.Set;

/**
 * UC9: Validates booking input and system state.
 */
public class BookingValidator {

    private static final Set<String> VALID_ROOM_TYPES = Set.of(
            "Single Room", "Double Room", "Suite Room"
    );

    public static void validate(Reservation reservation, RoomInventory inventory) {

        if (reservation == null) {
            throw new InvalidBookingException("Reservation cannot be null");
        }

        // 🔹 Validate guest name
        if (reservation.getGuestName() == null || reservation.getGuestName().isBlank()) {
            throw new InvalidBookingException("Guest name is required");
        }

        // 🔹 Validate room type
        String roomType = reservation.getRoomType();

        if (roomType == null || roomType.isBlank()) {
            throw new InvalidBookingException("Room type is required");
        }

        if (!VALID_ROOM_TYPES.contains(roomType)) {
            throw new InvalidRoomTypeException("Invalid room type: " + roomType);
        }

        // 🔹 Validate inventory state
        int available = inventory.getAvailability(roomType);

        if (available < 0) {
            throw new InvalidBookingException("Inventory corruption detected for " + roomType);
        }
    }
}