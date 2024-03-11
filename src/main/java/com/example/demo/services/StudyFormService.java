package com.example.demo.services;

import com.example.demo.models.StudyForm;
import com.example.demo.repos.StudyFormRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyFormService {
    private final StudyFormRepo studyFormRepo;

    public StudyFormService(StudyFormRepo studyFormRepo) {
        this.studyFormRepo = studyFormRepo;
    }

    public List<StudyForm> getAll() {
        return studyFormRepo.findAll();
    }
}
