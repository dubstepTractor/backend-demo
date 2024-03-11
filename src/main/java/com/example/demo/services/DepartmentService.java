package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.repos.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<Department> getAll() {
        return departmentRepo.findAll(); // Вызов метода findAll() репозитория
    }
}
