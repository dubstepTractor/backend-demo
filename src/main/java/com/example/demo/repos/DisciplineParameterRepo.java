package com.example.demo.repos;

import com.example.demo.models.DisciplineParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineParameterRepo extends JpaRepository<DisciplineParameter, Integer> {
}
