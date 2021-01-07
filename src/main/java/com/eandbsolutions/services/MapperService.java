package com.eandbsolutions.services;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.eandbsolutions.models.Employee;

public class MapperService {
    private final DynamoDBMapper ddbMapper;

    public MapperService() {
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
        return ddbMapper.load(Employee.class, employeeId);
    }
}
