package com.example.demo.services;

import com.example.demo.models.Semester;
import com.example.demo.repos.SemesterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {
    private final SemesterRepo semesterRepo;

    public SemesterService(SemesterRepo semesterRepo) {
        this.semesterRepo = semesterRepo;
    }

    public List<Semester> getAll() {
        return semesterRepo.findAll();
    }
}
