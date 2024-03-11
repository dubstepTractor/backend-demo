package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "department")
public class Department {
    @jakarta.persistence.Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "code_number")
    private Integer codeNumber;

    @Column(name = "descr")
    private String descr;
}
