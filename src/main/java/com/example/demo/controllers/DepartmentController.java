package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public ResponseEntity<List<Department>> getDepartments() {
        List<Department> data = departmentService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
