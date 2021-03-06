package com.example.ticketbookingapp.repository;

import com.example.ticketbookingapp.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    Movie findMovieByTitle(String title);

    List<Movie> getDistinctByDurationInMinutes();

}
