package com.company.entity;

import com.company.Booking;
import com.company.Reportable;
import com.company.libraryitems.LibraryItem;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Customer extends Entity implements Reportable {
    private LocalDate dateJoined;
    private List<Booking> activeBookings = new LinkedList<Booking>();
    private List<Booking> listOfPrevBookings = new LinkedList<Booking>();
    private boolean isVip = false;
    private int age;

    //Constructor
    public Customer(String name, String addressLine1, String addressCountry, LocalDate dateJoined, int age) {
        super(name, addressLine1, addressCountry);
        this.dateJoined = dateJoined;
        this.age = age;
    }

    //Getters and Setters

    public List<Booking> getListOfPrevBookings() {
        return this.listOfPrevBookings;
    }

    public LocalDate getDateJoined() {
        return this.dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public List<Booking> getActiveBookings() {
        return this.activeBookings;
    }

    public void setActiveBookings(List<Booking> activeBookings) {
        this.activeBookings = activeBookings;
    }

    public boolean isVip() {
        return this.isVip;
    }

    public void setVip(boolean vip) {
        this.isVip = vip;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isOver18() {
        boolean tmp = false;
        if (this.getAge() >= 18) {
            tmp = true;
        }
        return tmp;
    }

    public boolean isAnOAP() {
        boolean tmp = false;
        if (this.getAge() >= 65) {
            tmp = true;
        }
        return tmp;
    }

    public void addToActiveBookings(Booking booking) {
        this.getActiveBookings().add(booking);
    }

    public void removeFromActiveBookings(Booking booking) {
        this.getActiveBookings().remove(booking);
    }

    public void addToPrevBookings(Booking booking) {
        this.getListOfPrevBookings().add(booking);
    }

    //Reportable
    @Override
    public String generateReport() {
        String tmp = "";
        String membership;
        String renting = "";
        String rented = "";
        if ((this).isVip()) {
            membership = "VIP";
        } else {
            membership = "Standard";
        }
        for (LibraryItem li : (this).getActiveBookings().get(0).getLibraryItems()) {
            renting += " " + li.getTitle();
        }
        for (Booking b : (this).getListOfPrevBookings()) {

            for (LibraryItem li : b.getLibraryItems()) {
                rented += " " + li.getTitle();
            }
        }
        tmp += this.getClass().getSimpleName() + " Report:\n" +
                "Name: " + this.getName() +
                "\nAge: " + (this).getAge() +
                "\nMembership: " + membership +
                "\nCurrently has:" + renting + "." +
                "\nAnd has previously rented: " + rented + ".";
        return tmp;
    }
}
