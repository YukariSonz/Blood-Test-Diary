package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import com.blood.pojo.Contacts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class ContactsTest {


    @Test
    public void testgetContactNum() {
        Contacts contact = new Contacts(0, "tcontactNum","tnotes", 0,"tType");     
        assertEquals(contact.getContactNum(), "tcontactNum");
    }

    @Test
    public void testSetContactNum() {
        Contacts contact = new Contacts(0, "tcontactNum","tnotes", 0,"tType");  
        contact.setContactNum("1"); 
        assertEquals(contact.getContactNum(), "1");
    }

    @Test
    public void testgetNotes() {
        Contacts contact = new Contacts(0, "tcontactNum","tNotes", 0,"tType");     
        assertEquals(contact.getNotes(), "tNotes");
    }

    @Test
    public void testSetNotes() {
        Contacts contact = new Contacts(0, "tcontactNum","tnotes", 0,"tType");    
        contact.setNotes("changedNotes"); 
        assertEquals(contact.getNotes(), "changedNotes");
    }

    @Test
    public void testgetIdcontact() {
        Contacts contact = new Contacts(0, "tcontactNum","tnotes", 0,"tType");     
        assertEquals(contact.getIdcontact(), 0);
    }

    @Test
    public void testSetIdcontact() {
        Contacts contact = new Contacts(0, "tcontactNum","tnotes", 0,"tType");    
        contact.setIdcontact(1); 
        assertEquals(contact.getIdcontact(), 1);
    }

    @Test
    public void testgetType() {
        Contacts contact = new Contacts(0, "tcontactNum","tnotes", 0,"tType");    
        assertEquals(contact.getType(), "tType");
    }

    @Test
    public void testSetType() {    
        Contacts contact = new Contacts(0, "tcontactNum","tnotes", 0,"tType");     
        contact.setType("changedType"); 
        assertEquals(contact.getType(), "changedType");
    }
        
    @Test
    public void testEmptyContacts() {   
        Contacts contacts = new Contacts();
        assertEquals(contacts.getContactNum(), null);
        assertEquals(contacts.getIdpatient(), 0);
        assertEquals(contacts.getNotes(), null);
        assertEquals(contacts.getType(), null);
    }

}