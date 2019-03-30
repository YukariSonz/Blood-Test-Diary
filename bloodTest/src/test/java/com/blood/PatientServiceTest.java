package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import com.blood.pojo.Patient;
import com.blood.service.PatientService;
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
public class PatientServiceTest{

    @Autowired
    PatientService patientService;

    @Test
    public void createAndDeletePaitnetTest(){
        Patient dummy = new Patient("FN","SN","email@email.com");
        patientService.createPatient(dummy);
        Patient dummy2 = patientService.findById(dummy.getId());
        assertEquals(dummy.getSurname(),dummy2.getSurname());
        assertEquals(dummy.getForename(),dummy2.getForename());
        assertEquals(dummy.getEmail(),dummy2.getEmail());
        patientService.deletePatient(dummy);
    }


}