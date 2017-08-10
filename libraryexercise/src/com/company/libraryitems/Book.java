package com.company.libraryitems;

import com.company.Reportable;
import com.company.entity.Entity;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Book extends LibraryItem implements Reportable {
    private Genre masterGenre;
    private List<Genre> genreList = new ArrayList<Genre>();
    private Backing backing;

    //Constructor
    public Book(String title, Entity source, LocalDate publishDate, Genre masterGenre, Backing backing) {
        super(title, source, publishDate);
        this.masterGenre = masterGenre;
        this.genreList.add(masterGenre);
        this.backing = backing;
    }


    //Getters and Setters
    public List<Genre> getGenre() {
        return this.genreList;
    }

    public Backing getBacking() {
        return this.backing;
    }

    public void setBacking(Backing backing) {
        this.backing = backing;
    }

    public List<Genre> getGenreList() {
        return this.genreList;
    }

    //Methods
    public void addGenre(Genre genre) {
        this.genreList.add(genre);
    }

    public void removeGenre(Genre genre) {
        this.genreList.remove(genre);
    }

    public boolean hasGenre(Genre genre) {
        return this.genreList.contains(genre);
    }


    //Reportable
    @Override
    public String generateReport() {
        String tmp = "";
        String genres = "";
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
        for (Genre g : this.getGenreList()) {
            genres += " " + g;
        }

        tmp += this.getClass().getSimpleName() + " Report:\n" +
                "Name: " + this.getTitle() +
                "\nItem ID: " + this.getItemID() +
                "\nIt is " + checkout +
                "\nIt is " + reserved +
                "\nSource: " + (this).getSource().getName() +
                "\nBacking: " + this.getBacking() +
                "\nGenres are:" + genres + ".";
        return tmp;
    }
}
