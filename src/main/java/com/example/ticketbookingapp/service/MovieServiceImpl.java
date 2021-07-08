package com.example.ticketbookingapp.service;

import com.example.ticketbookingapp.repository.MovieRepository;
import com.example.ticketbookingapp.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieServiceImpl {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public void saveAll(List<Movie> movies){
        movieRepository.saveAll(movies);

    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findMovieByTitle(String title){
       return movieRepository.findMovieByTitle(title);
    }

    public void deleteAll(){
        movieRepository.deleteAll();
    }

    public void deleteById(String id){
        movieRepository.deleteById(id);
    }

    public void save(Movie movie){
        movieRepository.save(movie);

    }
}

