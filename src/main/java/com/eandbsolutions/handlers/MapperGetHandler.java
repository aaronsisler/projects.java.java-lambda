package com.eandbsolutions.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eandbsolutions.models.ApiGatewayRequest;
import com.eandbsolutions.models.ApiGatewayResponse;
import com.eandbsolutions.models.Employee;
import com.eandbsolutions.models.EmployeeDto;
import com.eandbsolutions.services.MapperService;
import com.eandbsolutions.utils.StringCompressionUtil;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

public class MapperGetHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {
    private Logger logger;
    private MapperService mapperService;

    public MapperGetHandler() {
        logger = LoggerFactory.getLogger(getClass());
        mapperService = new MapperService();
    }

    public ApiGatewayResponse handleRequest(ApiGatewayRequest request, Context context) {
        String responseBody;

        Map<String, String> queryParams = request.getQueryStringParameters();
        try {
            String employeeId = queryParams.get("employeeId");
            long startTime = new Date().getTime();
            Employee employee = mapperService.getEmployee(employeeId);
            System.out.println("After mapper service");
            EmployeeDto employeeDto = new EmployeeDto(employee);
            System.out.println("After EmployeeDto construction");
            String compressed = StringCompressionUtil.uncompressString(employee.getCompressed());
            employeeDto.setCompressed(compressed);
            long totalTime = new Date().getTime() - startTime;
            logger.info("DATABASE_CALL_TIME: " + totalTime);
            responseBody = new Gson().toJson(employeeDto);

            return new ApiGatewayResponse(200, responseBody);
        } catch (Exception e) {
            responseBody = String.format("Error message: %s", e.getMessage());
            return new ApiGatewayResponse(500, responseBody);
        }
    }
}
