package com.example.demo.services;

import com.example.demo.models.PlanQuery;
import com.example.demo.repos.PlanQueryRepo;
import org.springframework.stereotype.Service;

@Service
public class PlanQueryService {
    private final PlanQueryRepo planQueryRepo;

    public PlanQueryService(PlanQueryRepo planQueryRepo) {
        this.planQueryRepo = planQueryRepo;
    }

    public PlanQuery getEmployee(Integer id) {
        return planQueryRepo.findTeacherById(id);
    }
}
