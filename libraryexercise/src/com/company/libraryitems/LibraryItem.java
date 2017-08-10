package com.company.libraryitems;

import com.company.Booking;
import com.company.Reportable;
import com.company.entity.Entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


public abstract class LibraryItem implements Reportable{
    public static int totalID = 1;
    private int itemID;
    private String title;
    private Entity source;
    private LocalDate publishDate;
    private List<Booking> listOfPrevBookings = new LinkedList<Booking>();
    private boolean checkedOut = false;
    private boolean reserved = false;

    //Constructors
/**String, source, publishDate*/
    public LibraryItem(String title, Entity source, LocalDate publishDate) {
        this.itemID = totalID++;
        this.title = title;
        this.source = source;
        this.publishDate = publishDate;
    }

    //Getters and Setters
    public int getItemID() {
        return this.itemID;
    }

    public String getTitle() {
        return this.title;
    }

    public Entity getSource() {
        return this.source;
    }

    public LocalDate getPublishDate() {
        return this.publishDate;
    }

    public List<Booking> getListOfPrevBookings() {
        return this.listOfPrevBookings;
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public boolean isReserved() {
        return this.reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    //Methods
    public void addToListOfPrevBookings(Booking booking){
        this.listOfPrevBookings.add(booking);
    }

@Override
    public String generateReport(){
        return null;
}

}
