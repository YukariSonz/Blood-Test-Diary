package com.blood.validator;

import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.blood.pojo.Staff;
import com.blood.service.StaffService;
/**
 * This class validate the username and password of staffs
 */
@Component
public class StaffValidator implements Validator {

    @Autowired
    private StaffService staffService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Staff.class.equals(aClass);
    }

    /** 
     * validation for registration
     * @param o
     * @param error
     */
    @Override
    public void validate(Object o, Errors errors) {
        Staff staff = (Staff) o;
        //Case 1: username is empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Field cannot be empty");
        //Case 2: username is too long
        if (staff.getUsername().length() > 20) {
            errors.rejectValue("username", "Too long");
        }
        //Case 3: duplicated username
        if (staffService.getByUsername(staff.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate username");
        }
        //Case 4: Password is empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        //Case 5: Wrong password length
        if (staff.getPassword().length() < 8 || staff.getPassword().length() > 32) {
            errors.rejectValue("password", "must be less than 32 characters and longer than 8");
        }
        //Case 6: Password doesn't match
        if (!staff.getConfirmPassword().equals(staff.getPassword())) {
            errors.rejectValue("Confirmpassword", "Passwords don't match");
        

    }
}

}