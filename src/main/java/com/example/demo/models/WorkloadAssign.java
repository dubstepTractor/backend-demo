package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "workload_assign")
public class WorkloadAssign {
    @jakarta.persistence.Id
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
}
