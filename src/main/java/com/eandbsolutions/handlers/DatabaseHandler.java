package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;
import com.eandbsolutions.models.User;
import com.eandbsolutions.services.DatabaseService;
import com.eandbsolutions.services.SwissArmyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    private Logger logger;
    private SwissArmyService swissArmyService;
    private DatabaseService databaseService;

    public DatabaseHandler() {
        logger = LoggerFactory.getLogger(getClass());
        swissArmyService = new SwissArmyService();
        databaseService = new DatabaseService();
    }

    public ApiGatewayResponse handleRequest(ApiGatewayRequest input, Context context) {
        String responseBody;

        try {
            responseBody = "Hello from DatabaseHandler!";
            User user = databaseService.getItem();
            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(user);
            System.out.println(jsonString);
            return new ApiGatewayResponse(200, jsonString);
        } catch (Exception e) {
            responseBody = String.format("Error message: %s", e.getMessage());
            return new ApiGatewayResponse(500, responseBody);
        }
    }
}
