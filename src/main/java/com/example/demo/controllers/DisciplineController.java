package com.example.demo.controllers;

import com.example.demo.models.Discipline;
import com.example.demo.services.DisciplineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class DisciplineController {
    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("/discipline")
    public ResponseEntity<List<Discipline>> getDisciplines() {
        List<Discipline> data = disciplineService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
