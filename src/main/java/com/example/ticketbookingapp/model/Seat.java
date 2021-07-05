package com.example.ticketbookingapp.model;

public class Seat {
    private int rowNumber;
    private int seatNumber;
    private boolean isReserved;

    public Seat(int rowNumber, int seatNumber, boolean isReserved) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "rowNumber=" + rowNumber +
                ", seatNumber=" + seatNumber +
                ", isReserved=" + isReserved +
                '}';
    }
}
