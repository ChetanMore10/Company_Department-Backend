package com.company.serviceImpl;

import com.company.entity.Department;
import com.company.entity.Employee;
import com.company.repository.DepartmentRepository;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Employee addEmployee(Employee employee) {

        int deptId = employee.getDepartment().getId();

        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        employee.setDepartment(dept);

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));
    }

    @Override
    public String updateEmployee(Employee employee, Integer id) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));

        existing.setFName(employee.getFName());
        existing.setLName(employee.getLName());
        existing.setPosition(employee.getPosition());
        existing.setAddress(employee.getAddress());

        employeeRepository.save(existing);

        return "Employee updated successfully";
    }

    @Override
    public void removeEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));

        employeeRepository.delete(employee);

    }


}