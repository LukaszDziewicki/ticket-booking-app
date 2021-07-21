package com.example.ticketbookingapp.repository;

import com.example.ticketbookingapp.model.Seance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SeanceRepository extends MongoRepository<Seance, String> {

     List<Seance> findSeancesBySeanceDateIsGreaterThanOrderBySeanceDate(LocalDateTime seanceDate);

     Seance findSeanceByMovieTitleAndSeanceDate(String title, LocalDateTime seanceDate);

}
