package com.company.controller;

import com.company.entity.Employee;
import com.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

        Employee savedEmployee = employeeService.addEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable Integer id){
        employeeService.removeEmployee(id);
    }
}