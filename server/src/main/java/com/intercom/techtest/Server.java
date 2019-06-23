package com.intercom.techtest;

import com.intercom.techtest.middlewares.CorsMiddleware;
import com.intercom.techtest.routes.CustomerRangeRoute;
import com.intercom.techtest.routes.HealthCheckRoute;

/**
 * Spark Java server initializer
 */
public class Server {

    /**
     * Load all application routes
     */
    private static void loadRoutes() {

        new CorsMiddleware(); //Enable * for tests

        new HealthCheckRoute();
        new CustomerRangeRoute();

    }

    public static void main(String[] args) {

        loadRoutes();

    }

}
