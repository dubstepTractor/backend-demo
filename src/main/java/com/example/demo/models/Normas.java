package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "normas")
public class Normas {
    @jakarta.persistence.Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "parameter_name")
    private String parameterName;

    @Column(name = "value")
    private Double value;

    @Column(name = "comment")
    private String comment;
}
