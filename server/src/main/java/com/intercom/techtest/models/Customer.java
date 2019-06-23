package com.intercom.techtest.models;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.intercom.techtest.constants.AppConstant;
import com.intercom.techtest.utils.CoordinateUtil;

/**
 * This model represents a customer which has a latitude and longitude points
 */
public class Customer implements Comparable<Customer> {

    @Expose
    public Long user_id;
    public String latitude;
    public String longitude;

    @Expose
    public String name;
    public double distance;

    public Coordinate getCoordinate() {
        return new Coordinate(latitude, longitude);
    }

    @Override
    public int compareTo(Customer o) {
        return this.user_id.compareTo(o.user_id);
    }
}
