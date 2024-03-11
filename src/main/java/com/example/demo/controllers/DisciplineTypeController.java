package com.example.demo.controllers;

import com.example.demo.models.DisciplineType;
import com.example.demo.services.DisciplineTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class DisciplineTypeController {
    private final DisciplineTypeService disciplineTypeService;

    public DisciplineTypeController(DisciplineTypeService disciplineTypeService) {
        this.disciplineTypeService = disciplineTypeService;
    }

    @GetMapping("/discipline-type")
    public ResponseEntity<List<DisciplineType>> getDisciplines() {
        List<DisciplineType> data = disciplineTypeService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
