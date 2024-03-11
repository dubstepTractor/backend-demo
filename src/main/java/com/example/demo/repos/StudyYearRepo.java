package com.example.demo.repos;

import com.example.demo.models.StudyYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyYearRepo extends JpaRepository<StudyYear, Integer> {
}
