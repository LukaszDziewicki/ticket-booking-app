package com.example.ticketbookingapp.controller;

import com.example.ticketbookingapp.error.exception.ReservationNotFoundException;
import com.example.ticketbookingapp.model.Reservation;
import com.example.ticketbookingapp.model.ReservationResponse;
import com.example.ticketbookingapp.service.ReservationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;


@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationServiceImpl reservationService;

    public ReservationController(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping("/details")
    @ResponseStatus(HttpStatus.OK)
    public ReservationResponse sendReservationDetails(@RequestBody Reservation reservation) {
        if(Objects.isNull(reservation)){
            throw new ReservationNotFoundException();
        }
        return reservationService.generateReservationResponse(reservation);
    }



}
