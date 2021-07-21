package com.example.ticketbookingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Duration;

@Data
@Document(collection = "movies")
public class Movie {
    @Id
    @JsonIgnore
    private String id;

    @JsonView(View.TitleAndScreeningTimes.class)
    private String title;

    @JsonView(View.ScreeningRoomAndSeats.class)
    private Duration durationInMinutes;

    public Movie(String title, Duration durationInMinutes) {
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }
}
