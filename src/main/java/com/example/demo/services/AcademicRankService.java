package com.example.demo.services;

import com.example.demo.models.AcademicRank;
import com.example.demo.repos.AcademicRankRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicRankService {
    private final AcademicRankRepo academicRankRepo; // Поле для хранения репозитория

    public AcademicRankService(AcademicRankRepo academicRankRepo) {
        this.academicRankRepo = academicRankRepo;
    }

    public List<AcademicRank> getAll() {
        return academicRankRepo.findAll(); // Вызов метода findAll() репозитория
    }
}
