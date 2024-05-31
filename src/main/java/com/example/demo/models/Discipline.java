package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Data
@jakarta.persistence.Table(name = "discipline")
public class Discipline {
    @jakarta.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
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
    public Discipline(Integer id, String descr, Integer department, Integer disciplineType, Integer lectureCount, Integer practiceCount, Integer labCount, Boolean kr, Boolean kp, Boolean rgr, Boolean zach, Boolean ekz, Boolean kons, Integer uchPr, Integer prPr, Integer predDipPr, Integer niir, Boolean konsZaoch, Boolean gek, Boolean gak, Boolean gosEkz, Boolean gakPred, Boolean dpRuk, Boolean dopuskVkr, Boolean retzVkr, Boolean dpRetz, Boolean aspRuk, Boolean magRuk, Boolean magRetz, Boolean rukKaf, Boolean isSpecial, Boolean contr) {
        this.id = id;
        this.descr = descr;
        this.department = department;
        this.disciplineType = disciplineType;
        this.lectureCount = lectureCount;
        this.practiceCount = practiceCount;
        this.labCount = labCount;
        this.kr = kr;
        this.kp = kp;
        this.rgr = rgr;
        this.zach = zach;
        this.ekz = ekz;
        this.kons = kons;
        this.uchPr = uchPr;
        this.prPr = prPr;
        this.predDipPr = predDipPr;
        this.niir = niir;
        this.konsZaoch = konsZaoch;
        this.gek = gek;
        this.gak = gak;
        this.gosEkz = gosEkz;
        this.gakPred = gakPred;
        this.dpRuk = dpRuk;
        this.dopuskVkr = dopuskVkr;
        this.retzVkr = retzVkr;
        this.dpRetz = dpRetz;
        this.aspRuk = aspRuk;
        this.magRuk = magRuk;
        this.magRetz = magRetz;
        this.rukKaf = rukKaf;
        this.isSpecial = isSpecial;
        this.contr = contr;
    }

    public Discipline(String descr, Integer lectureCount, Integer practiceCount, Integer labCount, Boolean kr, Boolean kp, Boolean zach, Boolean ekz, Boolean kons, Boolean contr, Integer uchPr, Integer prPr, Integer predDipPr) {
        this.descr = descr;
        department = 1;
        disciplineType = 1;
        this.lectureCount = lectureCount;
        this.practiceCount = practiceCount;
        this.labCount = labCount;
        this.kr = kr;
        this.kp = kp;
        this.zach = zach;
        this.ekz = ekz;
        this.kons = kons;
        this.contr = contr;
        this.rgr = false;
        this.uchPr = uchPr;
        this.prPr = prPr;
        this.predDipPr = predDipPr;
        this.niir = 0;
        this.konsZaoch = false;
        this.gek = false;
        this.gak = false;
        this.gosEkz = false;
        this.gakPred = false;
        this.dpRuk = false;
        this.dopuskVkr = false;
        this.retzVkr = false;
        this.dpRetz = false;
        this.aspRuk = false;
        this.magRuk = false;
        this.magRetz = false;
        this.rukKaf = false;
        this.isSpecial = false;
    }

    public Discipline() {
        descr = "";
        department = 1;
        disciplineType = 1;
        lectureCount = 0;
        practiceCount = 0;
        labCount = 0;
        this.kr = false;
        this.kp = false;
        this.rgr = false;
        this.zach = false;
        this.ekz = false;
        this.kons = false;
        this.uchPr = 0;
        this.prPr = 0;
        this.predDipPr = 0;
        this.niir = 0;
        this.konsZaoch = false;
        this.gek = false;
        this.gak = false;
        this.gosEkz = false;
        this.gakPred = false;
        this.dpRuk = false;
        this.dopuskVkr = false;
        this.retzVkr = false;
        this.dpRetz = false;
        this.aspRuk = false;
        this.magRuk = false;
        this.magRetz = false;
        this.rukKaf = false;
        this.isSpecial = false;
        this.contr = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getDisciplineType() {
        return disciplineType;
    }

    public void setDisciplineType(Integer disciplineType) {
        this.disciplineType = disciplineType;
    }

    public Integer getLectureCount() {
        return lectureCount;
    }

    public void setLectureCount(Integer lectureCount) {
        this.lectureCount = lectureCount;
    }

    public Integer getPracticeCount() {
        return practiceCount;
    }

    public void setPracticeCount(Integer practiceCount) {
        this.practiceCount = practiceCount;
    }

    public Integer getLabCount() {
        return labCount;
    }

    public void setLabCount(Integer labCount) {
        this.labCount = labCount;
    }

    public Boolean getKr() {
        return kr;
    }

    public void setKr(Boolean kr) {
        this.kr = kr;
    }

    public Boolean getKp() {
        return kp;
    }

    public void setKp(Boolean kp) {
        this.kp = kp;
    }

    public Boolean getRgr() {
        return rgr;
    }

    public void setRgr(Boolean rgr) {
        this.rgr = rgr;
    }

    public Boolean getZach() {
        return zach;
    }

    public void setZach(Boolean zach) {
        this.zach = zach;
    }

    public Boolean getEkz() {
        return ekz;
    }

    public void setEkz(Boolean ekz) {
        this.ekz = ekz;
    }

    public Boolean getKons() {
        return kons;
    }

    public void setKons(Boolean kons) {
        this.kons = kons;
    }

    public Integer getUchPr() {
        return uchPr;
    }

    public void setUchPr(Integer uchPr) {
        this.uchPr = uchPr;
    }

    public Integer getPrPr() {
        return prPr;
    }

    public void setPrPr(Integer prPr) {
        this.prPr = prPr;
    }

    public Integer getPredDipPr() {
        return predDipPr;
    }

    public void setPredDipPr(Integer predDipPr) {
        this.predDipPr = predDipPr;
    }

    public Integer getNiir() {
        return niir;
    }

    public void setNiir(Integer niir) {
        this.niir = niir;
    }

    public Boolean getKonsZaoch() {
        return konsZaoch;
    }

    public void setKonsZaoch(Boolean konsZaoch) {
        this.konsZaoch = konsZaoch;
    }

    public Boolean getGek() {
        return gek;
    }

    public void setGek(Boolean gek) {
        this.gek = gek;
    }

    public Boolean getGak() {
        return gak;
    }

    public void setGak(Boolean gak) {
        this.gak = gak;
    }

    public Boolean getGosEkz() {
        return gosEkz;
    }

    public void setGosEkz(Boolean gosEkz) {
        this.gosEkz = gosEkz;
    }

    public Boolean getGakPred() {
        return gakPred;
    }

    public void setGakPred(Boolean gakPred) {
        this.gakPred = gakPred;
    }

    public Boolean getDpRuk() {
        return dpRuk;
    }

    public void setDpRuk(Boolean dpRuk) {
        this.dpRuk = dpRuk;
    }

    public Boolean getDopuskVkr() {
        return dopuskVkr;
    }

    public void setDopuskVkr(Boolean dopuskVkr) {
        this.dopuskVkr = dopuskVkr;
    }

    public Boolean getRetzVkr() {
        return retzVkr;
    }

    public void setRetzVkr(Boolean retzVkr) {
        this.retzVkr = retzVkr;
    }

    public Boolean getDpRetz() {
        return dpRetz;
    }

    public void setDpRetz(Boolean dpRetz) {
        this.dpRetz = dpRetz;
    }

    public Boolean getAspRuk() {
        return aspRuk;
    }

    public void setAspRuk(Boolean aspRuk) {
        this.aspRuk = aspRuk;
    }

    public Boolean getMagRuk() {
        return magRuk;
    }

    public void setMagRuk(Boolean magRuk) {
        this.magRuk = magRuk;
    }

    public Boolean getMagRetz() {
        return magRetz;
    }

    public void setMagRetz(Boolean magRetz) {
        this.magRetz = magRetz;
    }

    public Boolean getRukKaf() {
        return rukKaf;
    }

    public void setRukKaf(Boolean rukKaf) {
        this.rukKaf = rukKaf;
    }

    public Boolean getSpecial() {
        return isSpecial;
    }

    public void setSpecial(Boolean special) {
        isSpecial = special;
    }

    public Boolean getContr() {
        return contr;
    }

    public void setContr(Boolean contr) {
        this.contr = contr;
    }
}
