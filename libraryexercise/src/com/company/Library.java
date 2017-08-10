package com.company;

import com.company.entity.Customer;
import com.company.libraryitems.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> inventoryList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<Customer>();
    private static Administrator admin = new Administrator();

    //Getters and Setters
    public List<LibraryItem> getInventoryList() {
        return this.inventoryList;
    }

    public void setInventoryList(List<LibraryItem> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    //Methods

    public void addItemToInvList(LibraryItem item) {
        this.getInventoryList().add(item);
    }

    public void removeItemFromList(LibraryItem item) {
        this.getInventoryList().remove(item);
    }

    public void addCustomer(Customer customer){
        this.getCustomerList().add(customer);
    }

    public void removeCustomer(Customer customer){
        if(this.getCustomerList().contains(customer)){
            this.getCustomerList().remove(customer);
        }
    }
}
