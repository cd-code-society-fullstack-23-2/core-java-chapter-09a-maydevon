package com.codedifferently.partB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    private Plane plane = new Plane(1, 10, "Paris", "10:30 AM", FlightType.INTERNATIONAL);



    @Test
    void testAvailability() {
        assertTrue(plane.isSeatAvailable(5));

        java.util.Date bookingDate = new java.util.Date();
        Ticket ticket = new Ticket(new Reservation(5, bookingDate));
        plane.assignSeat(5, ticket);

        assertFalse(plane.isSeatAvailable(5));
    }

    @Test
    void AlreadyAssignedSeat() {
        java.util.Date bookingDate = new java.util.Date();
        Ticket ticket1 = new Ticket(new Reservation(5, bookingDate));
        Ticket ticket2 = new Ticket(new Reservation(5, bookingDate));

        plane.assignSeat(5, ticket1);
        plane.assignSeat(5, ticket2);

        assertFalse(plane.isSeatAvailable(5));
    }

}
