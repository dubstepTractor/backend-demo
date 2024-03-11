package com.example.demo.repos;

import com.example.demo.models.WorkingPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingPositionRepo extends JpaRepository<WorkingPosition, Integer> {
}
