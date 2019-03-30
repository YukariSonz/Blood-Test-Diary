/**
 * 
 * A Class representing the contact information for Patients
 * @author Yeshvanth Prabakar, Patryck Whyte, Swapnil Paul, Zhenjie Jiang, Yilei Liang and Tao Lin
 * @version 2019.02.21
 * 
 */

package com.blood.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.context.annotation.Role;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontact")
    private int idcontact;
    @Column(name = "contactNum")
    private String contactNum;
    @Column(name = "notes")
    private String notes;
    @Column(name = "type")
    private String type;
    @Column(name = "idpatient")
    private int idpatient;

    //Getters retrieve Contact information for patients

    public Contacts(int idcontact, String contactNum, String notes, int idpatient, String type) {
        super();
        this.idcontact = idcontact;
        this.contactNum = contactNum;
        this.notes= notes;
        this.idpatient= idpatient;
        this.type=type;
    }

    public Contacts() {
    }

    public int getIdcontact() {
        return idcontact;
    }

    public void setIdcontact(int idcontact) {
        this.idcontact = idcontact;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

}
