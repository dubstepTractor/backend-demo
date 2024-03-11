package com.example.demo.services;

import com.example.demo.models.Qualification;
import com.example.demo.repos.QualificationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationService {
    private final QualificationRepo qualificationRepo;

    public QualificationService(QualificationRepo qualificationRepo) {
        this.qualificationRepo = qualificationRepo;
    }

    public List<Qualification> getAll() {
        return qualificationRepo.findAll();
    }
}
