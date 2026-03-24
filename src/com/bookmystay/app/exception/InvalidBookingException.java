package com.bookmystay.app.exception;

/**
 * Thrown when booking input is invalid.
 */
public class InvalidBookingException extends RuntimeException {
    public InvalidBookingException(String message) {
        super(message);
    }
}