
package com.example.ticketbookingapp.controller;

import com.example.ticketbookingapp.model.Movie;
import com.example.ticketbookingapp.model.Room;
import com.example.ticketbookingapp.repository.MovieRepository;
import com.example.ticketbookingapp.service.MovieServiceImpl;
import com.example.ticketbookingapp.service.RoomServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class MovieController {

    private MovieServiceImpl movieService;
    private RoomServiceImpl roomService;

    public MovieController(MovieServiceImpl movieService, RoomServiceImpl roomService) {
        this.movieService = movieService;
        this.roomService = roomService;
    }

    @GetMapping("/movie")
    public List<Movie> getMovies(){
        return movieService.findAll();
    }

    @GetMapping("/room")
    public List<Room> getRooms(){
        return  roomService.findAll();
    }
}
