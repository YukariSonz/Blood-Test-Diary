package com.blood.dao;

import com.blood.pojo.PreviousTest;
import com.blood.pojo.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
  General information:
    Dao classes handle the data and allow us to customize our own method to querying the data with Databse
 */

/**
 * DAO class of previous test of the patient
 */
@Repository
public interface PreviousTestDAO extends JpaRepository<PreviousTest, Integer> {
    PreviousTest findById(int id);

    PreviousTest findByDate(String date);

    PreviousTest findByPatient(Patient patient);
}