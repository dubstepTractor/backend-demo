package com.example.demo.services;

import com.example.demo.models.StudentsGroup;
import com.example.demo.repos.StudentsGroupRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsGroupService {
    private final StudentsGroupRepo studentsGroupRepo;

    public StudentsGroupService(StudentsGroupRepo studentsGroupRepo) {
        this.studentsGroupRepo = studentsGroupRepo;
    }

    public List<StudentsGroup> getAll() {
        return studentsGroupRepo.findAll();
    }

    public Integer add(StudentsGroup newGroup) {
        studentsGroupRepo.save(newGroup);
        return newGroup.getId();
    }

    public Integer findIdByYearB(Integer year) {
        List<StudentsGroup> groups = getAll();
        for (StudentsGroup group : groups) {
            if (group.getEntryYear().equals(year) && group.getQualification().equals(1)) {
                return group.getId();
            }
        }
        return -1;
    }
    public Integer findIdByYearM(Integer year) {
        List<StudentsGroup> groups = getAll();
        for (StudentsGroup group : groups) {
            if (group.getEntryYear().equals(year) && group.getQualification().equals(3)) {
                return group.getId();
            }
        }
        return -1;
    }
}
