package com.example.autoware;

public class Owner {
    private String name = "";
    private String garagename = "";
    private String location = "";

    public Owner(){}

    public Owner( String name, String garagename, String location) {
        this.name = name;
        this.garagename = garagename;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getGaragename() {
        return garagename;
    }

    public String getLocation() {
        return location;
    }
}
