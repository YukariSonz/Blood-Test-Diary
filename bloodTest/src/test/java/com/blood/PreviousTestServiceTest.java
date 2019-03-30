package com.blood;

import java.util.Date;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import com.blood.pojo.PreviousTest;
import com.blood.service.PreviousTestService;
import org.junit.Test;
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
public class PreviousTestServiceTest{
    @Autowired
    PreviousTestService previousTestService;

    @Test
    public void saveAndFindTest(){
        Date date = new Date();
        PreviousTest dummy = new PreviousTest("KCL",date,"dummy");
        previousTestService.save(dummy);
        PreviousTest dummy2 = previousTestService.findById(dummy.getId());
        assertEquals(dummy.getLocation(),dummy2.getLocation());
        assertEquals(dummy.getCommet(),dummy2.getCommet());
        previousTestService.deletePreviousTest(dummy.getId());
    }
}