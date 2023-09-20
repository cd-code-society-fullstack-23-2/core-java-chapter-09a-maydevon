package com.codedifferently.partB;

import java.util.Date;
import java.util.Scanner;

public class Main {

    private static Plane plane;
    private static ReservationSystem reservationSystem = new ReservationSystem();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        plane = new Plane(1, 10, "New York", "10:30 AM", FlightType.DOMESTIC);

        int choice = getMenuChoice();

        while (choice != 4) {
            switch (choice) {
                case 1:
                    displayAvailableSeats();
                    break;
                case 2:
                    bookSeat();
                    break;
                case 3:
                    displayAllBookings();
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
            choice = getMenuChoice();
        }

        System.out.println("Exiting...");
        scanner.close();
    }

    private static int getMenuChoice() {
        displayMenu();
        return scanner.nextInt();
    }

    private static void displayMenu() {
        System.out.println("\nBaron Air Reservation System");
        System.out.println("1. Display Available Seats");
        System.out.println("2. Book a Seat");
        System.out.println("3. Display All Bookings");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayAvailableSeats() {
        System.out.println("\nSeats that are available:");
        for (int i = 0; i < plane.getSeats().length; i++) {
            if (plane.isSeatAvailable(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void bookSeat() {
        System.out.print("\nPlease enter the seat number you want to book: ");
        int chosenSeatNumber = scanner.nextInt();

        if (plane.isSeatAvailable(chosenSeatNumber)) {
            try {
                Date dateOfBooking = new Date();
                reservationSystem.bookSeat(chosenSeatNumber, dateOfBooking);
                plane.assignSeat(chosenSeatNumber, new Ticket(new Reservation(chosenSeatNumber, dateOfBooking)));
                System.out.println("Congratulations! Your seat has been booked.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Sorry, the seat is already booked or not available.");
        }
    }

    private static void displayAllBookings() {
        System.out.println("\nAll Booked Seats:");
        for (int i = 0; i < plane.getSeats().length; i++) {
            if (!plane.isSeatAvailable(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
