package com.company.entity;

public abstract class Entity {

    private String name;
    private String addressLine1;
    private String addressLineCountry;

    //Constructor
      public Entity(String name, String addressLine1, String addressCountry) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLineCountry = addressCountry;
    }

    //Getters and Setters
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.addressLine1 + "\n" + this.addressLineCountry;
    }

    public String getCountry(){
       return this.addressLineCountry;
   }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressCountry(String addressLineCountry) {
        this.addressLineCountry = addressLineCountry;
    }

}
