package com.example.rbms;

public class Student {

    private String sname;
    private Integer sage;
    private String semail;
    private Long scontact;
    private String snic;
    private String ssubject;

    public Student() {
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public Long getScontact() {
        return scontact;
    }

    public void setScontact(Long scontact) {
        this.scontact = scontact;
    }

    public String getSnic() {
        return snic;
    }

    public void setSnic(String snic) {
        this.snic = snic;
    }

    public String getSsubject() {
        return ssubject;
    }

    public void setSsubject(String ssubject) {
        this.ssubject = ssubject;
    }
}
