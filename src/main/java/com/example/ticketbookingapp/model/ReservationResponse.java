package com.example.ticketbookingapp.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReservationResponse {
    private BigDecimal totalCost;
    private LocalDateTime expireDate;
}
