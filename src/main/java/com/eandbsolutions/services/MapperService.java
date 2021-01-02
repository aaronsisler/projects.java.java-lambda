package com.eandbsolutions.services;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.eandbsolutions.models.Employee;

public class MapperService {
    private final DynamoDBMapper ddbMapper =
            new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().build());

    public void saveEmployee(Employee employee) {
        //1. Creating DDBClient
        AmazonDynamoDB ddbClient = AmazonDynamoDBClientBuilder.standard()
//            .withCredentials(new AWSCredentialsProvider(KEY))
//            .withRegion("us-west-2")
                .build();

        // 2. Save the item (assuming userDataItem object is passed)
        ddbMapper.save(employee);
    }
}
