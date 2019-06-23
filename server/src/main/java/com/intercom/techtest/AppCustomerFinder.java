package com.intercom.techtest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intercom.techtest.constants.AppConstant;
import com.intercom.techtest.exception.CustomerServicerException;
import com.intercom.techtest.models.Customer;
import com.intercom.techtest.service.CustomerService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class AppCustomerFinder {

    public static void main(String[] args) {

        try {

            if (args.length == 0 || !new File(args[0]).exists()) {
                throw new FileNotFoundException("Please provide a valid file");
            }

            File file = new File(args[0]);

            List<Customer> customersList = new CustomerService().find(file, AppConstant.DISTANCE_KM);

            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            String jsonString = gson.toJson(customersList);

            System.out.println(jsonString);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (CustomerServicerException e) {
            e.printStackTrace();
        }

    }
}
