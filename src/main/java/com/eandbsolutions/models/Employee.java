package com.eandbsolutions.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.eandbsolutions.utils.CompressedConverter;

import java.nio.ByteBuffer;

public class Employee {

    private String employeeId;
    private String name;
    private int salary;
    private boolean isEmployed;
    private ByteBuffer compressed;

    public Employee() {
    }

    public Employee(String employeeId, String name, int salary, boolean isEmployed) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.isEmployed = isEmployed;
    }

    @DynamoDBAttribute(attributeName = "compressed")
    @DynamoDBTypeConverted(converter = CompressedConverter.class)
    public ByteBuffer getCompressed() {
        return compressed;
    }

    public void setCompressed(ByteBuffer compressed) {
        this.compressed = compressed;
    }

    @DynamoDBHashKey(attributeName = "employeeId")
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.N)
    @DynamoDBAttribute(attributeName = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
    @DynamoDBAttribute(attributeName = "isEmployed")
    public boolean getIsEmployed() {
        return isEmployed;
    }

    public void setIsEmployed(boolean isEmployed) {
        isEmployed = isEmployed;
    }
}
