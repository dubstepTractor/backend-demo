package com.example.demo.services;

import com.example.demo.models.WorkloadAssign;
import com.example.demo.repos.WorkloadAssignRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkloadAssignService {
    private final WorkloadAssignRepo workloadAssignRepo;

    public WorkloadAssignService(WorkloadAssignRepo workloadAssignRepo) {
        this.workloadAssignRepo = workloadAssignRepo;
    }

    public List<WorkloadAssign> getAll() {
        return workloadAssignRepo.findAll();
    }

    public Integer add(WorkloadAssign newWorkloadAssign) {
        workloadAssignRepo.save(newWorkloadAssign);
        return newWorkloadAssign.getId();
    }
}
