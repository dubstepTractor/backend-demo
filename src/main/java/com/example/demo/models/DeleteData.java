package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DeleteData {
    public Integer studyYear;
    public Integer idYear;
    @Id
    public Integer idWorkload;
    public Integer idWorkloadAssign;
    public Integer idDiscipline;

    public DeleteData(Integer studyYear, Integer idYear, Integer idWorkload, Integer idWorkloadAssign, Integer idDiscipline) {
        this.studyYear = studyYear;
        this.idYear = idYear;
        this.idWorkload = idWorkload;
        this.idWorkloadAssign = idWorkloadAssign;
        this.idDiscipline = idDiscipline;
    }

    public DeleteData() {

    }

    public Integer getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }

    public Integer getIdYear() {
        return idYear;
    }

    public void setIdYear(Integer idYear) {
        this.idYear = idYear;
    }

    public Integer getIdWorkload() {
        return idWorkload;
    }

    public void setIdWorkload(Integer idWorkload) {
        this.idWorkload = idWorkload;
    }

    public Integer getIdWorkloadAssign() {
        return idWorkloadAssign;
    }

    public void setIdWorkloadAssign(Integer idWorkloadAssign) {
        this.idWorkloadAssign = idWorkloadAssign;
    }

    public Integer getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(Integer idDiscipline) {
        this.idDiscipline = idDiscipline;
    }
}
