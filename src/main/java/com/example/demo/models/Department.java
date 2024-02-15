package com.example.demo.models;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Entity
@Table(name = "Department")
public class Department {
    @Id
    private Long id;
    private String descr;
    private int codeNumber;

    public void setId(Long id) {
        this.id = id;
    }

    @jakarta.persistence.Id
    public Long getId() {
        return id;
    }
}
