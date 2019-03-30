package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import com.blood.pojo.TestSchedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class TestScheduleTest {
    

    @Test
    public void testGetId() {  
        Date date = new Date();
        TestSchedule test = new TestSchedule("kcl hospital", date, true, "true",false, "badge red", 0);
        assertEquals(test.getId(), 0);
    }

    @Test
    public void testSetId() {
        
        Date date = new Date();
        TestSchedule test = new TestSchedule("kcl hospital", date, true, "true",false, "badge red", 0);
        test.setId(1);
        assertEquals(test.getId(), 1);
    }

    @Test
    public void testGetOPA() {  
        Date date = new Date();
        TestSchedule test = new TestSchedule("kcl hospital", date, true, "true",false, "badge red", 0);
        assertEquals(test.getLocation(), "kcl hospital");
    }

    @Test
    public void testSetOPA() {
        Date date = new Date();
        TestSchedule test = new TestSchedule("kcl hospital", date, true, "true",false, "badge red", 0);
        test.setLocation("newLocation");
        assertEquals(test.getLocation(), "newLocation");
    }

    @Test
    public void testisCompleted() {  
        Date date = new Date();
        TestSchedule test = new TestSchedule("kcl hospital", date, true, "true",false, "badge red", 0);
        assertEquals(test.isCompleted(), true);
    }

    @Test
    public void testSetCompleted() {
        Date date = new Date();
        TestSchedule test = new TestSchedule("kcl hospital", date, true, "true",false, "badge red", 0);
        test.setCompleted(false);
        assertEquals(test.isCompleted(), false);
    }

    @Test
    public void testGetCommet() {  
        Date date = new Date();
        TestSchedule test = new TestSchedule("kcl hospital", date, true, "tCommet",false, "badge red", 0);
        assertEquals(test.getCommet(), "tCommet");
    }

    @Test
    public void testSetCommet() {
        Date date = new Date();
        TestSchedule test = new TestSchedule("kcl hospital", date, true, "tCommet",false, "badge red", 0);
        test.setCommet("changedCommet");
        assertEquals(test.getCommet(), "changedCommet");
    }

    @Test
    public void testEmptyTestSchedule() {   
        TestSchedule test = new TestSchedule();
        assertEquals(test.getId(), 0);
        assertEquals(test.getLocation(), null);
        assertEquals(test.isCompleted(), false);
        assertEquals(test.getCommet(), null);
    }

}
