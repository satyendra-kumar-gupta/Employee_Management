package com.saty.rest_employee_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED)
public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String employee_is_not_available) {
        super(employee_is_not_available);
    }
}
