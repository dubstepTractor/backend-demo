package com.example.demo.repos;

import com.example.demo.models.DisciplineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineTypeRepo extends JpaRepository<DisciplineType, Integer> {
}
