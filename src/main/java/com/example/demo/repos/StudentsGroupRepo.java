package com.example.demo.repos;

import com.example.demo.models.StudentsGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsGroupRepo extends JpaRepository<StudentsGroup, Integer> {
}
