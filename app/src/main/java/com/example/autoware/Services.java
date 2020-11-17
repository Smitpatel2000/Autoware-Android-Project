package com.example.autoware;

import java.util.ArrayList;

public class Services {
    private String customerID;
    private String serviceID;
    private String ownerID;
    private ArrayList<String> cars;
    private Boolean towingFlag;
    private String date;

    public Services() {
    }

    public Services(String customerID, String serviceID, String ownerID, ArrayList<String> cars, Boolean towingFlag, String date) {
        this.customerID = customerID;
        this.serviceID = serviceID;
        this.ownerID = ownerID;
        this.cars = cars;
        this.towingFlag = towingFlag;
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public ArrayList<String> getCars() {
        return cars;
    }

    public void setCars(ArrayList<String> cars) {
        this.cars = cars;
    }

    public Boolean getTowingFlag() {
        return towingFlag;
    }

    public void setTowingFlag(Boolean towingFlag) {
        this.towingFlag = towingFlag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
