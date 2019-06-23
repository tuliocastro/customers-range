package com.intercom.techtest.utils;

import com.intercom.techtest.models.Coordinate;

/**
 * Utilitary methods for coordinates
 */
public class CoordinateUtil {


    private static final int EARTH_RADIUS = 6371;

    /**
     * Calculates the shortest distance between two coordinates using Haversine formula
     *
     * <i>Source: https://en.wikipedia.org/wiki/Great-circle_distance</i>
     * <i>Source: https://rosettacode.org/wiki/Haversine_formula#Java</i>
     *
     * @param c1 {@link Coordinate} any given coordinate point
     * @param c2 {@link Coordinate} any given coordinate point
     * @return total {@link Double} distance in kilometers
     */
    public static Double distance(Coordinate c1, Coordinate c2) {

        double diffLati = Math.toRadians(c2.latitude - c1.latitude);
        double diffLong = Math.toRadians(c2.longitude - c1.longitude);

        double radiusStartLati = Math.toRadians(c1.latitude);
        double radiusEndLati = Math.toRadians(c2.latitude);

        double a = Math.pow(Math.sin(diffLati / 2), 2) + Math.pow(Math.sin(diffLong / 2), 2) * Math.cos(radiusStartLati) * Math.cos(radiusEndLati);
        double c = 2 * Math.asin(Math.sqrt(a));

        return EARTH_RADIUS * c;

    }
}
