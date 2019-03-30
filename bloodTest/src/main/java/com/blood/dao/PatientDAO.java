package com.blood.dao;

import com.blood.pojo.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Check PreviousTestDao.java for general information of DAO classes

/**
 * DAO class for patient
 */
@Repository
public interface PatientDAO extends JpaRepository<Patient,Long>{
        //Patient findByUsername(String username);
        Patient findByEmail(String email);
        Patient findById(int id);
}
