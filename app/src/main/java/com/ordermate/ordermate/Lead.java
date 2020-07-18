package com.example.connect;

public class Lead {

    private String name;
    private double rating;
    private double distance;
    private double amount;

    public Lead(String nme, double rtng, double dist, double amt){
        name = nme;
        rating = rtng;
        distance = dist;
        amount = amt;
    }

    public String getName(){
        return name;
    }

    public double getRating() {
        return rating;
    }

    public double getDistance() {
        return distance;
    }

    public double getAmount() {
        return amount;
    }
}
