package com.bookmystay.app.exception;

/**
 * Thrown when an unsupported room type is used.
 */
public class InvalidRoomTypeException extends RuntimeException {
    public InvalidRoomTypeException(String message) {
        super(message);
    }
}