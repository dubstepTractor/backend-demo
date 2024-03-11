package com.example.demo.controllers;

import com.example.demo.models.Faculty;
import com.example.demo.services.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/faculty")
    public ResponseEntity<List<Faculty>> getDisciplines() {
        List<Faculty> data = facultyService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
