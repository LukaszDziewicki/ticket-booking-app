package com.example.ticketbookingapp;

import com.example.ticketbookingapp.model.Movie;
import com.example.ticketbookingapp.model.Room;
import com.example.ticketbookingapp.model.Seance;
import com.example.ticketbookingapp.model.TicketTypesEnum;
import com.example.ticketbookingapp.service.MovieServiceImpl;
import com.example.ticketbookingapp.service.RoomServiceImpl;
import com.example.ticketbookingapp.service.SeanceServiceImpl;
import com.example.ticketbookingapp.structure.Seat;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class DBInitializer implements CommandLineRunner {

    private MovieServiceImpl movieService;
    private RoomServiceImpl roomService;
    private SeanceServiceImpl seanceService;

    public DBInitializer(MovieServiceImpl movieService,
                         RoomServiceImpl roomService,
                         SeanceServiceImpl seanceService) {
        this.movieService = movieService;
        this.roomService = roomService;
        this.seanceService = seanceService;
    }

    @Override
    public void run(String... args) {
        clearDB();

        movieService.saveAll(getThreeMovies());
        roomService.saveAll(getThreeRooms());
        seanceService.saveAll(getSixSeances());




    }

    private void clearDB(){
        movieService.deleteAll();
        roomService.deleteAll();
        seanceService.deleteAll();
    }

    private List<Movie> getThreeMovies(){
        Movie firstMovie = new Movie("Harry Potter",  130);
        Movie secondMovie = new Movie("Kill Bill",  100);
        Movie thirdMovie = new Movie("Fast and Furious",  190);

        return  List.of(firstMovie, secondMovie, thirdMovie);
    }

    private List<Room> getThreeRooms() {
        Room roomSmall = generateRoom(1, 10, 20);
        Room roomMedium = generateRoom(2, 20, 30);
        Room roomBig = generateRoom(3, 20, 40);

        return List.of(roomSmall, roomMedium, roomBig);
    }

    private Room generateRoom(int roomNumber, int rowAmount, int seatsInRow) {
        Seat [][] seatsToScreeningRoom = new Seat[rowAmount][seatsInRow];
        Room room = new Room(roomNumber, seatsToScreeningRoom);

        for (int i = 0; i < room.getSeats().length; i++){
            for (int j = 0; j < room.getSeats()[i].length; j++){
                room.getSeats()[i][j] = new Seat(i+1, j+1, false);
            }
        }

        return room;
    }

    //TODO change date format
    private List<Seance> getSixSeances() {
        Seance firstSeanceFirstRoom = createSeance("Harry Potter", 1, "2021-07-10 12:00:00");
        Seance secondSeanceFirstRoom = createSeance("Harry Potter", 1, "2021-07-10 16:00:00");

        Seance firstSeanceSecondRoom = createSeance("Kill Bill", 2, "2021-07-10 12:00:00");
        Seance secondSeanceSecondRoom = createSeance("Kill Bill", 2, "2021-07-10 16:00:00");

        Seance firstSeanceThirdRoom = createSeance("Fast and Furious", 3, "2021-07-10 12:00:00");
        Seance secondSeanceThirdRoom = createSeance("Fast and Furious", 3, "2021-07-10 16:00:00");

        return List.of(
                firstSeanceFirstRoom,
                secondSeanceFirstRoom,
                firstSeanceSecondRoom,
                secondSeanceSecondRoom,
                firstSeanceThirdRoom,
                secondSeanceThirdRoom
        );
    }

    //TODO handle try catch exceptions: date, null, invalid parameter
    private Seance createSeance(String movieTitle, int roomNumber, String seanceDate) {
        Movie movie = movieService.findMovieByTitle(movieTitle);
        Room room = roomService.findRoomByRoomNumber(roomNumber);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");

        Date date = null;
        try {
            date = dateFormat.parse(seanceDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Seance(movie, room, date);

    }
}
