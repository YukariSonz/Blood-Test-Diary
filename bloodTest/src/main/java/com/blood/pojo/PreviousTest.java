/**
 * A Class representing the previous of blood tests for patients
 * 
 * @author Yeshvanth Prabakar, Patryck Whyte, Swapnil Paul, Zhenjie Jiang, Yilei
 *         Liang and Tao Lin
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
@Table(name = "previous_test")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class PreviousTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprevioustest")
    private int id;
    @Column(name = "location")
    private String location;
    @Column(name = "date")
    private Date date;
    @Column(name = "commet")
    private String commet;
    @ManyToOne
    @JoinColumn(name = "idpatient")
    private Patient patient;

    public PreviousTest() {

    }

    public PreviousTest(String location, Date date, String comment) {
        this.location = location;
        this.date = date;
        this.commet = comment;
    }

    /**
     * accessor method of retrieving scheduling information for patients
     * @return id -- id of the previous test
     */
    public int getId() {
        return id;
    }

    /**
     * Set the new test Id
     * @param id -- id to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /** 
     * Get the test location
     * @return location -- location of the test
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the test location
     * @param location -- location of the test
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the date of the test
     * @return date -- date of the test
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the date of the test
     * @param date -- date to be set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get the commet
     * @return commet
     */
    public String getCommet() {
        return commet;
    }

    /**
     * Set the commet
     * @param commet
     */
    public void setCommet(String comment) {
        this.commet = comment;
    }

    /**
     * Get the patient of this test
     * @return patient -- patient of this test
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Assign a patient to this test
     * @param patient -- patient of this test
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}