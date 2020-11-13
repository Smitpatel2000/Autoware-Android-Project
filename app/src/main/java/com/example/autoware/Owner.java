package com.example.autoware;

public class Owner {
    private String Name = "";
    private String Garagename = "";
    private String Location = "";

    public Owner(){}

    public Owner( String name, String garagename, String location) {
        Name = name;
        Garagename = garagename;
        Location = location;
    }

    public String getName() {
        return Name;
    }

    public String getGaragename() {
        return Garagename;
    }

    public String getLocation() {
        return Location;
    }
}
