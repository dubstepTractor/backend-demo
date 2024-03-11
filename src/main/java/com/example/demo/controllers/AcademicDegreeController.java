package com.example.demo.controllers;

import com.example.demo.models.AcademicDegree;
import com.example.demo.services.AcademicDegreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class AcademicDegreeController {
    private final AcademicDegreeService academicDegreeService;

    public AcademicDegreeController(AcademicDegreeService academicDegreeService) {
        this.academicDegreeService = academicDegreeService;
    }

    @GetMapping("/academic-degree")
    public ResponseEntity<List<AcademicDegree>> getAcademicDegrees() {
        List<AcademicDegree> academicDegrees = academicDegreeService.getAll();
        return new ResponseEntity<>(academicDegrees, HttpStatus.OK);
    }

    @GetMapping("/academic-degree-by-id")
    public ResponseEntity<List<AcademicDegree>> getAcademicDegreesById() {
        List<AcademicDegree> academicDegrees = academicDegreeService.getByIdMore3();
        return new ResponseEntity<>(academicDegrees, HttpStatus.OK);
    }
}
