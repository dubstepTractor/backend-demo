package com.example.demo.controllers;

import com.example.demo.models.StudyYear;
import com.example.demo.services.StudyYearService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class StudyYearController {
    private final StudyYearService studyYearService;

    public StudyYearController(StudyYearService studyYearService) {
        this.studyYearService = studyYearService;
    }

    @GetMapping("/study-year")
    public ResponseEntity<List<StudyYear>> getDisciplines() {
        List<StudyYear> data = studyYearService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
