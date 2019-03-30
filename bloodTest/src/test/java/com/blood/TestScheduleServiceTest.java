package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import com.blood.pojo.TestSchedule;
import com.blood.pojo.Patient;
import com.blood.service.TestScheduleService;
import org.junit.Test;
import java.util.Date;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.*;
/**
 * IMPORTANT NOTE: These test cases might effect data at DB
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestScheduleServiceTest{
    @Autowired
    TestScheduleService testScheduleService;

    @Test
    public void testSaveAndDelete(){
        Date date = new Date();
        TestSchedule dummy = new TestSchedule("KCL",date,false,"DummyComment",true,"1",0);
        testScheduleService.save(dummy);
        TestSchedule dummy2 = testScheduleService.findById(dummy.getId());
        assertEquals(dummy.getLocation(),dummy2.getLocation());
        assertEquals(dummy.getCommet(),dummy2.getCommet());
        assertEquals(dummy.isCompleted(),dummy2.isCompleted());
        assertEquals(dummy.isNotified(),dummy2.isNotified());
        testScheduleService.deleteTest(dummy.getId());
    }

    @Test
    public void testFindByCompleted(){
        Date date = new Date();
        TestSchedule dummy = new TestSchedule("KCL",date,false,"DummyComment",true,"1",0);
        testScheduleService.save(dummy);
        TestSchedule dummy2 = testScheduleService.findByCompleted(dummy.isCompleted());
        assertEquals(dummy.getLocation(),dummy2.getLocation());
        assertEquals(dummy.getCommet(),dummy2.getCommet());
        assertEquals(dummy.isCompleted(),dummy2.isCompleted());
        assertEquals(dummy.isNotified(),dummy2.isNotified());
        testScheduleService.deleteTest(dummy.getId());
    }

    @Test
    public void testUpdateLabel(){
        Date date = new Date();
        TestSchedule dummy = new TestSchedule("KCL",date,false,"DummyComment",true,"1",0);
        testScheduleService.save(dummy);
        dummy.setCompleted(true);
        dummy.setLocation("Guys Hospital");
        testScheduleService.save(dummy);
        TestSchedule dummy2 = testScheduleService.findById(dummy.getId());
        assertEquals(dummy.getLocation(),dummy2.getLocation());
        assertEquals(dummy.getCommet(),dummy2.getCommet());
        assertEquals(dummy.isCompleted(),dummy2.isCompleted());
        assertEquals(dummy.isNotified(),dummy2.isNotified());
        testScheduleService.deleteTest(dummy.getId());
    }
}