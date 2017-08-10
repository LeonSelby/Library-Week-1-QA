package com.company.libraryitems;

import com.company.entity.Entity;

import java.time.LocalDate;

public class Newspaper extends LibraryItem {

    private TypeOfNewspaper typeOfNewspaper = null;
    private boolean isNSFW = false;

    //Constructor
    public Newspaper(String title, Entity source, LocalDate publishDate, TypeOfNewspaper typeOfNewspaper, boolean isNSFW) {
        super(title, source, publishDate);
        this.typeOfNewspaper = typeOfNewspaper;
        this.isNSFW = isNSFW;
    }

    //Getters and Setters
    public TypeOfNewspaper getTypeOfNewspaper() {
        return this.typeOfNewspaper;
    }

    public void setTypeOfNewspaper(TypeOfNewspaper typeOfNewspaper) {
        this.typeOfNewspaper = typeOfNewspaper;
    }

    public boolean isNSFW() {
        return this.isNSFW;
    }

    public void setNSFW(boolean NSFW) {
        isNSFW = NSFW;
    }

    //Reportable
    @Override
    public String generateReport() {
        String tmp = "";
        String checkout;
        String reserved;
        String nsfw="";

        if (this.isCheckedOut()) {
            checkout = "checked out";
        } else checkout = " not checked out";
        if (this.isReserved()) {
            reserved = "reserved.";
        } else {
            reserved = "not reserved.";
        }
        if((this).isNSFW()){
            nsfw = "not suitable for minors.";
        }else nsfw = "safe for minors.";

        tmp += this.getClass().getSimpleName() + " Report:\n" +
                "Name: " + this.getTitle() +
                "\nItem ID: " + this.getItemID() +
                "\nSource: " + this.getSource().getName() +
                "\nIt is " + checkout +
                "\nIt is " + reserved +
                "\nIt is "+ nsfw+
                "\nIt is a "+(this).getTypeOfNewspaper()+" newspaper.";
    return tmp;
    }
}
