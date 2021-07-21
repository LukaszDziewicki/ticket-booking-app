package com.example.ticketbookingapp.service;

import com.example.ticketbookingapp.model.Reservation;
import com.example.ticketbookingapp.model.ReservationResponse;
import com.example.ticketbookingapp.model.TicketTypesEnum;
import com.example.ticketbookingapp.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ReservationServiceImpl {

    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationResponse generateReservationResponse(Reservation reservation) {
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setTotalCost(getTotalCost(reservation));
        reservationResponse.setExpireDate(getExpireDate(reservation));

        return reservationResponse;
    }

    public BigDecimal getTotalCost(Reservation reservation){
        BigDecimal totalCost = BigDecimal.valueOf(0);
        BigDecimal costOfAdultSeats = TicketTypesEnum.ADULT.getPrice().multiply(BigDecimal.valueOf(reservation.getAdultSeats()));
        BigDecimal costOfChildSeats = TicketTypesEnum.CHILD.getPrice().multiply(BigDecimal.valueOf(reservation.getChildSeats()));
        BigDecimal costOfStudentSeats = TicketTypesEnum.STUDENT.getPrice().multiply(BigDecimal.valueOf(reservation.getStudentSeats()));

        return totalCost.add(costOfAdultSeats).add(costOfChildSeats).add(costOfStudentSeats);
    }

    public LocalDateTime getExpireDate(Reservation reservation){
        return reservation.getSeance().getSeanceDate().minusHours(1);
    }


}
