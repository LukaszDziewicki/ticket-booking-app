package com.example.ticketbookingapp;

import java.math.BigDecimal;

public enum TicketTypes {
    ADULT(BigDecimal.valueOf(25)),
    STUDENT(BigDecimal.valueOf(18)),
    CHILD(BigDecimal.valueOf(12.50));

    private BigDecimal price;


    TicketTypes(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
