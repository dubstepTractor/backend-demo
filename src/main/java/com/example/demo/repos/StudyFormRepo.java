package com.example.demo.repos;

import com.example.demo.models.StudyForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyFormRepo extends JpaRepository<StudyForm, Integer> {
}
