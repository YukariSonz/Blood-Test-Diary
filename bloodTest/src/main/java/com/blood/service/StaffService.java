package com.blood.service;

import com.blood.dao.StaffDAO;
import com.blood.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

/**
 * This class provide the backend logic for staff entities
 */
@Service
public class StaffService {
    @Autowired
    StaffDAO staffDAO;

    private BCryptPasswordEncoder encoder;

    /** 
     * Encode password
     * @param staff -- staff to be saved
     */
    public void saveStaff(Staff staff) {
        staff.setPassword(encoder.encode(staff.getPassword()));
        staffDAO.save(staff);
    }

    /**
    *  @return the current username
    */
    public String getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.out.print(currentUserName);
            return currentUserName;
        }
        return " ";
    }

    /*
     * change password
     * @param staff -- staff which password should be changed
     * @param password -- new password
     */
    public void changePassword(Staff staff, String password) {
        staff.setPassword(encoder.encode(password));
        staffDAO.save(staff);
    }

    /** 
     * change username
     * @param staff -- staff which username should be changed
     * @param username -- new username
     */
    public void changeUsername(Staff staff, String username) {
        staff.setUsername(username);
        staffDAO.save(staff);
    }

    /**
     * Get staff by id
     * @param id -- id of the staff
     * @return staff with that id
     */
    public Staff getById(int id) {
        return staffDAO.findById(id);
    }

    /**
     * Get staff by username
     * @param username -- username of the staff
     * @return staff with that username
     */
    public Staff getByUsername(String username) {
        return staffDAO.findByUsername(username);
    }


    /**
     * Create a new staff
     * @param staff -- staff to be created
     * @return created staff
     */
    public Staff createStaff(Staff staff){
         staffDAO.save(staff);
         return staff;
    }
    

    /*
     * @return all staffs
     */
    public List<Staff> getAllStaff() {
        List<Staff> staffs = new ArrayList<>();
        this.staffDAO.findAll().forEach(staffs::add);
        return staffs;
    }
}
