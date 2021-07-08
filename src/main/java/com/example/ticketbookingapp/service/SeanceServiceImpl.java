package com.example.ticketbookingapp.service;

import com.example.ticketbookingapp.model.Seance;
import com.example.ticketbookingapp.repository.SeanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceServiceImpl {
    private SeanceRepository seanceRepository;

    public SeanceServiceImpl(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public void save(Seance seance){
        seanceRepository.save(seance);
    }

    public void saveAll(List<Seance> seances){
        seanceRepository.saveAll(seances);
    }

    public List<Seance> findAll(){
        return seanceRepository.findAll();
    }

    public void deleteAll(){
        seanceRepository.deleteAll();
    }
}
