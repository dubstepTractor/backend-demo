package com.example.demo.services;

import com.example.demo.models.Faculty;
import com.example.demo.repos.FacultyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    private final FacultyRepo facultyRepo;

    public FacultyService(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    public List<Faculty> getAll() {
        return facultyRepo.findAll();
    }
}
