package com.example.demo.controllers;

import com.example.demo.models.DisciplineParameter;
import com.example.demo.services.DisciplineParameterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class DisciplineParameterController {
    private final DisciplineParameterService disciplineParameterService;

    public DisciplineParameterController(DisciplineParameterService disciplineParameterService) {
        this.disciplineParameterService = disciplineParameterService;
    }

    @GetMapping("/discipline-parameter")
    public ResponseEntity<List<DisciplineParameter>> getDisciplines() {
        List<DisciplineParameter> data = disciplineParameterService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
