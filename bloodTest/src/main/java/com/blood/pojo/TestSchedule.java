/**
 * A Class representing the scheduling of blood tests for patients
 * 
 * @author Yeshvanth Prabakar, Patryck Whyte, Swapnil Paul, Zhenjie Jiang, Yilei Liang and Tao Lin
 * @version 2019.02.21
 * 
 */
package com.blood.pojo;

import org.springframework.context.annotation.Role;

import java.util.Set;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "test_schedule")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class TestSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtest_schedule")
    private int id;
    @Column(name = "location")
    private String location;
    @Column(name = "date")
    private Date date;
    @Column(name = "miss_test")
    private int missTest;
    @Column(name = "completed")
    private boolean completed;
    @Column(name = "commet")
    private String commet;
    @Column(name = "notified")
    private boolean notified;
    @Column(name = "resultsent")
    private boolean resultsent;    
    @ManyToOne
    @JoinColumn(name = "idpatient")
    private Patient patient;
    @Column(name = "idlabel")
    private String idlabel;

    public TestSchedule() {

    }

    public TestSchedule(String location, Date date, boolean completed, String comment, boolean notified, String idlabel, int miss_test) {
        this.location = location;
        this.date = date;
        this.completed = completed;
        this.commet = comment;
        this.notified = notified;
        this.idlabel = idlabel;
        this.missTest = miss_test;
    }

    // getters to retrieve scheduling information for patients

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMissTest() {
        return missTest;
    }

    public void setMissTest(int miss_test) {
        this.missTest = miss_test;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCommet() {
        return commet;
    }

    public void setCommet(String comment) {
        this.commet = comment;
    }

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }

    public boolean isResultSent() {
        return notified;
    }

    public void setResultSent(boolean resultsent) {
        this.resultsent = resultsent;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // public void setIdpatient(int idpatient) {
    // this.idpatient = idpatient;
    // }

    public String getIdlabel() {
        return idlabel;
    }

    public void setIdlabel(String idlabel) {
        this.idlabel = idlabel;
    }
}
