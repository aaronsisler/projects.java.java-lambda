package com.eandbsolutions.models;

public class EmployeeDto {

    private String employeeId;
    private String name;
    private String salary;
    private String isEmployed;
    private String compressed;

    public EmployeeDto(Employee employee) {
        employeeId = employee.getEmployeeId();
        name = employee.getName();
        salary = Integer.toString(employee.getSalary());
        isEmployed = Boolean.toString(employee.getIsEmployed());
    }

    public String getCompressed() {
        return compressed;
    }

    public void setCompressed(String compressed) {
        this.compressed = compressed;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getIsEmployed() {
        return isEmployed;
    }

    public void setIsEmployed(String isEmployed) {
        isEmployed = isEmployed;
    }
}
