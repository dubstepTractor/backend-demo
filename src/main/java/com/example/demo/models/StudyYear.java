package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "study_year")
public class StudyYear {
    @jakarta.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Integer id;
    private Integer studyYear;

    public StudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }

    public StudyYear(Integer id, Integer studyYear) {
        this.id = id;
        this.studyYear = studyYear;
    }

    public StudyYear() {
        studyYear = 0;
    }
}
