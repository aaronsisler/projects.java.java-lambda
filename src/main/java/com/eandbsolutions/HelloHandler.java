package com.eandbsolutions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input + "\n");
        KafkaService kafkaService = new KafkaService();
        String returnedValue = kafkaService.getTaco();
        context.getLogger().log("First: " + returnedValue + "\n");
        kafkaService.setTaco("more tacos");
        returnedValue = kafkaService.getTaco();

        context.getLogger().log("Second: " + returnedValue + "\n");

        // Reading file location
        kafkaService.findFile();

        return "Hello from Lambda";
    }

}
