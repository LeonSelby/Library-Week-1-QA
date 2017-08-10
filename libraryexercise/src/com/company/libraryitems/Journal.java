package com.company.libraryitems;

import com.company.Reportable;
import com.company.entity.Entity;

import java.time.LocalDate;

public class Journal extends LibraryItem{
    private int issueNumber = 1;
    private int volumeNumber = 1;

    //Constructor
    public Journal(String title, Entity source, LocalDate publishDate, int issueNumber, int volumeNumber) {
        super(title, source, publishDate);
        this.issueNumber = issueNumber;
        this.volumeNumber = volumeNumber;
    }

    //Getters and Setters
    public int getIssueNumber() {
        return this.issueNumber;
    }

    public int getVolumeNumber() {
        return this.volumeNumber;
    }

    public String getIssueVolumeString(){
        return "Issue Number: "+this.getIssueNumber()+". Volume Number: "+this.getVolumeNumber();
    }

    @Override
    public String generateReport(){
        String tmp = "";
        String checkout;
        String reserved;
        if (this.isCheckedOut()) {
            checkout = "checked out";
        } else checkout = " not checked out";
        if (this.isReserved()) {
            reserved = "reserved.";
        } else {
            reserved = "not reserved.";
        }

        tmp += this.getClass().getSimpleName() + " Report:\n" +
                "Name: " + this.getTitle() +
                "\nItem ID: " + this.getItemID() +
                "\nIt is " + checkout +
                "\nIt is " + reserved +
                "\nSource: " + (this).getSource().getName() +
                "\n"+ this.getIssueVolumeString()+".";
    return tmp;
    }
}
