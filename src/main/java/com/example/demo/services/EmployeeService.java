package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repos.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Employee getById(Integer id) {
        return employeeRepo.findEmployeeById(id);
    }
}
