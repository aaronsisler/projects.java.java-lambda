package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;
import org.joda.time.Instant;

public class HealthHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    public ApiGatewayResponse handleRequest(ApiGatewayRequest input, Context context) {
        context.getLogger().log(String.format("received: {}", input));
        Instant instant = new Instant();
        String currentTime = instant.toString();
        String responseBody = String.format("Hello from Java Lambda. Time is: %s", currentTime);

        return new ApiGatewayResponse(200, responseBody);
    }
}
