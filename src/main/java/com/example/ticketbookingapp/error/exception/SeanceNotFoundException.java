package com.example.ticketbookingapp.error.exception;

public class SeanceNotFoundException extends RuntimeException {

    public SeanceNotFoundException() {
        super("Seances not found in given date");
    }
}
