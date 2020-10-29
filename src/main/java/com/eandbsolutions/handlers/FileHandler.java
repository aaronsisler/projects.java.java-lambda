package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.FileService;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;

public class FileHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    public ApiGatewayResponse handleRequest(ApiGatewayRequest input, Context context) {
        context.getLogger().log(String.format("received: {}", input));
        String responseBody;

        try {
            FileService fs = new FileService();
            String fileContent = fs.findResourceFile("taco.txt");
            responseBody = String.format("Hello from Java Lambda. File Content: %s", fileContent);
            return new ApiGatewayResponse(200, responseBody);
        } catch (Exception e) {
            responseBody = String.format("Error message: %s", e.getMessage());
            return new ApiGatewayResponse(500, responseBody);
        }
    }
}
