package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.blood.pojo.PreviousTest;
import com.blood.pojo.Patient;
import org.junit.Test;

public class PreviousTestTests {

    @Test 
    public void testgetId(){
        PreviousTest test = new PreviousTest();
        assertEquals(0, test.getId());
    }

    @Test 
    public void testsetId(){
        PreviousTest test = new PreviousTest();
        test.setId(1);
        assertEquals(1, test.getId());
    }

    @Test 
    public void testgetLocation(){
        PreviousTest test = new PreviousTest();
        assertEquals(null, test.getLocation());
    }

    @Test 
    public void testsetLocation(){
        PreviousTest test = new PreviousTest();
        test.setLocation("kcl");
        assertEquals("kcl", test.getLocation());
    }

    @Test 
    public void testgetDate(){
        PreviousTest test = new PreviousTest();
        assertEquals(null, test.getDate());
    }

    @Test 
    public void testsetDate() throws ParseException{
        PreviousTest test = new PreviousTest();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = "2019-12-12 11:11:00";
        Date data = formatter.parse(datetime);
        test.setDate(data);
        assertEquals(data, test.getDate());
    }

    @Test 
    public void testgetCommet(){
        PreviousTest test = new PreviousTest();
        assertEquals(null, test.getCommet());
    }
   
    @Test 
    public void testsetCommet(){
        PreviousTest test = new PreviousTest();
        test.setCommet("123");
        assertEquals("123", test.getCommet());
    }

    @Test 
    public void testgetPatient(){
        PreviousTest test = new PreviousTest();
        assertEquals(null, test.getPatient());
    }

    @Test 
    public void testsetPatient(){
        PreviousTest test = new PreviousTest();
        Patient patient = new Patient();
        test.setPatient(patient);
        assertEquals(patient, test.getPatient());
    }

    @Test
    public void testsetPatient2(){
        PreviousTest test = new PreviousTest();
        Patient patient = new Patient();
        patient.setComments("123");
        test.setPatient(patient);
        assertEquals("123", test.getPatient().getComments());
    }

    @Test
    public void testEmptyDetails() {
        PreviousTest test = new PreviousTest();
        assertEquals(test.getId(), 0);
        assertEquals(test.getLocation(), null);
        assertEquals(test.getCommet(), null);
        assertEquals(test.getDate(), null);
        assertEquals(test.getPatient(), null);
    }

}