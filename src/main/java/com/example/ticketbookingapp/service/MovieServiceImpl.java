package com.example.ticketbookingapp.service;

import com.example.ticketbookingapp.repository.MovieRepository;
import com.example.ticketbookingapp.model.Movie;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void saveAll(List<Movie> movies){
        movieRepository.saveAll(movies);

    }

    public Movie findMovieByTitle(String title){
       return movieRepository.findMovieByTitle(title);
    }

    public void deleteAll(){
        movieRepository.deleteAll();
    }

}

