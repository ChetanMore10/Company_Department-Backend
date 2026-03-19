package com.company.controller;

import com.company.entity.Department;
import com.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "http://localhost:5173")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department department1 = departmentService.addDepartment(department);
        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@RequestBody Department department, @PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.updateDepartment(department, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.removeDepartment(id));
    }
}