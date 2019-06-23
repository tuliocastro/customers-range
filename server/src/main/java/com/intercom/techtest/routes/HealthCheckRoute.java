package com.intercom.techtest.routes;

import com.intercom.techtest.constants.AppConstant;

import static spark.Spark.*;

public class HealthCheckRoute {

    public HealthCheckRoute() {

        get(AppConstant.HEALTH_CHECK_ENDPOINT, (req, res) -> "ok");

    }

}
