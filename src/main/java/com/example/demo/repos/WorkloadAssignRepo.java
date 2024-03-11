package com.example.demo.repos;

import com.example.demo.models.WorkloadAssign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkloadAssignRepo extends JpaRepository<WorkloadAssign, Integer> {
}
