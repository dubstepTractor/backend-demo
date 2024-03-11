package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "discipline")
public class Discipline {
    @jakarta.persistence.Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "descr")
    private String descr;

    @Column(name = "department")
    private Integer department;

    @Column(name = "discipline_type")
    private Integer disciplineType;

    @Column(name = "lecture_count")
    private Integer lectureCount;

    @Column(name = "practice_count")
    private Integer practiceCount;

    @Column(name = "lab_count")
    private Integer labCount;

    @Column(name = "kr")
    private Boolean kr;

    @Column(name = "kp")
    private Boolean kp;

    @Column(name = "rgr")
    private Boolean rgr;

    @Column(name = "zach")
    private Boolean zach;

    @Column(name = "ekz")
    private Boolean ekz;

    @Column(name = "kons")
    private Boolean kons;

    @Column(name = "uch_pr")
    private Integer uchPr;

    @Column(name = "pr_pr")
    private Integer prPr;

    @Column(name = "pred_dip_pr")
    private Integer predDipPr;

    @Column(name = "niir")
    private Integer niir;

    @Column(name = "kons_zaoch")
    private Boolean konsZaoch;

    @Column(name = "gek")
    private Boolean gek;

    @Column(name = "gak")
    private Boolean gak;

    @Column(name = "gos_ekz")
    private Boolean gosEkz;

    @Column(name = "gak_pred")
    private Boolean gakPred;

    @Column(name = "dp_ruk")
    private Boolean dpRuk;

    @Column(name = "dopusk_vkr")
    private Boolean dopuskVkr;

    @Column(name = "retz_vkr")
    private Boolean retzVkr;

    @Column(name = "dp_retz")
    private Boolean dpRetz;

    @Column(name = "asp_ruk")
    private Boolean aspRuk;

    @Column(name = "mag_ruk")
    private Boolean magRuk;

    @Column(name = "mag_retz")
    private Boolean magRetz;

    @Column(name = "ruk_kaf")
    private Boolean rukKaf;

    @Column(name = "is_special")
    private Boolean isSpecial;

    @Column(name = "contr")
    private Boolean contr;
}
