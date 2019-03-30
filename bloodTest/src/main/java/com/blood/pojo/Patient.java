/**
 * 
 * A Class representing Patient information
 * @author Yeshvanth Prabakar, Patryck Whyte, Swapnil Paul, Zhenjie Jiang, Yilei Liang and Tao Lin
 * @version 2019.02.21
 * 
 */

package com.blood.pojo;

import org.springframework.context.annotation.Role;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.blood.service.TestScheduleService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "patients")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpatient")
    private int id;
    @Column(name = "forename")
    private String forename;
    @Column(name = "surname")
    private String surname;
    @Column(name = "DOB")
    private String DOB;
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "sex")
    private char sex;
    @Column(name = "address")
    private String address;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "transplant")
    private String transplant;
    @Column(name = "local_hospital")
    private String local_hospital;
    @Column(name = "surgery")
    private String surgery;
    @Column(name = "comments")
    private String comments;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<TestSchedule> test;
    // @Column(name = "badge")
    // private String badge;

    public Patient() {
        super();
    }

    public Patient(String forename, String surname, String email) {
        super();
        this.forename = forename;
        this.surname = surname;
        this.email = email;
    }

    public Patient(String forename) {
        super();
        this.forename = forename;
    }

    public Patient(String forename, String surname, String DOB, char sex, String address, String diagnosis,
            String transplant, String local_hospital, String surgery, String comments, String phone, String email) {
        super();
        this.forename = forename;
        this.surname = surname;
        this.DOB = DOB;
        this.sex = sex;
        this.address = address;
        this.diagnosis = diagnosis;
        this.transplant = transplant;
        this.local_hospital = local_hospital;
        this.surgery = surgery;
        this.comments = comments;
        this.phone = phone;
        this.email = email;
    }

    // getters to retreive patient information

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTransplant() {
        return transplant;
    }

    public void setTransplant(String transplant) {
        this.transplant = transplant;
    }

    public String getLocal_hospital() {
        return local_hospital;
    }

    public void setLocal_hospital(String local_hospital) {
        this.local_hospital = local_hospital;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // public String getBadge() {
    // return badge;
    // }

    // public void setBadge(String badge) {
    // this.badge = badge;
    // }

    // public Boolean getOverTime() {
    // return overTime;
    // }

    // public void setOverTime(Boolean overTime) {
    // this.overTime = overTime;
    // }

    // private Boolean overTime;
}
