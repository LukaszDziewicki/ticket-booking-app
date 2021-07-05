package com.example.ticketbookingapp.model;

public class Movie {
    private String title;
    private String author;
    private int durationInMinutes;

    public Movie(String title, String author, int durationInMinutes) {
        this.title = title;
        this.author = author;
        this.durationInMinutes = durationInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
