package com.example.demo.controllers;

import com.example.demo.models.Workload;
import com.example.demo.services.WorkloadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class WorkloadController {
    private final WorkloadService workloadService;

    public WorkloadController(WorkloadService workloadService) {
        this.workloadService = workloadService;
    }

    @GetMapping("/workload")
    public ResponseEntity<List<Workload>> getDisciplines() {
        List<Workload> data = workloadService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
