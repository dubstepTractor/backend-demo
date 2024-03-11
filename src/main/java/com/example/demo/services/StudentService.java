package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repos.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAll() {
        return studentRepo.findAll();
    }
}
