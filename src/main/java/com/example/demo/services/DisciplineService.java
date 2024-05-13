package com.example.demo.services;

import com.example.demo.models.Discipline;
import com.example.demo.repos.DisciplineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {
    private final DisciplineRepo disciplineRepo;

    public DisciplineService(DisciplineRepo disciplineRepo) {
        this.disciplineRepo = disciplineRepo;
    }

    public List<Discipline> getAll() {
        return disciplineRepo.findAll(); // Вызов метода findAll() репозитория
    }

    public Integer add(Discipline newDiscipline) {
        disciplineRepo.save(newDiscipline);
       return newDiscipline.getId();
    }
}
