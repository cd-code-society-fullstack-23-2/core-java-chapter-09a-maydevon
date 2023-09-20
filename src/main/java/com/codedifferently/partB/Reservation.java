package com.codedifferently.partB;

import java.util.Date;

public class Reservation {
    private int seatNumber;
    private double amountPaid;
    private PaymentStatus paymentStatus;
    private Date bookingDate;

    public Reservation(int seatNumber, Date bookingDate) {
        this.seatNumber = seatNumber;
        this.bookingDate = bookingDate;
    }

    public int getSeatNumber() {
        return 0;
    }

    public Object getBookingDate() {
        return null;
    }
}
