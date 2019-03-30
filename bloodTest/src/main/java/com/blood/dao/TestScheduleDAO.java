package com.blood.dao;

import com.blood.pojo.TestSchedule;
import com.blood.pojo.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Check PreviousTestDao.java for general information of DAO classes

/**
 * Author: Swapnil
 * Date: 21/02/2019
 * DAO class for test shcedule
 */

@Repository
public interface TestScheduleDAO extends JpaRepository<TestSchedule, Integer>{
    TestSchedule findById(int id);
   // TestSchedule findByOPA(String OPA);
    TestSchedule findByDate(String date);
    TestSchedule findByCompleted(boolean completed);
    TestSchedule findByPatient(Patient patient);
  //  TestSchedule findByIdLabel(int idlabel);
}