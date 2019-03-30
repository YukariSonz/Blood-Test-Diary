package com.blood.dao;

import com.blood.pojo.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Check PreviousTestDao.java for general information of DAO classes

/**
 * Author: Swapnil Date: 21/02/2019
 * DAO class for hospital
 */

@Repository
public interface HospitalDAO extends JpaRepository<Hospital, Long> {
    Hospital findById(int id);

    Hospital findByName(String name);

    Hospital findByPhone(String phone);

    Hospital findByAddress(String address);

    Hospital findByEmail(String email);

}