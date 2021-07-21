package com.example.ticketbookingapp;

import com.example.ticketbookingapp.model.Movie;
import com.example.ticketbookingapp.model.Room;
import com.example.ticketbookingapp.model.Seance;
import com.example.ticketbookingapp.service.MovieServiceImpl;
import com.example.ticketbookingapp.service.RoomServiceImpl;
import com.example.ticketbookingapp.service.SeanceServiceImpl;
import com.example.ticketbookingapp.model.Seat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class DBInitializer implements CommandLineRunner {

    private final MovieServiceImpl movieService;
    private final RoomServiceImpl roomService;
    private final SeanceServiceImpl seanceService;

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
        movieService.saveAll(getListOfThreeMovies());
        roomService.saveAll(getListOfThreeRooms());
        seanceService.saveAll(getListOfSixSeances());
    }

    private void clearDB(){
        movieService.deleteAll();
        roomService.deleteAll();
        seanceService.deleteAll();
    }

    private List<Movie> getListOfThreeMovies(){
        Movie firstMovie = new Movie("Harry Potter", Duration.parse("PT120M"));
        Movie secondMovie = new Movie("Kill Bill", Duration.parse("PT130M"));
        Movie thirdMovie = new Movie("Fast and Furious", Duration.parse("PT190M"));

        return  List.of(firstMovie, secondMovie, thirdMovie);
    }

    private List<Room> getListOfThreeRooms() {
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

    private List<Seance> getListOfSixSeances(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s");
            Seance firstSeance = createSeance(
                    "Harry Potter",
                    1,
                    LocalDateTime.parse("2021-07-10 12:00:00", dateTimeFormatter)
            );

            Seance secondSeance = createSeance(
                    "Harry Potter",
                    1,
                    LocalDateTime.parse("2021-07-10 16:00:00", dateTimeFormatter)
            );


            Seance thirdSeance = createSeance(
                    "Kill Bill",
                    2,
                    LocalDateTime.parse("2021-07-10 13:00:00", dateTimeFormatter)
            );

            Seance fourthSeance = createSeance(
                    "Kill Bill",
                    2,
                    LocalDateTime.parse("2021-07-10 21:00:00", dateTimeFormatter)
            );


            Seance fifthSeance = createSeance(
                    "Fast and Furious",
                    3,
                    LocalDateTime.parse("2021-07-10 11:00:00", dateTimeFormatter)
            );

            Seance sixthSeance = createSeance(
                    "Fast and Furious",
                    3,
                    LocalDateTime.parse("2021-07-10 16:00:00", dateTimeFormatter)
            );

        return List.of(
                    firstSeance,
                    secondSeance,
                    thirdSeance,
                    fourthSeance,
                    fifthSeance,
                    sixthSeance
            );
    }

    private Seance createSeance(String movieTitle, int roomNumber, LocalDateTime seanceDate) {
        Movie movie = movieService.findMovieByTitle(movieTitle);
        Room room = roomService.findRoomByRoomNumber(roomNumber);

        return new Seance(movie, room, seanceDate);
    }
}
