/**
 * 
 * Class containing the labels that correspond to patient priority
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
@Table(name = "label")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontact")
    private int idlabel;
    @Column(name = "name")
    private String name;
    @Column(name = "color")
    private String color;
    @Column(name = "description")
    private String description;

    // getters to return label/flag of patients

    public Label(int id, String name, String color, String description) {
        super();
        this.idlabel = id;
        this.name = name;
        this.color = color;
        this.description = description;
    }

    public Label() {
        super();
    }

    public int getIdlabel() {
        return idlabel;
    }

    public void setIdlabel(int idlabel) {
        this.idlabel = idlabel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
