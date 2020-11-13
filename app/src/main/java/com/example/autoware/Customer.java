package com.example.autoware;

public class Customer {
    private String Name = "";
    private String Loaction = "";
    private String Email = "";
    public Customer() {
    }
    public Customer(String name, String loaction, String email) {
        Name = name;
        Loaction = loaction;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public String getLoaction() {
        return Loaction;
    }

    public String getEmail() {
        return Email;
    }
}
