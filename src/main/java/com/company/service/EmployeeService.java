package com.company.service;

import com.company.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Integer id);

    String updateEmployee(Employee employee, Integer id);

    void removeEmployee(Integer id);
}
