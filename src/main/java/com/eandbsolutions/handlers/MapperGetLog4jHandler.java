package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;
import com.eandbsolutions.models.Employee;
import com.eandbsolutions.services.MapperService;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Map;

public class MapperGetLog4jHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    private Logger logger;
    private MapperService mapperService;

    public MapperGetLog4jHandler() {
        logger = LogManager.getLogger(getClass());
        mapperService = new MapperService();
    }

    public ApiGatewayResponse handleRequest(ApiGatewayRequest request, Context context) {
        String responseBody;

        Map<String, String> queryParams = request.getQueryStringParameters();
        try {
            String employeeId = queryParams.get("employeeId");
            long startTime = new Date().getTime();
            Employee employee = mapperService.getEmployee(employeeId);
            long totalTime = new Date().getTime() - startTime;
            logger.info("DATABASE_CALL_TIME: " + totalTime);
            responseBody = new Gson().toJson(employee);

            return new ApiGatewayResponse(200, responseBody);
        } catch (Exception e) {
            responseBody = String.format("Error message: %s", e.getMessage());
            return new ApiGatewayResponse(500, responseBody);
        }
    }
}
