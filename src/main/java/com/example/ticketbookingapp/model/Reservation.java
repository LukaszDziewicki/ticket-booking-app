package com.example.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reservations")
public class Reservation {

    @Id
    @JsonIgnore
    private String id;
    private String name;
    private String surname;
    private Seance seance;
    private Seat[] reservedSeats;
    private int adultSeats;
    private int studentSeats;
    private int childSeats;


    public Reservation(String name,
                       String surname,
                       Seance seance,
                       Seat[] reservedSeats,
                       int adultSeats,
                       int studentSeats,
                       int childSeats) {
        this.name = name;
        this.surname = surname;
        this.seance = seance;
        this.reservedSeats = reservedSeats;
        this.adultSeats = adultSeats;
        this.studentSeats = studentSeats;
        this.childSeats = childSeats;
    }
}
