package com.eandbsolutions.services;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.eandbsolutions.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapperService {
    private final Logger logger;
    private final DynamoDBMapper ddbMapper;

    public MapperService() {
        logger = LoggerFactory.getLogger(getClass());
        String tableName = "JAVA_MAPPER_TEST";
        DynamoDBMapperConfig mapperConfig = new DynamoDBMapperConfig.Builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(tableName))
                .build();
        ddbMapper = new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().build(), mapperConfig);
    }

    public void saveEmployee(Employee employee) {
        ddbMapper.save(employee);
    }

    public Employee getEmployee(String employeeId) {
        logger.info("Getting employee:" + employeeId);
        return ddbMapper.load(Employee.class, employeeId);
    }
}
