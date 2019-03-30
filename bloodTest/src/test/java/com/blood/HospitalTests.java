package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import com.blood.pojo.Hospital;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class HospitalTests {

    @Test
    public void testGetName() {
        Hospital hospital = new Hospital("tName", "tAddress", "tEmail", "tPhone");
        assertEquals(hospital.getName(), "tName");
    }

    @Test
    public void testSetName() {
        Hospital hospital = new Hospital("tName", "tAddress", "tEmail", "tPhone");
        hospital.setName("changedName");
        assertEquals(hospital.getName(), "changedName");
    }

    @Test
    public void testGetAddress() {
        Hospital hospital = new Hospital("tName", "tAddress", "tEmail", "tPhone");
        assertEquals(hospital.getAddress(), "tAddress");
    }

    @Test
    public void testSetAddress() {
        Hospital hospital = new Hospital("tName", "tAddress", "tEmail", "tPhone");
        hospital.setAddress("changedAddress");
        assertEquals(hospital.getAddress(), "changedAddress");
    }

    @Test
    public void testGetEmail() {
        Hospital hospital = new Hospital("tName", "tAddress", "tEmail", "tPhone");
        assertEquals(hospital.getEmail(), "tEmail");
    }

    @Test
    public void testSetEmail() {
        Hospital hospital = new Hospital("tName", "tAddress", "tEmail", "tPhone");
        hospital.setEmail("changedEmail");
        assertEquals(hospital.getEmail(), "changedEmail");
    }

    @Test
    public void testGetPhone() {
        Hospital hospital = new Hospital("tName", "tAddress", "tEmail", "tPhone");
        assertEquals(hospital.getPhone(), "tPhone");
    }

    @Test
    public void testSetPhone() {
        Hospital hospital = new Hospital("tName", "tAddress", "tEmail", "tPhone");
        hospital.setPhone("changedPhone");
        assertEquals(hospital.getPhone(), "changedPhone");
    }

    @Test
    public void testEmptyHospital() {   
        Hospital hospital = new Hospital();
        assertEquals(hospital.getName(), null);
        assertEquals(hospital.getAddress(), null);
        assertEquals(hospital.getEmail(), null);
        assertEquals(hospital.getPhone(), null);
    }

}