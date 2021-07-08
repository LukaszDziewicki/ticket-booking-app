package com.example.ticketbookingapp.model;

import com.example.ticketbookingapp.structure.Seat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rooms")
public class Room {
    @Id
    private String id;
    private Seat[][] seats;

    public Room(Seat[][] seats) {
        this.seats = seats;
    }

}
