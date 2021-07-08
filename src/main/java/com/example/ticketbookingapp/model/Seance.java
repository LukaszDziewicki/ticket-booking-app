package com.example.ticketbookingapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "documents")
public class Seance {
    @Id
    private String id;
    private Movie movie;
    private Room room;
    private Date date;

    public Seance(Movie movie, Room room, Date date) {
        this.movie = movie;
        this.room = room;
        this.date = date;
    }
}
