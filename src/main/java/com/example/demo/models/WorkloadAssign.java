package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "workload_assign")
public class WorkloadAssign {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "teacher")
    private Integer teacher;

    @Column(name = "workload")
    private Integer workload;

    @Column(name = "student_count")
    private String studentCount;

    @Column(name = "weeks")
    private String weeks;

    @Column(name = "is_contract")
    private Boolean isContract;

    public WorkloadAssign(Integer id, Integer teacher, Integer workload, String studentCount, String weeks, Boolean isContract) {
        this.id = id;
        this.teacher = teacher;
        this.workload = workload;
        this.studentCount = studentCount;
        this.weeks = weeks;
        this.isContract = isContract;
    }

    public WorkloadAssign(Integer teacher, Integer workload, String studentCount, String weeks, Boolean isContract) {
        this.teacher = teacher;
        this.workload = workload;
        this.studentCount = studentCount;
        this.weeks = weeks;
        this.isContract = isContract;
    }
    public WorkloadAssign() {
        this.teacher = -1;
        this.workload = -1;
        this.studentCount = " ";
        this.weeks = "";
        this.isContract = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public String getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(String studentCount) {
        this.studentCount = studentCount;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public Boolean getContract() {
        return isContract;
    }

    public void setContract(Boolean contract) {
        isContract = contract;
    }
}
