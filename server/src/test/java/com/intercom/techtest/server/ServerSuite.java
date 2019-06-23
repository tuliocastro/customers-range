package com.intercom.techtest.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intercom.techtest.Server;
import com.intercom.techtest.constants.AppConstant;
import com.intercom.techtest.models.Customer;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import com.ning.http.client.multipart.FilePart;
import com.ning.http.client.multipart.Part;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ServerSuite {


    AsyncHttpClient httpClient = new AsyncHttpClient();

    Gson gson = new GsonBuilder().create();

    @BeforeClass
    public static void bootstrap() {
        Server.main(new String[]{});
    }

    @AfterClass
    public static void tearDown() {
        Spark.stop();
    }


    private String getURL(String input) {
        return String.format("http://localhost:%s%s", AppConstant.DEFAULT_PORT, input);
    }

    @Test
    public void testHealthCheck() throws ExecutionException, InterruptedException, IOException {

        String url = getURL(AppConstant.HEALTH_CHECK_ENDPOINT);

        Response response = httpClient.prepareGet(url).execute().get();

        String body = response.getResponseBody();

        Assert.assertEquals(body, "ok");

    }


    @Test
    public void testListCustomers() throws ExecutionException, InterruptedException, IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test1.txt").getFile());

        String url = getURL(AppConstant.CUSTOMER_ENDPOINT);

        Response response = httpClient.preparePost(url).addBodyPart(new FilePart("file", file)).execute().get();

        String body = response.getResponseBody();

        Customer[] listResult = new Gson().fromJson(body, Customer[].class);

        Assert.assertEquals(listResult.length, 16);

    }


}
