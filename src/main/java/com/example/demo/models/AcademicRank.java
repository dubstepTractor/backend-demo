package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Entity(name = "AcademicRank")
@Table(name = "AcademicRank")
public class AcademicRank {
    @JsonProperty(value = "rank_id")
    @Id
    @PrimaryKeyJoinColumn
    @Column(name = "id")
    private int id;
    @Column(name = "descr")
    private String descr;

    public void setId(int id) {
        this.id = id;
    }

    @jakarta.persistence.Id
    public int getId() {
        return id;
    }
}
