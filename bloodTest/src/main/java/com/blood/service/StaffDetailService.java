package com.blood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;
import java.util.HashSet;

import com.blood.dao.StaffDAO;
import com.blood.pojo.Staff;

/**
 * This class provide the backend logic for staff details
 */
@Service
public class StaffDetailService implements UserDetailsService {
    @Autowired
    private StaffDAO staffDAO;

    /**
     * Load the user by username
     * @param username -- username of staff
     * @return staff details
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffDAO.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        return new org.springframework.security.core.userdetails.User(staff.getUsername(), staff.getPassword(),
                grantedAuthorities);
    }

}