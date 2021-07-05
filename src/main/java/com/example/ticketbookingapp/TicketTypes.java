package com.example.ticketbookingapp;

import java.math.BigDecimal;

public enum TicketTypes {
    ADULT(new BigDecimal(25)),
    STUDENT(new BigDecimal(18)),
    CHILD(new BigDecimal(12.50));

    private BigDecimal price;


    TicketTypes(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
