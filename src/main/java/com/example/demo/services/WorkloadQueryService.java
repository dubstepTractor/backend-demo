package com.example.demo.services;

import com.example.demo.models.WorkloadQuery;
import com.example.demo.repos.WorkloadQueryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkloadQueryService {
    private final WorkloadQueryRepo workloadRepo;

    public WorkloadQueryService(WorkloadQueryRepo workloadRepo) {
        this.workloadRepo = workloadRepo;
    }

    public List<WorkloadQuery> getWorkloadByYear(Integer yearValue) {
        return workloadRepo.findWorkloadByYear(yearValue);
    }

    public List<WorkloadQuery> getWorkloadEmployByYear(Integer yearValue, Integer id) {
        return workloadRepo.findWorkloadEmployByYear(yearValue, id);
    }
}
