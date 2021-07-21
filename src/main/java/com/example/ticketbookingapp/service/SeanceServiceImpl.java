package com.example.ticketbookingapp.service;

import com.example.ticketbookingapp.model.Seance;
import com.example.ticketbookingapp.repository.SeanceRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SeanceServiceImpl {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s");
    private SeanceRepository seanceRepository;

    public SeanceServiceImpl(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }


    public void saveAll(List<Seance> seances){
        seanceRepository.saveAll(seances);
    }

    public void deleteAll(){
        seanceRepository.deleteAll();
    }

    public List<Seance> findSeancesByDateOrderBySeanceDate(LocalDateTime seanceDate) {
        return seanceRepository.findSeancesBySeanceDateIsGreaterThanOrderBySeanceDate(seanceDate);
    }

    public Seance findSeanceByMovieTitleAndSeanceDate(String title, LocalDateTime seanceDate) {
        return seanceRepository.findSeanceByMovieTitleAndSeanceDate(title, seanceDate);
    }

    public LocalDateTime getSeanceLocalDateTimeFrom(String date, String time){
        StringBuilder dateBuilder = new StringBuilder();
        String seanceDate =
                (dateBuilder
                        .append(date)
                        .append(" ")
                        .append(time)
                ).toString();
        return LocalDateTime.parse(seanceDate, dateTimeFormatter);
    }
}
