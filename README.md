# Ticket-booking-app
## Table of contents
* [Introduction](#Introduction)
* [Build](#Build)
* [Curl](#Curl)
* [Postman](#Postman)
* [Pull](#Pull)

## Introduction
The goal is to build a seat reservation system for a multiplex.
## Build
To build project open as a project in IntelliJ IDE and run, server started on port :8085
## Curl
The user selects the day and the time when he/she would like to see the movie.

    curl -X POST -H "Content-type: application/json" -d '{ "seanceDate": "2021-07-10T12:00:00" }' 'http://localhost:8085/seances/'
    
The system lists movies available in the given time interval - title and screening times.
    
    curl -X GET http://localhost:8085/seances/2021-07-10/12:55:00
    
The user chooses a particular screening.

    curl -X POST -H "Content-type: application/json" -d '{"movie": {"title": "Kill Bill"},"seanceDate": "2021-07-10T13:00:00"}' 'http://localhost:8085/seances/'
    
The system gives information regarding screening room and available seats.

    curl -X GET http://localhost:8085/seances/Kill Bill/2021-07-10/13:00:00
    
The user chooses seats, and gives the name of the person doing the reservation (name and surname)
    
    curl -X POST -H "Content-type: application/json" -d '{
    "seance":{
        "movie": {
            "title": "Kill Bill"
        },
    "seanceDate": "2021-07-10T13:00:00"
    },
    "name": "Łukasz",
    "surname": "Dziewicki",
    "adultSeats": 1,
    "studentSeats": 1,
    "childSeats": 1,
    
    "reservedSeats": [
    {
        "rowNumber":5,
        "seatNumber":10 
    },
    {
        "rowNumber":5,
        "seatNumber":11
    },
    {
        "rowNumber":5,
        "seatNumber":12
    }
    ]
    }' 'http://localhost:8085/seances/'
## Postman

1. The user selects the day and the time when he/she would like to see the movie.
2. The system lists movies available in the given time interval - title and screening
times.

        POST    http://localhost:8085/seances/
        
        BODY
        {
            "seanceDate": "2021-07-10T12:00:00"
        }
    
3. The user chooses a particular screening.
4. The system gives information regarding screening room and available seats.

        POST    http://localhost:8085/seances/search/particular
            
        BODY 
        {
            "movie": {
                "title": "Kill Bill"
            },
            "seanceDate": "2021-07-10T13:00:00"
        }
    
5. The user chooses seats, and gives the name of the person doing the reservation
(name and surname).
6. The system gives back the total amount to pay and reservation expiration time.

        POST    http://localhost:8085/reservations/details
            
        BODY 
       {
        "seance":{
            "movie": {
                "title": "Kill Bill"
            },
        "seanceDate": "2021-07-10T13:00:00"
        },
        "name": "Łukasz",
        "surname": "Dziewicki",
        "adultSeats": 1,
        "studentSeats": 1,
        "childSeats": 1,
        
        "reservedSeats": [
        {
            "rowNumber":5,
            "seatNumber":10 
        },
        {
            "rowNumber":5,
            "seatNumber":11
        },
        {
            "rowNumber":5,
            "seatNumber":12
        }
        ]
       }
       
## Pull repository
You can pull repository [here](https://github.com/LukaszDziewicki/ticket-booking-app/archive/refs/heads/main.zip)
