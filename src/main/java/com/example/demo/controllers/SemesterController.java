package com.example.demo.controllers;

import com.example.demo.models.Semester;
import com.example.demo.services.SemesterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class SemesterController {
    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping("/semester")
    public ResponseEntity<List<Semester>> getDisciplines() {
        List<Semester> data = semesterService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
