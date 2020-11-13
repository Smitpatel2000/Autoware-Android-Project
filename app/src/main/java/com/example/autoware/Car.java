package com.example.autoware;

public class Car {
    private String RegistrationNumber;
    private String CustomerId;
    private String Brand;
    private String Model;
    private String FuelType;

    public Car() {
    }

    public Car(String registrationNumber, String customerId, String brand, String model, String fuelType) {
        RegistrationNumber = registrationNumber;
        CustomerId = customerId;
        Brand = brand;
        Model = model;
        FuelType = fuelType;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }
}
