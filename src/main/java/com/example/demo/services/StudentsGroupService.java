package com.example.demo.services;

import com.example.demo.models.StudentsGroup;
import com.example.demo.repos.StudentsGroupRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsGroupService {
    private final StudentsGroupRepo studentsGroupRepo;

    public StudentsGroupService(StudentsGroupRepo studentsGroupRepo) {
        this.studentsGroupRepo = studentsGroupRepo;
    }

    public List<StudentsGroup> getAll() {
        return studentsGroupRepo.findAll();
    }
}
