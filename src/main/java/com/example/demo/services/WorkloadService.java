package com.example.demo.services;

import com.example.demo.models.Workload;
import com.example.demo.repos.WorkloadRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkloadService {
    private final WorkloadRepo workloadRepo;

    public WorkloadService(WorkloadRepo workloadRepo) {
        this.workloadRepo = workloadRepo;
    }

    public List<Workload> getAll() {
        return workloadRepo.findAll();
    }
}
