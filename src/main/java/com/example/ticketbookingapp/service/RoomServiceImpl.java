package com.example.ticketbookingapp.service;

import com.example.ticketbookingapp.model.Room;
import com.example.ticketbookingapp.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public void saveAll(List<Room> rooms){
        roomRepository.saveAll(rooms);
    }

    public Room findRoomByRoomNumber(int roomNumber){
        return roomRepository.findRoomByRoomNumber(roomNumber);
    }

    public void deleteAll(){
        roomRepository.deleteAll();
    }
}
