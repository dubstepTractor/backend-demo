package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "speciality")
public class Speciality {
    @jakarta.persistence.Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "descr")
    private String descr;

    @Column(name = "faculty")
    private Integer faculty;
}
