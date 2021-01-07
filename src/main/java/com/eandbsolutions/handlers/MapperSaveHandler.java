package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;
import com.eandbsolutions.models.Employee;
import com.eandbsolutions.services.MapperService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MapperSaveHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    private Logger logger;
    private MapperService mapperService;

    public MapperSaveHandler() {
        logger = LogManager.getLogger(getClass());
        mapperService = new MapperService();
    }

    public ApiGatewayResponse handleRequest(ApiGatewayRequest input, Context context) {
        String responseBody;

        Employee employee = new Employee("4", "Jerry", 89123, true);

        try {
            mapperService.saveEmployee(employee);
            return new ApiGatewayResponse(200, "Worked");
        } catch (Exception e) {
            responseBody = String.format("Error message: %s", e.getMessage());
            return new ApiGatewayResponse(500, responseBody);
        }
    }
}