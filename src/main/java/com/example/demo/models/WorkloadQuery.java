package com.example.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WorkloadQuery {
    private Integer studyYear;
    @Id
    private Integer id;
    private String qualificationDescr;
    private String studyForm;
    private String descr;
    private Integer semesterDescr;
    private String specialityDescr;
    private String facultyDescr;
    private Integer studentCount;
    private Integer weekCount;
    private Integer lectureCount;
    private Integer practiceCount;
    private Integer labCount;
    private Boolean ekz;
    private Boolean zach;
    private Boolean rgr;
    private Boolean kr;
    private Boolean kp;
    private Integer uchPr;
    private Integer prPr;
    private Integer predDipPr;
    private Boolean konsZaoch;
    private Boolean gek;
    private Boolean gak;
    private Boolean gakPred;
    private Boolean dpRuk;
    private Boolean dopuskVkr;
    private Boolean retzVkr;
    private Boolean dpRetz;
    private Boolean aspRuk;
    private Boolean magRuk;
    private Boolean magRetz;
    private Boolean rukKaf;
    private Integer niir;
    private Boolean isSpecial;
    private Integer subgroupCount;
    private Boolean contr;
    private Integer teacher;

    private Boolean isContract;

    public Boolean getContract() {
        return isContract;
    }

    public void setContract(Boolean contract) {
        isContract = contract;
    }

    public Integer getSemesterDescr() {
        return semesterDescr;
    }

    public void setSemesterDescr(Integer semesterDescr) {
        this.semesterDescr = semesterDescr;
    }

    public String getSpecialityDescr() {
        return specialityDescr;
    }

    public void setSpecialityDescr(String specialityDescr) {
        this.specialityDescr = specialityDescr;
    }

    public String getFacultyDescr() {
        return facultyDescr;
    }

    public void setFacultyDescr(String facultyDescr) {
        this.facultyDescr = facultyDescr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }


    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setQualificationDescr(String qualificationDescr) {
        this.qualificationDescr = qualificationDescr;
    }

    public String getQualificationDescr() {
        return qualificationDescr;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public void setWeekCount(Integer weekCount) {
        this.weekCount = weekCount;
    }

    public void setLectureCount(Integer lectureCount) {
        this.lectureCount = lectureCount;
    }

    public void setPracticeCount(Integer practiceCount) {
        this.practiceCount = practiceCount;
    }

    public void setLabCount(Integer labCount) {
        this.labCount = labCount;
    }

    public void setEkz(Boolean ekz) {
        this.ekz = ekz;
    }

    public void setZach(Boolean zach) {
        this.zach = zach;
    }

    public void setRgr(Boolean rgr) {
        this.rgr = rgr;
    }

    public void setKr(Boolean kr) {
        this.kr = kr;
    }

    public void setKp(Boolean kp) {
        this.kp = kp;
    }

    public void setUchPr(Integer uchPr) {
        this.uchPr = uchPr;
    }

    public void setPrPr(Integer prPr) {
        this.prPr = prPr;
    }

    public void setPredDipPr(Integer predDipPr) {
        this.predDipPr = predDipPr;
    }

    public void setKonsZaoch(Boolean konsZaoch) {
        this.konsZaoch = konsZaoch;
    }

    public void setGek(Boolean gek) {
        this.gek = gek;
    }

    public void setGak(Boolean gak) {
        this.gak = gak;
    }

    public void setGakPred(Boolean gakPred) {
        this.gakPred = gakPred;
    }

    public void setDpRuk(Boolean dpRuk) {
        this.dpRuk = dpRuk;
    }

    public void setDopuskVkr(Boolean dopuskVkr) {
        this.dopuskVkr = dopuskVkr;
    }

    public void setRetzVkr(Boolean retzVkr) {
        this.retzVkr = retzVkr;
    }

    public void setDpRetz(Boolean dpRetz) {
        this.dpRetz = dpRetz;
    }

    public void setAspRuk(Boolean aspRuk) {
        this.aspRuk = aspRuk;
    }

    public void setMagRuk(Boolean magRuk) {
        this.magRuk = magRuk;
    }

    public void setMagRetz(Boolean magRetz) {
        this.magRetz = magRetz;
    }

    public void setRukKaf(Boolean rukKaf) {
        this.rukKaf = rukKaf;
    }

    public void setNiir(Integer niir) {
        this.niir = niir;
    }

    public void setSpecial(Boolean special) {
        isSpecial = special;
    }

    public void setSubgroupCount(Integer subgroupCount) {
        this.subgroupCount = subgroupCount;
    }

    public void setContr(Boolean contr) {
        this.contr = contr;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public String getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(String studyForm) {
        this.studyForm = studyForm;
    }

    public Integer getStudyYear() {
        return studyYear;
    }


    public String getDescr() {
        return descr;
    }


    public Integer getStudentCount() {
        return studentCount;
    }

    public Integer getWeekCount() {
        return weekCount;
    }

    public Integer getLectureCount() {
        return lectureCount;
    }

    public Integer getPracticeCount() {
        return practiceCount;
    }

    public Integer getLabCount() {
        return labCount;
    }

    public Boolean getEkz() {
        return ekz;
    }

    public Boolean getZach() {
        return zach;
    }

    public Boolean getRgr() {
        return rgr;
    }

    public Boolean getKr() {
        return kr;
    }

    public Boolean getKp() {
        return kp;
    }

    public Integer getUchPr() {
        return uchPr;
    }

    public Integer getPrPr() {
        return prPr;
    }

    public Integer getPredDipPr() {
        return predDipPr;
    }

    public Boolean getKonsZaoch() {
        return konsZaoch;
    }

    public Boolean getGek() {
        return gek;
    }

    public Boolean getGak() {
        return gak;
    }

    public Boolean getGakPred() {
        return gakPred;
    }

    public Boolean getDpRuk() {
        return dpRuk;
    }

    public Boolean getDopuskVkr() {
        return dopuskVkr;
    }

    public Boolean getRetzVkr() {
        return retzVkr;
    }

    public Boolean getDpRetz() {
        return dpRetz;
    }

    public Boolean getAspRuk() {
        return aspRuk;
    }

    public Boolean getMagRuk() {
        return magRuk;
    }

    public Boolean getMagRetz() {
        return magRetz;
    }

    public Boolean getRukKaf() {
        return rukKaf;
    }

    public Integer getNiir() {
        return niir;
    }

    public Boolean getSpecial() {
        return isSpecial;
    }

    public Integer getSubgroupCount() {
        return subgroupCount;
    }

    public Boolean getContr() {
        return contr;
    }

    public Integer getTeacher() {
        return teacher;
    }
}
