package com.example.demo.services;

import com.example.demo.models.WorkingPosition;
import com.example.demo.repos.WorkingPositionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingPositionService {
    private final WorkingPositionRepo workingPositionRepo;

    public WorkingPositionService(WorkingPositionRepo workingPositionRepo) {
        this.workingPositionRepo = workingPositionRepo;
    }

    public List<WorkingPosition> getAll() {
        return workingPositionRepo.findAll();
    }
}
