package com.example.ticketbookingapp;

import com.example.ticketbookingapp.model.Movie;
import com.example.ticketbookingapp.model.ScreeningRoom;
import com.example.ticketbookingapp.model.Seat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class TicketBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingAppApplication.class, args);

//init 3 Screening Rooms
			Seat [][] seatsFirstScreeningRoom = new Seat[12][12];// 12 rzedow, 12,miejsc

			ScreeningRoom firstScreeningRoom = new ScreeningRoom(seatsFirstScreeningRoom);


			//wypelnienie
			for (int i = 0; i < firstScreeningRoom.getSeats().length; i++){
				for (int j = 0; j < firstScreeningRoom.getSeats()[i].length; j++){
					firstScreeningRoom.getSeats()[i][j] = new Seat(i, j, false);
				}
			}

			//wyświetlanie
			for (int i = 0; i < firstScreeningRoom.getSeats().length; i++){
				for (int j = 0; j < firstScreeningRoom.getSeats()[i].length; j++){
					System.out.print(firstScreeningRoom.getSeats()[i][j].getRowNumber() + "/" + firstScreeningRoom.getSeats()[i][j].getSeatNumber() + "    ");
				}
				System.out.println("       ");
			}

//init 3 movies
		Movie firstMovie = new Movie("Harry Potter i Insygnia śmierci", "J.K.Rowling", 130);
		Movie secondMovie = new Movie("Harry Potter i Kamień filozoficzny", "J.K.Rowling", 120);
		Movie thirdMovie = new Movie("Metro 2033", "Dmitry Glukhovsky", 190);


//Getting enum TicketTypes
		System.out.println(TicketTypes.ADULT.getPrice());
		System.out.println(TicketTypes.STUDENT.getPrice());
		System.out.println(TicketTypes.CHILD.getPrice());

	}






}
