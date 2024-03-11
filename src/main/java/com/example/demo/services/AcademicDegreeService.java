package com.example.demo.services;

import com.example.demo.models.AcademicDegree;
import com.example.demo.repos.AcademicDegreeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicDegreeService {

    private final AcademicDegreeRepo academicDegreeRepo; // Поле для хранения репозитория

    @Autowired // Внедрение зависимости
    public AcademicDegreeService(AcademicDegreeRepo academicDegreeRepo) {
        this.academicDegreeRepo = academicDegreeRepo;
    }

    public List<AcademicDegree> getAll() {
        return academicDegreeRepo.findAll(); // Вызов метода findAll() репозитория
    }

    public List<AcademicDegree> getByIdMore3() {
        return academicDegreeRepo.findAllIdMore3();
    }
}
