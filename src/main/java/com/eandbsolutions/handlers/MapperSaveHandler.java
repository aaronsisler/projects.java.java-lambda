package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;
import com.eandbsolutions.models.Employee;
import com.eandbsolutions.services.MapperService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class MapperSaveHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    private Logger logger;
    private MapperService mapperService;

    public MapperSaveHandler() {
        logger = LoggerFactory.getLogger(getClass());
        mapperService = new MapperService();
    }

    public ApiGatewayResponse handleRequest(ApiGatewayRequest request, Context context) {
        String responseBody;

        Employee employee = new Gson().fromJson(request.getBody(), Employee.class);

        try {
            long startTime = new Date().getTime();
            mapperService.saveEmployee(employee);
            long totalTime = new Date().getTime() - startTime;
            logger.info("DATABASE_CALL_TIME: " + totalTime);
            return new ApiGatewayResponse(200, "Worked");
        } catch (Exception e) {
            responseBody = String.format("Error message: %s", e.getMessage());
            return new ApiGatewayResponse(500, responseBody);
        }
    }
}
