package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.models.AcademicDegree;

import java.util.List;

@Repository
public interface AcademicDegreeRepo extends JpaRepository<AcademicDegree, Integer> {
    @Query(value = "SELECT * from academic_degree where id > 3", nativeQuery = true)
    public List<AcademicDegree> findAllIdMore3();
}
