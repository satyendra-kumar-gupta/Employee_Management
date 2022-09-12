package com.saty.rest_employee_management.controller;

import com.saty.rest_employee_management.exception.EmployeeNotFound;
import com.saty.rest_employee_management.model.Employee;
import com.saty.rest_employee_management.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    @GetMapping("employees/{empId}")
    public EntityModel<Employee> getEmployeeById(@PathVariable int empId) throws EmployeeNotFound {
        Employee employee;
        employee = employeeDao.getEmployeeById(empId);
        if(employee == null)
            throw new EmployeeNotFound("Employee is not available");

        EntityModel<Employee> model = EntityModel.of(employee);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                .getAllEmployees()).withRel("all-employees");
        model.add(link);
        return model;
    }

    @PostMapping("employees/save")
    public ResponseEntity<Object> saveEmployee(@Valid @RequestBody Employee emp){
        Employee newEmployee = employeeDao.saveEmployee(emp);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("employeeId")
                .buildAndExpand(newEmployee.getEmployeeId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("employees/delete/{empId}")
    public void deletedEmployee(@PathVariable int empId){
        Employee employee = employeeDao.deleteEmployee(empId);
        if(employee == null)
            throw new EmployeeNotFound("Employee is not available");
    }
}
