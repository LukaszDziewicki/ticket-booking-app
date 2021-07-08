package com.example.ticketbookingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketBookingAppApplication {



	public static void main(String[] args) {
		SpringApplication.run(TicketBookingAppApplication.class, args);



	}
}
/*

//init 3 movies

	Movie secondMovie = new Movie("Harry Potter i Kamień filozoficzny", "J.K.Rowling", 120);
	Movie thirdMovie = new Movie("Metro 2033", "Dmitry Glukhovsky", 190);


//Getting enum TicketTypes
		System.out.println(TicketTypesEnum.ADULT.getPrice());
		System.out.println(TicketTypesEnum.STUDENT.getPrice());
		System.out.println(TicketTypesEnum.CHILD.getPrice());
	public void run(String... args) throws Exception {


		showScreeningRoom(screeningRoomBig);



		Movie firstMovie = new Movie("Harry Potter i Insygnia śmierci", "J.K.Rowling", 130);
		movieService.save(firstMovie);


	}





	public void showScreeningRoom(ScreeningRoom screeningRoom){
		for (int i = 0; i < screeningRoom.getSeats().length; i++){
			for (int j = 0; j < screeningRoom.getSeats()[i].length; j++){
				System.out.print(
						screeningRoom.getSeats()[i][j].getRowNumber() + "/" +
								screeningRoom.getSeats()[i][j].getSeatNumber() + "   "
				);
			}
			System.out.println("       ");
		}
	}*/





