package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "employee")
public class Employee {
    @jakarta.persistence.Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "contract_number")
    private Integer contractNumber;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "working_position")
    private Integer workingPosition;

    @Column(name = "academic_rank")
    private Integer academicRank;

    @Column(name = "academic_degree")
    private Integer academicDegree;
}
