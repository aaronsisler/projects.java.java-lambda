package com.eandbsolutions.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "JAVA_MAPPER_TEST")
public class Employee {
    @DynamoDBHashKey(attributeName = "employeeId")
    private String employeeId;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "salary")
    private int salary;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
    @DynamoDBAttribute(attributeName = "isEmployed")
    private boolean isEmployed;

    public Employee(String employeeId, String name, int salary, boolean isEmployed) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.isEmployed = isEmployed;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean getIsEmployed() {
        return isEmployed;
    }

    public void setIsEmployed(boolean isEmployed) {
        isEmployed = isEmployed;
    }
}
