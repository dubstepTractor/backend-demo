package com.example.demo.controllers;

import com.example.demo.models.StudentsGroup;
import com.example.demo.services.StudentsGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class StudentsGroupController {
    private final StudentsGroupService studentsGroupService;

    public StudentsGroupController(StudentsGroupService studentsGroupService) {
        this.studentsGroupService = studentsGroupService;
    }

    @GetMapping("/students-group")
    public ResponseEntity<List<StudentsGroup>> getDisciplines() {
        List<StudentsGroup> data = studentsGroupService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
