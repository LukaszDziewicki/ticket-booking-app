package com.example.ticketbookingapp.error.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException() {
        super("Reservation not found ");
    }
}
