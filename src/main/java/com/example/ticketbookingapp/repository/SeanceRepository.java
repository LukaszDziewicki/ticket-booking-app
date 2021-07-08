package com.example.ticketbookingapp.repository;

import com.example.ticketbookingapp.model.Seance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends MongoRepository<Seance, String> {

}
