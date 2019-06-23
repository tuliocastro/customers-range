package com.intercom.techtest.utils;

import com.intercom.techtest.constants.AppConstant;
import com.intercom.techtest.models.Coordinate;
import org.junit.Assert;
import org.junit.Test;

public class CoordinateUtilTest {

    @Test
    public void testDistanceInRange() {

        Coordinate c1 = new Coordinate(52.986375, -6.043701);
        Coordinate dublinOffice = new Coordinate(53.339428, -6.257664);

        double distance = CoordinateUtil.distance(c1, dublinOffice);

        Assert.assertTrue(distance < AppConstant.DISTANCE_KM);

    }

    @Test
    public void testDistanceNotInRange() {

        Coordinate c1 = new Coordinate(54.374208, -8.371639);
        Coordinate dublinOffice = new Coordinate(53.339428, -6.257664);

        double distance = CoordinateUtil.distance(c1, dublinOffice);

        Assert.assertFalse(distance < AppConstant.DISTANCE_KM);

    }

    @Test
    public void testDistanceWithInvertedCoordinates() {

        Coordinate c1 = new Coordinate(54.374208, -8.371639);
        Coordinate dublinOffice = new Coordinate(53.339428, -6.257664);

        double distance = CoordinateUtil.distance(dublinOffice, c1);

        Assert.assertFalse(distance < AppConstant.DISTANCE_KM);

    }


    @Test
    public void testDistanceNotInRange2() {

        Coordinate c1 = new Coordinate(0, 0);
        Coordinate c2 = new Coordinate(53.339428, -6.257664);

        double distance = CoordinateUtil.distance(c1, c2);

        Assert.assertFalse(distance < AppConstant.DISTANCE_KM);

    }
}
