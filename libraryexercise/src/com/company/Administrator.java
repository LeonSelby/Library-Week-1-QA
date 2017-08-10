package com.company;

import com.company.entity.Customer;

import java.time.LocalDate;


public class Administrator {

    public void checkOut(Booking booking) {
        //Adds booking to customers active bookings
        booking.getAssociatedCustomer().addToActiveBookings(booking);
        //sets contained items CheckOut boolean to true.
        for (int i = 0; i < booking.getLibraryItems().size(); i++) {
            booking.getLibraryItems().get(i).setCheckedOut(true);
        }
    }

    public void checkIn(Booking booking) {
        //Removes booking from Customers list of active bookings
        booking.getAssociatedCustomer().removeFromActiveBookings(booking);

        //Adds bookings to Customer's list of prev bookings
        booking.getAssociatedCustomer().addToPrevBookings(booking);

        //Sets items from booking checkedOut to false, and adds booking to its list of prev booking
        for (int i = 0; i < booking.getLibraryItems().size(); i++) {
            booking.getLibraryItems().get(i).setCheckedOut(false);
            booking.getLibraryItems().get(i).addToListOfPrevBookings(booking);
        }
    }

    public void createCustomer(Library library, String name, String addressLine1, String country,
                               LocalDate dateJoined, int age) {
        Customer c1 = new Customer(name, addressLine1, country, dateJoined, age);
        library.addCustomer(c1);
    }

    public String createReportOn(Reportable reportable){
       return reportable.generateReport();
    }

    public void printToConsoleReportOn(Reportable reportable){
        System.out.println(createReportOn(reportable));
    }
}
