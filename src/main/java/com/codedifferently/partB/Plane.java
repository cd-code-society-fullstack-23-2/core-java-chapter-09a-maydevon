package com.codedifferently.partB;

import com.codedifferently.partB.FlightType;
import com.codedifferently.partB.Ticket;

public class Plane {
    private int id;
    private Ticket[] seats;
    private String destination;
    private String departureTime;
    private FlightType flightType;

    public Plane(int id, int numberOfSeats, String destination, String departureTime, FlightType flightType) {
        this.id = id;
        this.seats = new Ticket[numberOfSeats];
        this.destination = destination;
        this.departureTime = departureTime;
        this.flightType = flightType;
    }

    public Plane(String ohio, String s, int i) {
    }

    public int getId() {
        return id;
    }

    public Ticket[] getSeats() {
        return seats;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public boolean isSeatAvailable(int seatNumber) {
        return seats[seatNumber] == null;
    }

    public void assignSeat(int seatNumber, Ticket ticket) {
        seats[seatNumber] = ticket;
    }
}
