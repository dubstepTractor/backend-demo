package com.example.demo.services;

import com.example.demo.models.DisciplineType;
import com.example.demo.repos.DisciplineTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineTypeService {
    private final DisciplineTypeRepo disciplineTypeRepo;

    public DisciplineTypeService(DisciplineTypeRepo disciplineTypeRepo) {
        this.disciplineTypeRepo = disciplineTypeRepo;
    }

    public List<DisciplineType> getAll() {
        return disciplineTypeRepo.findAll();
    }
}
