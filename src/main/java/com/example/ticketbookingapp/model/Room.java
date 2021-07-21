package com.example.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rooms")
public class Room {
    @Id
    @JsonIgnore
    private String id;

    @JsonView(View.ScreeningRoomAndSeats.class)
    private int roomNumber;

    @JsonView(View.ScreeningRoomAndSeats.class)
    private Seat[][] seats;

    public Room(int roomNumber, Seat[][] seats) {
        this.roomNumber = roomNumber;
        this.seats = seats;
    }
}
