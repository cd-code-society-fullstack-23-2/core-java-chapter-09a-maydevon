package com.codedifferently.partB;

import javax.print.attribute.standard.Destination;
import java.util.ArrayList;

public class Ticket {
    private Reservation reservation;

    public Ticket(Reservation reservation) {
        this.reservation = reservation;
    }

}
