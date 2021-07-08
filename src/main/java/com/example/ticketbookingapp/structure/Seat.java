package com.example.ticketbookingapp.structure;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seat {
    private int rowNumber;
    private int seatNumber;
    private boolean isReserved;
}
