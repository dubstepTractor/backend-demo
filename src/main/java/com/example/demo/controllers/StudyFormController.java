package com.example.demo.controllers;

import com.example.demo.models.StudyForm;
import com.example.demo.services.StudyFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class StudyFormController {
    private final StudyFormService studyFormService;

    public StudyFormController(StudyFormService studyFormService) {
        this.studyFormService = studyFormService;
    }

    @GetMapping("/study-form")
    public ResponseEntity<List<StudyForm>> getDisciplines() {
        List<StudyForm> data = studyFormService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
