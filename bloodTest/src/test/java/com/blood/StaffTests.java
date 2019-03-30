package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import com.blood.pojo.Staff;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class StaffTests {

    @Test
    public void testStaffGetUsername() {
        Staff staff = new Staff("tUsername", "tForename", "tSurname", "tEmail", "tPassword");     
        assertEquals(staff.getUsername(), "tUsername");
    }

    @Test
    public void testStaffSetUsername() {
        Staff staff = new Staff("tUsername", "tForename", "tSurname", "tEmail", "tPassword");
        staff.setUsername("changedUsername");     
        assertEquals(staff.getUsername(), "changedUsername");
    }

    @Test
    public void testStaffGetForename() {
        Staff staff = new Staff("tUsername", "tForename", "tSurname", "tEmail", "tPassword");     
        assertEquals(staff.getForename(), "tForename");
    }

    @Test
    public void testStaffSetForename() {
        Staff staff = new Staff("tUsername", "tForename", "tSurname", "tEmail", "tPassword");
        staff.setForename("changedForename");     
        assertEquals(staff.getForename(), "changedForename");
    }

    @Test
    public void testStaffGetSurname() {
        Staff staff = new Staff("tUsername", "tForename", "tSurname", "tEmail", "tPassword");     
        assertEquals(staff.getSurname(), "tSurname");
    }

    @Test
    public void testStaffSetSurname() {
        Staff staff = new Staff("tUsername", "tForename", "tSurname", "tEmail", "tPassword");
        staff.setSurname("changedSurname");     
        assertEquals(staff.getSurname(), "changedSurname");
    }

    @Test
    public void testStaffGetEmail() {
        Staff staff = new Staff("tUsername", "tForename", "tSurname", "tEmail", "tPassword");     
        assertEquals(staff.getEmail(), "tEmail");
    }

    @Test
    public void testStaffSetEmail() {
        Staff staff = new Staff("tUsername", "tForename", "tSurname", "tEmail", "tPassword");
        staff.setEmail("changedEmail");     
        assertEquals(staff.getEmail(), "changedEmail");
    }

    @Test
    public void testStaffGetPassword() {
        Staff staff = new Staff("tUsername", "tForename", "tSurname", "tEmail", "tPassword");     
        assertEquals(staff.getPassword(), "tPassword");
    }

    @Test
    public void testStaffSetPassword() {
        Staff staff = new Staff("tUsername", "tForename", "tSurname", "tEmail", "tPassword");
        staff.setPassword("changedPassword");     
        assertEquals(staff.getPassword(), "changedPassword");
    }

    @Test
    public void testEmptyStaff() {   
        Staff staff = new Staff();
        assertEquals(staff.getUsername(), null);
        assertEquals(staff.getForename(), null);
        assertEquals(staff.getSurname(), null);
        assertEquals(staff.getEmail(), null);
        assertEquals(staff.getPassword(), null);
    }

}