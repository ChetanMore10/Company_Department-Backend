package com.company.serviceImpl;

import com.company.entity.Department;
import com.company.repository.DepartmentRepository;
import com.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    // Get All
    @Override
    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found: " + id));
    }

    // Update Data
    @Override
    public String updateDepartment(Department department, Integer id) {
        Department existing = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found: " + id));

        // Update fields
        existing.setName(department.getName());
        existing.setLocation(department.getLocation());

        departmentRepository.save(existing);

        return "Department updated successfully";

    }

    // Delete Recorde
    @Override
    public String removeDepartment(Integer id) {

        Department existing = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found: " + id));

        departmentRepository.delete(existing);

        return "Department deleted successfully";
    }
}