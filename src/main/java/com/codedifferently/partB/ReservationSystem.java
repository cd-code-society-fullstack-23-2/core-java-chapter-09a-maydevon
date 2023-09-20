package com.codedifferently.partB;

import java.util.ArrayList;
import java.util.Date;

public class ReservationSystem {

    private ArrayList<Reservation> reservations;

    public ReservationSystem() {
        reservations = new ArrayList<>();
    }

    public void bookSeat(int seatNumber, Date bookingDate)
            throws OverlappingReservationException, PaymentFailureException, InvalidBookingDateException {

        Date currentDate = new Date();
        if (bookingDate.compareTo(currentDate) < 0) {
            throw new InvalidBookingDateException("aht aht");
        }

        for (int i = 0; i < reservations.size(); i++) {
            Reservation currentReservation = reservations.get(i);
            if (currentReservation.getSeatNumber() == seatNumber &&
                    currentReservation.getBookingDate().equals(bookingDate)) {
                throw new OverlappingReservationException("too slow");
            }
        }
        Payment payment = new Payment(100);
        boolean paymentSuccess = payment.process();
        if (paymentSuccess == false) {
            throw new PaymentFailureException("Broke people should never laugh!");
        }

        Reservation newReservation = new Reservation(seatNumber, bookingDate);
        reservations.add(newReservation);
    }
}
