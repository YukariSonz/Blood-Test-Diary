package com.blood.dao;

import com.blood.pojo.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Check PreviousTestDao.java for general information of DAO classes

/**
 * DAO class for Staff
 */
@Repository
public interface StaffDAO extends JpaRepository<Staff, Long>{
    Staff findByUsername(String username);
    Staff findById(int id);
    Staff findByEmail(int email);

    //public Staff createStaff(Staff staff);
    
}
