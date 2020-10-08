package com.eandbsolutions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class HelloHandler implements RequestHandler<Object, ApiGatewayProxyResponse> {
    public ApiGatewayProxyResponse handleRequest(Object input, Context context) {
        ApiGatewayProxyResponse apiGatewayProxyResponse = new ApiGatewayProxyResponse(200, null, "Hello World!");

        return apiGatewayProxyResponse;
    }

}
