package com.example.demo.controllers;

import com.example.demo.models.Qualification;
import com.example.demo.services.QualificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class QualificationController {
    private final QualificationService qualificationService;

    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @GetMapping("/qualification")
    public ResponseEntity<List<Qualification>> getDisciplines() {
        List<Qualification> data = qualificationService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
