package com.intercom.techtest.transformers;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Spark transformer from string to json
 */
public class JsonTransformer implements ResponseTransformer {


    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }
}
