package com.eandbsolutions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.JsonSyntaxException;

import java.util.Collections;
import java.util.Map;

public class FileHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        context.getLogger().log(String.format("received: {}", input));
        Response responseBody;
        String thing = "";
        try {
            FileService fs = new FileService();
            String fileContent = fs.findResourceFile("taco.txt");
            responseBody = new Response(String.format("Hello from Java Lambda. File Content: %s", fileContent), input);
        } catch (JsonSyntaxException e) {
            responseBody = new Response(String.format("Error message: %s", e.getMessage()), input);
            return ApiGatewayResponse.builder()
                    .setStatusCode(500)
                    .setObjectBody(responseBody)
                    .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                    .build();
        }

        return ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setObjectBody(responseBody)
                .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                .build();
    }
}
