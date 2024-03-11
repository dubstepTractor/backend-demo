package com.example.demo.repos;

import com.example.demo.models.AcademicRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicRankRepo extends JpaRepository<AcademicRank, Integer> {

}

