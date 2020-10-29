package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    public ApiGatewayResponse handleRequest(ApiGatewayRequest request, Context context) {
        context.getLogger().log(request.getBody());

        try {
            JsonObject convertedObject = new Gson().fromJson(request.getBody(), JsonObject.class);
            JsonElement bodyMain = convertedObject.get("main");
            context.getLogger().log(bodyMain.toString());

            String responseBody = bodyMain.toString();

            return new ApiGatewayResponse(200, responseBody);
        } catch (Exception e) {
            return new ApiGatewayResponse(500, String.format("Error message: %s", e.getMessage()));
        }
    }
}
