package com.company.service;

import com.company.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department addDepartment(Department department);

    List<Department> getAllDepartment();

    Department getDepartmentById(Integer id);

    String updateDepartment(Department department, Integer id);

    String removeDepartment(Integer id);
}
