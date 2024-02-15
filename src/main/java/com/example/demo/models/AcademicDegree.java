package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@Table(name = "academic_degree")
public class AcademicDegree {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "descr")
    private String descr;
}
