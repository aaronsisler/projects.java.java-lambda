package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;

public class JsonHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    public ApiGatewayResponse handleRequest(ApiGatewayRequest input, Context context) {
        context.getLogger().log(String.format("received: {}", input));

        try {
            return new ApiGatewayResponse(200, "Hello there!");
        } catch (Exception e) {
            return new ApiGatewayResponse(500, String.format("Error message: %s", e.getMessage()));
        }
    }
}
