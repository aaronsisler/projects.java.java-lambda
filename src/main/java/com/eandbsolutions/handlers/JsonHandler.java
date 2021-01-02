package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;
import com.eandbsolutions.models.TestJson;
import com.google.gson.Gson;

public class JsonHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    public ApiGatewayResponse handleRequest(ApiGatewayRequest request, Context context) {
        context.getLogger().log(request.getBody());

        try {
            TestJson testJson = new Gson().fromJson(request.getBody(), TestJson.class);

            if (null == testJson.getRequestId()) {
                return new ApiGatewayResponse(400, "Missing request id");
            }

            if (null == testJson.getStuff()) {
                return new ApiGatewayResponse(400, "Missing stuff");
            }

            String responseBody = new Gson().toJson(testJson);

            return new ApiGatewayResponse(200, responseBody);
        } catch (Exception e) {
            return new ApiGatewayResponse(500, String.format("Error message: %s", e.getMessage()));
        }
    }
}
