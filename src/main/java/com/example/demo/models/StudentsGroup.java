package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "students_group")
public class StudentsGroup {
    @jakarta.persistence.Id
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

}
