package com.eandbsolutions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.joda.time.Instant;


public class HelloHandler implements RequestHandler<Object, ApiGatewayProxyResponse> {
    public ApiGatewayProxyResponse handleRequest(Object input, Context context) {
        context.getLogger().log(input.toString());
        Instant instant = new Instant();
        String currentTime = instant.toString();

        return new ApiGatewayProxyResponse(200, null, String.format("Hello World! The time is %s", currentTime));
    }
}
