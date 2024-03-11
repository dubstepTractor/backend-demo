package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "study_year")
public class StudyYear {
    @jakarta.persistence.Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "study_year")
    private Integer studyYear;

}
