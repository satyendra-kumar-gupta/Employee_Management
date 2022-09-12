package com.saty.rest_employee_management.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class Employee {
    private int employeeId;
    @Size(min=3, max=10, message = "Please enter valid name range")
    private String name;
    @Email
    private String email;

    public Employee(int employeeId, String name, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
