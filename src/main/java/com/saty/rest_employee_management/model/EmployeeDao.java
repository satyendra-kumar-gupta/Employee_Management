package com.saty.rest_employee_management.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeDao {

    static List<Employee> list = new ArrayList<>();
    static {
        list.add(new Employee(1,"saty","saty@gamil.com"));
        list.add(new Employee(2,"kumar","kumar@gamil.com"));
        list.add(new Employee(3,"gupta","gupta@gamil.com"));
    }

    public List<Employee> getAllEmployees(){
        return list;
    }

    public Employee getEmployeeById(int empId) {
        return list.stream().filter(emp -> emp.getEmployeeId()==empId).findAny().orElse(null);
    }

    public Employee saveEmployee(Employee emp) {
        emp.setEmployeeId(list.size()+1);
        list.add(emp);
        return emp;
    }

    public Employee deleteEmployee(int empId) {
        Iterator<Employee> iterator = list.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(empId == employee.getEmployeeId()){
                iterator.remove();
                return employee;
            }
        }
        return null;
    }
}
