package com.eandbsolutions.services;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.eandbsolutions.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.List;

public class DatabaseService {
    private final Logger logger;

    public DatabaseService() {
        logger = LogManager.getLogger(getClass());
    }

    public DatabaseService(Logger logger) {
        this.logger = logger;
    }

    public User getItem() {
        try {
            Region region = Region.US_EAST_1;
            System.setProperty("aws.accessKeyId", "AKIAZQ7BPRUIDC4FVX6V");
            System.setProperty("aws.secretAccessKey", "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");
            DynamoDbClient ddb = DynamoDbClient.builder()
                    .region(region)
                    .build();

            DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                    .dynamoDbClient(ddb)
                    .build();
            String tableName = "PAPER_TRAIL_SERVICE_BETA_USERS";
            DynamoDbTable<User> userTable = enhancedClient.table(tableName, TableSchema.fromBean(User.class));
            String userId = "101389202411803829037";
            Key userIdKey = Key.builder().partitionValue(userId).build();
            return userTable.getItem(userIdKey);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw e;
        }
    }

    public void getTables() {
        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();

        ListTablesRequest request;

        boolean more_tables = true;
        String last_name = null;

        while (more_tables) {
            try {
                if (last_name == null) {
                    request = new ListTablesRequest().withLimit(10);
                } else {
                    request = new ListTablesRequest()
                            .withLimit(10)
                            .withExclusiveStartTableName(last_name);
                }

                ListTablesResult table_list = ddb.listTables(request);
                List<String> table_names = table_list.getTableNames();

                if (table_names.size() > 0) {
                    for (String cur_name : table_names) {
                        System.out.format("* %s\n", cur_name);
                    }
                } else {
                    System.out.println("No tables found!");
                    System.exit(0);
                }

                last_name = table_list.getLastEvaluatedTableName();
                if (last_name == null) {
                    more_tables = false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
