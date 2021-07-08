package com.example.ticketbookingapp;

import com.example.ticketbookingapp.model.Movie;
import com.example.ticketbookingapp.model.Room;
import com.example.ticketbookingapp.service.MovieServiceImpl;
import com.example.ticketbookingapp.service.RoomServiceImpl;
import com.example.ticketbookingapp.structure.Seat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DBInitializer implements CommandLineRunner {

    private MovieServiceImpl movieService;
    private RoomServiceImpl roomService;

    public DBInitializer(MovieServiceImpl movieService, RoomServiceImpl roomService) {
        this.movieService = movieService;
        this.roomService = roomService;
    }

    @Override
    public void run(String... args) {
        clearDB();

        movieService.saveAll(getThreeMovies());
        roomService.saveAll(getThreeRooms());




    }


    private void clearDB(){
        movieService.deleteAll();
        roomService.deleteAll();
    }

    private List<Movie> getThreeMovies(){
        Movie firstMovie = new Movie("Harry Potter i Insygnia śmierci",  130);
        Movie secondMovie = new Movie("Kill Bill",  100);
        Movie thirdMovie = new Movie("Fast and Furious",  190);

        return  List.of(firstMovie, secondMovie, thirdMovie);
    }

    private List<Room> getThreeRooms() {
        Room roomSmall = generateRoom(10, 20);
        Room roomMedium = generateRoom(20, 30);
        Room roomBig = generateRoom(20, 40);

        return List.of(roomSmall, roomMedium, roomBig);
    }

    private Room generateRoom(int rowAmount, int seatsInRow) {
        Seat [][] seatsToScreeningRoom = new Seat[rowAmount][seatsInRow];
        Room room = new Room(seatsToScreeningRoom);

        for (int i = 0; i < room.getSeats().length; i++){
            for (int j = 0; j < room.getSeats()[i].length; j++){
                room.getSeats()[i][j] = new Seat(i+1, j+1, false);
            }
        }

        return room;
    }
}
