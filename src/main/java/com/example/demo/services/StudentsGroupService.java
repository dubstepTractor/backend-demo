package com.example.demo.services;

import com.example.demo.models.StudentsGroup;
import com.example.demo.repos.StudentsGroupRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Integer findIdByYear(Integer year, Integer idSpeciality) {
        List<StudentsGroup> groups = getAll();
        for (StudentsGroup group : groups) {
            if (group.getEntryYear().equals(year) && group.getSpeciality().equals(idSpeciality)) {
                return group.getId();
            }
        }
        return -1;
    }

    public void delete(Integer id) {
        studentsGroupRepo.deleteById(id);
    }

    public void updateField(Integer studentsCount, Integer countSubGroup, Integer year, Integer idSpeciality) {
        Integer id = findIdByYear(year, idSpeciality);
        Optional<StudentsGroup> optionalEntity = studentsGroupRepo.findById(id);
        if (optionalEntity.isPresent()) {
            StudentsGroup group = optionalEntity.get();
            Boolean flag = false;
            if (!group.getStudentCount().equals(studentsCount)) {
                group.setStudentCount(studentsCount);
                flag = true;
            }
            if (!group.getSubgroupCount().equals(countSubGroup)) {
                group.setSubgroupCount(countSubGroup);
                flag = true;
            }
            if (flag) {
                studentsGroupRepo.save(group);
            }
        }
    }
}
