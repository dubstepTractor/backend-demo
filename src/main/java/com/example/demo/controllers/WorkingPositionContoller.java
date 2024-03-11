package com.example.demo.controllers;

import com.example.demo.models.WorkingPosition;
import com.example.demo.services.WorkingPositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class WorkingPositionContoller {
    private final WorkingPositionService workingPositionService;

    public WorkingPositionContoller(WorkingPositionService workingPositionService) {
        this.workingPositionService = workingPositionService;
    }

    @GetMapping("/working_position")
    public ResponseEntity<List<WorkingPosition>> getDisciplines() {
        List<WorkingPosition> data = workingPositionService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
