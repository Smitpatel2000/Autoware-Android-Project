package com.example.autoware;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Services {
    private String customerID;
    private String serviceID;
    private String ownerID;
    private ArrayList<String> cars;
    private ArrayList<String> Spareparts;
    private ArrayList<Integer> Sparepartsprice;
    private Boolean towingFlag;
    private String date;
    private Boolean status;
    private String description;
    public Services() {
    }

    public ArrayList<String> getSpareparts() {
        return Spareparts;
    }

    public void setSpareparts(ArrayList<String> spareparts) {
        Spareparts = spareparts;
    }

    public ArrayList<Integer> getSparepartsprice() {
        return Sparepartsprice;
    }

    public void setSparepartsprice(ArrayList<Integer> sparepartsprice) {
        Sparepartsprice = sparepartsprice;
    }

    public Services(String customerID, String serviceID, String ownerID, ArrayList<String> cars, Boolean towingFlag, String date, Boolean status, String description) {
        this.customerID = customerID;
        this.serviceID = serviceID;
        this.ownerID = ownerID;
        this.cars = cars;
        this.towingFlag = towingFlag;
        this.date = date;
        this.status = status;
        this.description = description;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
