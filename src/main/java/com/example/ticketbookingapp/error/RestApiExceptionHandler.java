package com.example.ticketbookingapp.error;

import com.example.ticketbookingapp.error.exception.ReservationNotFoundException;
import com.example.ticketbookingapp.error.exception.SeanceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;


@RestControllerAdvice
public class RestApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SeanceNotFoundException.class)
    public ResponseEntity<Object> handleSeanceNotFoundException(SeanceNotFoundException ex) {
    HttpStatus notFoundStatus = HttpStatus.NOT_FOUND;
    RestApiException restApiException = new RestApiException(
            ex.getMessage(),
            notFoundStatus,
            LocalDateTime.now()
    );
        return new ResponseEntity<>(restApiException, notFoundStatus);
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<Object> handleReservationNotFoundException(ReservationNotFoundException ex) {
        HttpStatus notFoundStatus = HttpStatus.NOT_FOUND;
        RestApiException restApiException = new RestApiException(
                ex.getMessage(),
                notFoundStatus,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(restApiException, notFoundStatus);
    }




}
