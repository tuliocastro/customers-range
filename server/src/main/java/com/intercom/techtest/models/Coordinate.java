package com.intercom.techtest.models;

/**
 * This model represents a coordinate point with latitude and longitude
 */
public class Coordinate {

    public double latitude;
    public double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinate(String latitude, String longitude) {
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
    }

}
