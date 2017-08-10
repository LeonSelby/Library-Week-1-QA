package com.company.entity;

import java.time.LocalDate;

public class Publisher extends Entity{
    private LocalDate established;


    //Constructor
    public Publisher(String name, String addressLine1, String addressCountry, LocalDate established) {
        super(name, addressLine1, addressCountry);
        this.established = established;
    }

    //Getters and Setters
    public LocalDate getEstablished() {
        return this.established;
    }
}
