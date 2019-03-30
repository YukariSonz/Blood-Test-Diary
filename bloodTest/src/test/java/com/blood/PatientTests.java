package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import com.blood.pojo.Patient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class PatientTests {
    

    @Test
    public void testGetForename() {
        Patient patient = new Patient("tForename", "tSurname", "tEmail");
        assertEquals(patient.getForename(), "tForename");
    }

    @Test
    public void testSetForename() {
        Patient patient = new Patient("tForename", "tSurname", "tEmail");
        patient.setForename("changedName");
        assertEquals(patient.getForename(), "changedName");
    }

    @Test
    public void testGetSurname() {
        Patient patient = new Patient("tForename", "tSurname", "tEmail");
        assertEquals(patient.getSurname(), "tSurname");
    }

    @Test
    public void testSetSurename() { 
        Patient patient = new Patient("tForename", "tSurname", "tEmail");
        patient.setSurname("changedName");
        assertEquals(patient.getSurname(), "changedName");
    }

    @Test
    public void testGetEmail() {
        Patient patient = new Patient("tForename", "tSurname", "tEmail");
        assertEquals(patient.getEmail(), "tEmail");
    }

    @Test
    public void testSetEmail() {
        Patient patient = new Patient("tForename", "tSurname", "tEmail");
        patient.setEmail("changedEmail");
        assertEquals(patient.getEmail(), "changedEmail");
    }

    @Test
    public void testGetSurgery() {
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
       "tTransplant", "tlocal_hospital", "tSurgery", "tComments", "1334444", "abcd@abc.com");
        
        assertEquals(patient.getSurgery(), "tSurgery");
    }

    @Test
    public void testSetSurgery() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
        "tTransplant", "tlocal_hospital", "tSurgery", "tComments", "1234", "email@email.com");
        patient.setSurgery("changedSurgery");
        assertEquals(patient.getSurgery(), "changedSurgery");
    }

    @Test
    public void testGetComments() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
       "tTransplant", "tlocal_hospital", "tSurgery", "tComments","1234", "email@email.com");
        
        assertEquals(patient.getComments(), "tComments");
    }

    @Test
    public void testSetComments() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
        "tTransplant", "tlocal_hospital", "tSurgery", "tComments", "1234", "email@email.com");
        patient.setComments("changedComments");
        assertEquals(patient.getComments(), "changedComments");
    }

    @Test
    public void testgetDiagnosis() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
       "tTransplant", "tlocal_hospital", "tSurgery", "tComments", "1234", "email@email.com");
        
        assertEquals(patient.getDiagnosis(), "tDiagnosis");
    }

    @Test
    public void testSetDiagnosis() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
        "tTransplant", "tlocal_hospital", "tSurgery", "tComments", "1234", "email@email.com");
        patient.setDiagnosis("changedDiagnosis");
        assertEquals(patient.getDiagnosis(), "changedDiagnosis");
    }

    @Test
    public void testgetLocal_hospital(){
        Patient patient = new Patient();
        assertEquals(null, patient.getLocal_hospital());
    }

    @Test
    public void testsetLocal_hospital(){
        Patient patient = new Patient();
        patient.setLocal_hospital("kcl");
        assertEquals("kcl", patient.getLocal_hospital());
    }

    
    @Test
    public void testgetPhone(){
        Patient patient = new Patient();
        assertEquals(null, patient.getPhone());
    }

    @Test
    public void testsetPhone(){
        Patient patient = new Patient();
        patient.setPhone("1234567890");
        assertEquals("1234567890", patient.getPhone());
    }

    @Test
    public void testgetDOB(){
        Patient patient = new Patient();
        assertEquals(null, patient.getDOB());
    }

    @Test
    public void testsetDOB(){
        Patient patient = new Patient();
        patient.setDOB("2019-1-1");
        assertEquals("2019-1-1", patient.getDOB());
    }

    @Test
    public void testgetSex(){
        Patient patient = new Patient();
        assertEquals(null, patient.getSex());
    }

    @Test
    public void testsetSex(){
        Patient patient = new Patient();
        patient.setSex('M');
        assertEquals('M', patient.getSex());
    }

    @Test
    public void testgetTransplant(){
        Patient patient = new Patient();
        assertEquals(null, patient.getTransplant());
    }

    @Test
    public void testsetTransplant(){
        Patient patient = new Patient();
        patient.setTransplant("abc");
        assertEquals("abc", patient.getTransplant());
    }

    @Test
    public void testEmptyDetails() {   
        Patient patient = new Patient();
        assertEquals(patient.getEmail(), null);
        assertEquals(patient.getSurname(), null);
        assertEquals(patient.getForename(), null);
        assertEquals(patient.getSurgery(), null);
        assertEquals(patient.getComments(), null);
        assertEquals(patient.getDiagnosis(), null);
    }
    

}