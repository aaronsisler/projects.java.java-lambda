package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    private Logger logger;

    public LogHandler() {
        logger = LoggerFactory.getLogger(getClass());
    }

    public ApiGatewayResponse handleRequest(ApiGatewayRequest input, Context context) {
        context.getLogger().log("Logging from Context logger");

        logger.info("Logging from Apache logger: Info");
        logger.warn("Logging from Apache logger: Warn");
        logger.error("Logging from Apache logger: Error");

        String responseBody;
        String classpath = System.getProperty("java.class.path");
        logger.info(classpath);

        try {
            responseBody = "Hello from LogHandler!";
            return new ApiGatewayResponse(200, responseBody);
        } catch (Exception e) {
            responseBody = String.format("Error message: %s", e.getMessage());
            return new ApiGatewayResponse(500, responseBody);
        }
    }
}
