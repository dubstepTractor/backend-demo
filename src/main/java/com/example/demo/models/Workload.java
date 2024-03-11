package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "workload")
public class Workload {
    @jakarta.persistence.Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "discipline")
    private Integer discipline;

    @Column(name = "study_year")
    private Integer studyYear;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "group")
    private Integer group;
}
