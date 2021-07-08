
package com.example.ticketbookingapp.controller;

import com.example.ticketbookingapp.model.Movie;
import com.example.ticketbookingapp.model.Room;
import com.example.ticketbookingapp.model.Seance;
import com.example.ticketbookingapp.service.MovieServiceImpl;
import com.example.ticketbookingapp.service.RoomServiceImpl;
import com.example.ticketbookingapp.service.SeanceServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/all")
public class MainController {

    private MovieServiceImpl movieService;
    private RoomServiceImpl roomService;
    private SeanceServiceImpl seanceService;

    public MainController(MovieServiceImpl movieService,
                          RoomServiceImpl roomService,
                          SeanceServiceImpl seanceService) {
        this.movieService = movieService;
        this.roomService = roomService;
        this.seanceService = seanceService;
    }

    @GetMapping("/movie")
    public List<Movie> getMovies(){
        return movieService.findAll();
    }

    @GetMapping("/room")
    public List<Room> getRooms(){
        return  roomService.findAll();
    }

    @GetMapping("/seance")
    public List<Seance> getSeance(){
        return seanceService.findAll();
    }
}
