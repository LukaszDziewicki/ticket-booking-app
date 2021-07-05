package com.example.ticketbookingapp.model;

public class ScreeningRoom {

    private Seat[][] seats;

    public ScreeningRoom(Seat[][] seats) {
        this.seats = seats;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }
}
