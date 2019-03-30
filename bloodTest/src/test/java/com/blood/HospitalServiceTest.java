package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import com.blood.pojo.Hospital;
import com.blood.service.HospitalService;
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
public class HospitalServiceTest{

    @Autowired
    HospitalService hospitalService;
    
    @Test
    public void testSaveAndGetByNameHospital(){
        Hospital dummy = new Hospital("DummyName","DummyAddress","dummy@dummy.com","44123456");
        hospitalService.createHospital(dummy);
        Hospital dummy2 = hospitalService.getByName("DummyName");
        assertEquals(dummy.getName(),dummy2.getName());
        assertEquals(dummy.getAddress(),dummy2.getAddress());
        assertEquals(dummy.getEmail(),dummy2.getEmail());
        assertEquals(dummy.getPhone(),dummy2.getPhone());
        hospitalService.deleteHospital(dummy.getId());
    }

    @Test
    public void testSaveAndGetByAddressHospital(){
        Hospital dummy = new Hospital("DummyName","DummyAddress","dummy@dummy.com","44123456");
        hospitalService.createHospital(dummy);
        Hospital dummy2 = hospitalService.getByAddress("DummyAddress");
        assertEquals(dummy.getName(),dummy2.getName());
        assertEquals(dummy.getAddress(),dummy2.getAddress());
        assertEquals(dummy.getEmail(),dummy2.getEmail());
        assertEquals(dummy.getPhone(),dummy2.getPhone());
        hospitalService.deleteHospital(dummy.getId());
    }

    @Test
    public void testSaveAndGetByEmailHospital(){
        Hospital dummy = new Hospital("DummyName","DummyAddress","dummy@dummy.com","44123456");
        hospitalService.createHospital(dummy);
        Hospital dummy2 = hospitalService.getByEmail("dummy@dummy.com");
        assertEquals(dummy.getName(),dummy2.getName());
        assertEquals(dummy.getAddress(),dummy2.getAddress());
        assertEquals(dummy.getEmail(),dummy2.getEmail());
        assertEquals(dummy.getPhone(),dummy2.getPhone());
        hospitalService.deleteHospital(dummy.getId());
    }
    @Test
    public void testSaveAndGetByPhoneHospital(){
        Hospital dummy = new Hospital("DummyName","DummyAddress","dummy@dummy.com","44123456");
        hospitalService.createHospital(dummy);
        Hospital dummy2 = hospitalService.getByPhone("44123456");
        assertEquals(dummy.getName(),dummy2.getName());
        assertEquals(dummy.getAddress(),dummy2.getAddress());
        assertEquals(dummy.getEmail(),dummy2.getEmail());
        assertEquals(dummy.getPhone(),dummy2.getPhone());
        hospitalService.deleteHospital(dummy.getId());
    }

    @Test
    public void testChangeName(){
        Hospital dummy = new Hospital("DummyName","DummyAddress","dummy@dummy.com","44123456");
        hospitalService.createHospital(dummy);
        hospitalService.changeName(dummy,"dn");
        Hospital after = hospitalService.getById(dummy.getId());
        assertEquals(after.getName(),"dn");
        hospitalService.deleteHospital(dummy.getId());
    }
    
    @Test
    public void testChangeEmail(){
        Hospital dummy = new Hospital("DummyName","DummyAddress","dummy@dummy.com","44123456");
        hospitalService.createHospital(dummy);
        hospitalService.changeEmail(dummy,"dn@dummy.com");
        Hospital after = hospitalService.getById(dummy.getId());
        assertEquals(after.getEmail(),"dn@dummy.com");
        hospitalService.deleteHospital(dummy.getId());
    }

    @Test
    public void testChangePhone(){
        Hospital dummy = new Hospital("DummyName","DummyAddress","dummy@dummy.com","44123456");
        hospitalService.createHospital(dummy);
        hospitalService.changePhone(dummy,"12345");
        Hospital after = hospitalService.getById(dummy.getId());
        assertEquals(after.getPhone(),"12345");
        hospitalService.deleteHospital(dummy.getId());
    }

    @Test
    public void testChangeAddress(){
        Hospital dummy = new Hospital("DummyName","DummyAddress","dummy@dummy.com","44123456");
        hospitalService.createHospital(dummy);
        hospitalService.changeAddress(dummy,"dnAddress");
        Hospital after = hospitalService.findById(dummy.getId());
        assertEquals(after.getAddress(),"dnAddress");
        hospitalService.deleteHospital(dummy.getId());
    }
    
}


