package com.intercom.techtest.service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.intercom.techtest.constants.AppConstant;
import com.intercom.techtest.exception.CustomerServicerException;
import com.intercom.techtest.models.Customer;
import com.intercom.techtest.utils.CoordinateUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This service is responsible to transform an {@link InputStream} into a {@link List} of {@Link Customer}
 * sorted by user_id
 */
public class CustomerService {

    /**
     * Returns a Customer Stream from a {@link InputStream} containing a list of customers
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public Stream<Customer> stream(InputStream inputStream) throws CustomerServicerException {

        try {

            int n = inputStream.available();
            byte[] bytes = new byte[n];
            inputStream.read(bytes, 0, n);

            String content = new String(bytes, StandardCharsets.UTF_8);

            String[] lines = content.split(System.getProperty("line.separator"));

            List<Customer> customers = new ArrayList<>();

            for (String line : lines) {
                customers.add(parseCustomer(line));
            }

            return customers.stream();

        } catch (IOException e) {
            throw new CustomerServicerException("Invalid file", e);
        }
    }

    /**
     * Transform a json line string into a {@link Customer} object
     *  with a distance from the office
     * @param content
     * @return
     * @throws CustomerServicerException
     */
    public Customer parseCustomer(String content) throws CustomerServicerException {
        try {
            Customer customer = new Gson().fromJson(content, Customer.class);
            customer.distance = CoordinateUtil.distance(customer.getCoordinate(), AppConstant.OFFICE_COORDINATE);
            return customer;
        } catch (JsonSyntaxException e) {
            throw new CustomerServicerException("Invalid structure", e);
        }
    }

    /**
     * Given a file with a list of customers, find all customers in a range
     *
     * @param file
     * @param range in kilometers
     * @return
     * @throws IOException
     */
    public List<Customer> find(File file, int range) throws CustomerServicerException, FileNotFoundException {
        return find(new FileInputStream(file), range);
    }

    /**
     * Given a file with a list of customers, find all customers in a range
     *
     * @param inputStream
     * @param range       in kilometers
     * @return
     * @throws IOException
     */
    public List<Customer> find(InputStream inputStream, int range) throws CustomerServicerException {

        return this.stream(inputStream)
                .filter(c -> c.distance < range)
                .sorted()
                .collect(Collectors.toList());

    }


}

