package com.example.demo.services;

import com.example.demo.models.DisciplineParameter;
import com.example.demo.repos.DisciplineParameterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineParameterService {
    private final DisciplineParameterRepo disciplineParameterRepo;

    public DisciplineParameterService(DisciplineParameterRepo disciplineParameterRepo) {
        this.disciplineParameterRepo = disciplineParameterRepo;
    }

    public List<DisciplineParameter> getAll() {
        return disciplineParameterRepo.findAll(); // Вызов метода findAll() репозитория
    }
}
