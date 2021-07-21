package com.example.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "seances")
public class Seance {
    @Id
    @JsonIgnore
    private String id;

    @JsonView(View.TitleAndScreeningTimes.class)
    private Movie movie;

    @JsonView(View.ScreeningRoomAndSeats.class)
    private Room room;

    @JsonView({View.TitleAndScreeningTimes.class})
    private LocalDateTime seanceDate;

    public Seance(Movie movie, Room room, LocalDateTime seanceDate) {
        this.movie = movie;
        this.room = room;
        this.seanceDate = seanceDate;
    }
}
