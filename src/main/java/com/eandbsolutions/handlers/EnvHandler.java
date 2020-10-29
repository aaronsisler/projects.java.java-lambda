package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;

public class EnvHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    public ApiGatewayResponse handleRequest(ApiGatewayRequest input, Context context) {
        context.getLogger().log(String.format("received: {}", input));
        String responseBody;

        try {
            String envVariable = System.getenv("LOGICAL_ENV").trim().toUpperCase();
            responseBody = String.format("LOGICAL_ENV: %s", envVariable);
            return new ApiGatewayResponse(200, responseBody);
        } catch (Exception e) {
            responseBody = String.format("Error message: %s", e.getMessage());
            return new ApiGatewayResponse(500, responseBody);
        }
    }
}
