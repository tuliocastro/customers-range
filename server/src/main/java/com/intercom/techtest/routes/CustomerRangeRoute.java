package com.intercom.techtest.routes;

import com.intercom.techtest.constants.AppConstant;
import com.intercom.techtest.models.Customer;
import com.intercom.techtest.service.CustomerService;
import com.intercom.techtest.transformers.JsonTransformer;

import javax.servlet.MultipartConfigElement;

import java.io.InputStream;
import java.util.List;

import static spark.Spark.*;

public class CustomerRangeRoute {

    public CustomerRangeRoute() {

        post(AppConstant.CUSTOMER_ENDPOINT, (req, res) -> {

            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

            InputStream is = req.raw().getPart("file").getInputStream();

            List<Customer> customers = new CustomerService().find(is, AppConstant.DISTANCE_KM);

            return customers;

        }, new JsonTransformer());

    }
}
