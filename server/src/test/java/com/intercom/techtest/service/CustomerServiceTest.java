package com.intercom.techtest.service;

import com.intercom.techtest.exception.CustomerServicerException;
import com.intercom.techtest.models.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CustomerServiceTest {

    @Test
    public void testParserWithSort() throws IOException, CustomerServicerException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test1.txt").getFile());

        List<Customer> listResult = new CustomerService().find(new FileInputStream(file), 100);

        Assert.assertEquals(listResult.size(), 16);

        Customer previous = null;

        for (Customer customer : listResult) {

            if (previous != null) {
                Assert.assertTrue(customer.user_id > previous.user_id);
            }

            previous = customer;

        }

    }

    @Test(expected = CustomerServicerException.class)
    public void testParserInvalidFile() throws FileNotFoundException, CustomerServicerException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("invalidFile.txt").getFile());
        new CustomerService().find(new FileInputStream(file), 100);


    }
}
