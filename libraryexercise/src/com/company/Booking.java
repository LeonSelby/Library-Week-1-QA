package com.company;

import com.company.entity.Customer;
import com.company.entity.Entity;
import com.company.libraryitems.LibraryItem;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Booking {
    private Customer associatedCustomer;
    private LocalDate startDate;

    private List<LibraryItem> libraryItems = new ArrayList<LibraryItem>();
    private int durationInDays = 14;

    //Constructor
    public Booking(Customer associatedCustomer, LocalDate startDate) {
        this.associatedCustomer = associatedCustomer;
        this.startDate = startDate;
    }


    //Getters and Setters
    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<LibraryItem> getLibraryItems() {
        return this.libraryItems;
    }

    public void setLibraryItems(List<LibraryItem> libraryItems) {
        this.libraryItems = libraryItems;
    }

    public int getDurationInDays() {
        return this.durationInDays;
    }

    public Customer getAssociatedCustomer() {
        return this.associatedCustomer;
    }

    public void setAssociatedCustomer(Customer associatedCustomer) {
        this.associatedCustomer = associatedCustomer;
    }

    //Methods
    public void addToBooking(LibraryItem item) {
        this.libraryItems.add(item);
    }

    public void removeFromBooking(LibraryItem item) {
        this.libraryItems.remove(item);
    }

    public LocalDate getDueDate() {
        return this.startDate.plusDays(durationInDays);
    }
}

