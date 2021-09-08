package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;

import java.time.ZonedDateTime;

public class HealthHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    private ZonedDateTime startTime;

    public HealthHandler() {
//        startTime = ZonedDateTime.now();
    }

    public ApiGatewayResponse handleRequest(ApiGatewayRequest input, Context context) {
        startTime = ZonedDateTime.now();
        context.getLogger().log(String.format("received: {}", input));
//        Instant instant = new Instant();
//        String currentTime = instant.toString();
//        String responseBody = String.format("Hello from Java Lambda. Time is: %s", currentTime);
        String responseBody = String.format("Hello from Java Lambda. Time is: %s", startTime.toString());

        return new ApiGatewayResponse(200, responseBody);
    }
}
