package com.example.demo.repos;

import com.example.demo.models.Workload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkloadRepo extends JpaRepository<Workload, Integer> {
}
