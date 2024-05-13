package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "students_group")
public class StudentsGroup {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "descr")
    private String descr;

    @Column(name = "speciality")
    private Integer speciality;

    @Column(name = "qualification")
    private Integer qualification;

    @Column(name = "study_form")
    private Integer studyForm;

    @Column(name = "student_count")
    private Integer studentCount;

    @Column(name = "entry_year")
    private Integer entryYear;

    @Column(name = "subgroup_count")
    private Integer subgroupCount;

    public StudentsGroup(String descr, Integer speciality, Integer qualification, Integer studyForm, Integer studentCount, Integer entryYear, Integer subgroupCount) {
        this.descr = descr;
        this.speciality = speciality;
        this.qualification = qualification;
        this.studyForm = studyForm;
        this.studentCount = studentCount;
        this.entryYear = entryYear;
        this.subgroupCount = subgroupCount;
    }

    public StudentsGroup() {
        this.descr = "";
        this.speciality = -1;
        this.qualification = -1;
        this.studyForm = -1;
        this.studentCount = -1;
        this.entryYear = -1;
        this.subgroupCount = -1;
    }
}
