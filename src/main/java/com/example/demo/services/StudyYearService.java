package com.example.demo.services;

import com.example.demo.models.StudyYear;
import com.example.demo.repos.StudyYearRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyYearService {
    private final StudyYearRepo studyYearRepo;

    public StudyYearService(StudyYearRepo studyYearRepo) {
        this.studyYearRepo = studyYearRepo;
    }

    public List<StudyYear> getAll() {
        return studyYearRepo.findAll();
    }

    public Integer add(StudyYear newYear) {
        studyYearRepo.save(newYear);
        return newYear.getId();
    }

    public Integer findIdYear(Integer year) throws Exception {
        List<StudyYear> years = studyYearRepo.findAll();
        for (StudyYear sy : years) {
            if (sy.getStudyYear().equals(year)) {
                return sy.getId();
            }
        }
        return -1;
    }
    public void delete(Integer id) {
        studyYearRepo.deleteById(id);
    }

    public StudyYear getMaxYear(){
        List<StudyYear> years = getAll();
        StudyYear maxYear = years.get(0);
        for (StudyYear year : years) {
            if (maxYear.getStudyYear() < year.getStudyYear()) {
                maxYear = year;
            }
        }
        return maxYear;
    }
}
