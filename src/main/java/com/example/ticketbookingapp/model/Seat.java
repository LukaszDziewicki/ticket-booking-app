package com.example.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seat {

    @JsonView(View.ScreeningRoomAndSeats.class)
    private int rowNumber;

    @JsonView(View.ScreeningRoomAndSeats.class)
    private int seatNumber;

    @JsonView(View.ScreeningRoomAndSeats.class)
    private boolean reserved;

}
