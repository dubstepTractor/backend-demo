package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "workload")
public class Workload {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "discipline")
    private Integer discipline;

    @Column(name = "study_year")
    private Integer studyYear;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "id_group")
    private Integer idGroup;

    public Workload(Integer id, Integer discipline, Integer studyYear, Integer semester, Integer group) {
        this.id = id;
        this.discipline = discipline;
        this.studyYear = studyYear;
        this.semester = semester;
        this.idGroup = group;
    }
    public Workload() {
        this.discipline = -1;
        this.studyYear = -1;
        this.semester = -1;
        this.idGroup = -1;
    }
    public Workload( Integer discipline, Integer studyYear, Integer semester, Integer group) {
        this.discipline = discipline;
        this.studyYear = studyYear;
        this.semester = semester;
        this.idGroup = group;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Integer discipline) {
        this.discipline = discipline;
    }

    public Integer getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }
}
