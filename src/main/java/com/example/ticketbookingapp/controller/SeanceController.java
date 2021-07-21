package com.example.ticketbookingapp.controller;

import com.example.ticketbookingapp.error.exception.SeanceNotFoundException;
import com.example.ticketbookingapp.model.Seance;
import com.example.ticketbookingapp.model.View;
import com.example.ticketbookingapp.service.SeanceServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/seances")
public class SeanceController {

    private final SeanceServiceImpl seanceService;

    public SeanceController(SeanceServiceImpl seanceService) {
        this.seanceService = seanceService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.TitleAndScreeningTimes.class)
    public List<Seance> chooseSeanceDateTime(@RequestBody Seance seance) {
        List<Seance> seancesList = seanceService.findSeancesByDateOrderBySeanceDate(seance.getSeanceDate());

        if (seancesList.isEmpty()){
            throw new SeanceNotFoundException();
        }
        return seancesList;
    }

    @GetMapping("/{date}/{time}")
    @JsonView(View.TitleAndScreeningTimes.class)
    public List<Seance> getSeances(
            @PathVariable(value = "date") String date,
            @PathVariable(value = "time") String time
    ) {
        LocalDateTime seanceDate = seanceService.getSeanceLocalDateTimeFrom(date, time);
        return seanceService.findSeancesByDateOrderBySeanceDate(seanceDate);
    }



    @PostMapping("/search/particular")
    @JsonView(View.ScreeningRoomAndSeats.class)
    public Seance postSeance(@RequestBody Seance seance) {
        return seanceService.findSeanceByMovieTitleAndSeanceDate(seance.getMovie().getTitle(), seance.getSeanceDate());
    }

    @GetMapping("/{title}/{date}/{time}")
    @JsonView(View.ScreeningRoomAndSeats.class)
    public Seance getParticularSeance(
            @PathVariable(value = "title") String title,
            @PathVariable(value = "date") String date,
            @PathVariable(value = "time") String time
    ) {
        LocalDateTime seanceDate = seanceService.getSeanceLocalDateTimeFrom(date, time);
        return seanceService.findSeanceByMovieTitleAndSeanceDate(title, seanceDate);
    }
}
