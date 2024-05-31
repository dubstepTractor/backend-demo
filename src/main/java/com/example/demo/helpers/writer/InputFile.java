package com.example.demo.helpers.writer;


public class InputFile {
    public String Descr;
    public Integer idSpeciality;
    public String Department;
    public Integer Employee;
    public Boolean IsContract;
    public Integer StudentCount;
    public Integer SubGroupCount;
    public Integer SemesterDescr;
    public Integer LectureCount;
    public Integer PracticeCount;
    public Integer LabCount;
    public Boolean KR;
    public Boolean KP;
    public Boolean Ekz;
    public Boolean Zach;
    public Boolean KrR;
    public Boolean Cons;
    public Integer UcPract;
    public Integer PrPract;
    public Integer PredDPract;

    public InputFile() {
        Descr = "";
        idSpeciality = -1;
        Department = "";
        Employee = -1;
        IsContract = false;
        StudentCount = 0;
        SemesterDescr = 0;
        LectureCount = 0;
        PracticeCount = 0;
        LabCount = 0;
        SubGroupCount = -1;
        KR = false;
        KP = false;
        Ekz = false;
        Zach = false;
        KrR = false;
        Cons = false;
        UcPract = 0;
        PrPract = 0;
        PredDPract = 0;
    }

    public InputFile(String descr, Integer idSpeciality, String department, Integer employee, Boolean isContract, Integer studentCount, Integer subGroupCount, Integer semesterDescr, Integer lectureCount, Integer practiceCount, Integer labCount, Boolean KR, Boolean KP, Boolean ekz, Boolean zach, Boolean krR, Boolean cons, Integer pract, Integer prPract, Integer predDPract) {
        Descr = descr;
        this.idSpeciality = idSpeciality;
        Department = department;
        Employee = employee;
        IsContract = isContract;
        StudentCount = studentCount;
        SubGroupCount = subGroupCount;
        SemesterDescr = semesterDescr;
        LectureCount = lectureCount;
        PracticeCount = practiceCount;
        LabCount = labCount;
        this.KR = KR;
        this.KP = KP;
        Ekz = ekz;
        Zach = zach;
        KrR = krR;
        Cons = cons;
        UcPract = pract;
        PrPract = prPract;
        PredDPract = predDPract;
    }

    public Integer getPrPract() {
        return PrPract;
    }

    public void setPrPract(Integer prPract) {
        PrPract = prPract;
    }

    public Integer getPredDPract() {
        return PredDPract;
    }

    public void setPredDPract(Integer predDPract) {
        PredDPract = predDPract;
    }

    public Integer getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Integer idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public Integer getSubGroupCount() {
        return SubGroupCount;
    }

    public void setSubGroupCount(Integer subGroupCount) {
        SubGroupCount = subGroupCount;
    }

    public String getDescr() {
        return Descr;
    }

    public void setDescr(String descr) {
        Descr = descr;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public Integer getEmployee() {
        return Employee;
    }

    public void setEmployee(Integer employee) {
        Employee = employee;
    }

    public Boolean getContract() {
        return IsContract;
    }

    public void setContract(Boolean contract) {
        IsContract = contract;
    }

    public Integer getStudentCount() {
        return StudentCount;
    }

    public void setStudentCount(Integer studentCount) {
        StudentCount = studentCount;
    }

    public Integer getSemesterDescr() {
        return SemesterDescr;
    }

    public void setSemesterDescr(Integer semesterDescr) {
        SemesterDescr = semesterDescr;
    }

    public Integer getLectureCount() {
        return LectureCount;
    }

    public void setLectureCount(Integer lectureCount) {
        LectureCount = lectureCount;
    }

    public Integer getPracticeCount() {
        return PracticeCount;
    }

    public void setPracticeCount(Integer practiceCount) {
        PracticeCount = practiceCount;
    }

    public Integer getLabCount() {
        return LabCount;
    }

    public void setLabCount(Integer labCount) {
        LabCount = labCount;
    }

    public Boolean getKR() {
        return KR;
    }

    public void setKR(Boolean KR) {
        this.KR = KR;
    }

    public Boolean getKP() {
        return KP;
    }

    public void setKP(Boolean KP) {
        this.KP = KP;
    }

    public Boolean getEkz() {
        return Ekz;
    }

    public void setEkz(Boolean ekz) {
        Ekz = ekz;
    }

    public Boolean getZach() {
        return Zach;
    }

    public void setZach(Boolean zach) {
        Zach = zach;
    }

    public Boolean getKrR() {
        return KrR;
    }

    public void setKrR(Boolean krR) {
        KrR = krR;
    }

    public Boolean getCons() {
        return Cons;
    }

    public void setCons(Boolean cons) {
        Cons = cons;
    }

    public Integer getUcPract() {
        return UcPract;
    }

    public void setUcPract(Integer ucPract) {
        UcPract = ucPract;
    }
}
