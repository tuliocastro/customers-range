package com.intercom.techtest.constants;

import com.intercom.techtest.models.Coordinate;

/**
 * Define constants that are used application-wide.
 */
public class AppConstant {

    public static final Coordinate OFFICE_COORDINATE = new Coordinate(53.339428, -6.257664);

    public static final int DISTANCE_KM = 100;

    public static final Integer DEFAULT_PORT = 4567;

    public static final String HEALTH_CHECK_ENDPOINT = "/health";

    public static final String CUSTOMER_ENDPOINT = "/customer";

}
