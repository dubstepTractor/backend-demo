package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.AcademicDegree;

@Repository
public interface AcademicDegreeRepo extends JpaRepository<AcademicDegree, Integer> {
}
