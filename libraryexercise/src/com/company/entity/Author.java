package com.company.entity;


import java.time.LocalDate;

public class Author extends Entity {
    private LocalDate dateOfBirth;


    //Constructors
    public Author(String name, String country, LocalDate dateOfBirth) {
        super(name, "", country);
        this.dateOfBirth = dateOfBirth;
    }

    //Getters and Setters
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

}
