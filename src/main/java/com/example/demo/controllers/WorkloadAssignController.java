package com.example.demo.controllers;

import com.example.demo.models.WorkloadAssign;
import com.example.demo.services.WorkloadAssignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class WorkloadAssignController {
    private final WorkloadAssignService workloadAssignService;

    public WorkloadAssignController(WorkloadAssignService workloadAssignService) {
        this.workloadAssignService = workloadAssignService;
    }

    @GetMapping("/workload-assign")
    public ResponseEntity<List<WorkloadAssign>> getDisciplines() {
        List<WorkloadAssign> data = workloadAssignService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
