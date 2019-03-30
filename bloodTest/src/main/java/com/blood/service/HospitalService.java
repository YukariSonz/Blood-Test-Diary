package com.blood.service;

import java.util.List;
import java.util.ArrayList;

import com.blood.dao.HospitalDAO;
import com.blood.pojo.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class provides all the backend logic of the web application for hospitals
 *
 */
@Service
public class HospitalService {
    @Autowired
    HospitalDAO hospitalDAO;


    /**
     * Get the specific hospital by its ID
     * @param id -- id of the hospital
     * @return hospital with that id
     */
    public Hospital getById(int id) {
        return hospitalDAO.findById(id);
    }

    /**
     * Get the specific hospital by its name
     * @param hospital -- name of the hospital
     * @return hospital with that name 
     */
    public Hospital getByName(String name) {
        return hospitalDAO.findByName(name);
    }

    /**
     * Get the specific hospital by its phone
     * @param phone -- phone of the hospital
     * @return hospital with that phone
     */
    public Hospital getByPhone(String phone) {
        return hospitalDAO.findByPhone(phone);
    }

    /**
     * Get the specific hospital by its address
     * @param address -- address of the hospital
     * @return hospital with that address
     */
    public Hospital getByAddress(String address) {
        return hospitalDAO.findByAddress(address);
    }

    /**
     * Get the specific hospital by its email
     * @param email -- email of the hospital
     * @return hospital with that email
     */
    public Hospital getByEmail(String email) {
        return hospitalDAO.findByEmail(email);
    }


    /**
     * Get the specific hosptial by its id 
     * @param id -- id of the hospital
     * @return hospital with that id
     */
    public Hospital findById(int id) {
        return hospitalDAO.findById(id);
    }

    /**
     * Change the name of the hospital
     * @param hospital -- hospital to be edited
     * @param name -- name to be set
     */
    public void changeName(Hospital hospital, String name) {
        hospital.setName(name);
        hospitalDAO.save(hospital);
    }

    /**
     * Change the phone of the hospital
     * @param hospital -- hospital to be edited
     * @param phone -- phone to be set
     */
    public void changePhone(Hospital hospital, String phone) {
        hospital.setPhone(phone);
        hospitalDAO.save(hospital);
    }

    /**
     * Change the address of the hospital
     * @param hospital -- hospital to be edited
     * @param address -- address to be set
     */
    public void changeAddress(Hospital hospital, String address) {
        hospital.setAddress(address);
        hospitalDAO.save(hospital);
    }

    /**
     * Change the email of the hospital
     * @param hospital -- hospital to be edited
     * @param email -- email to be set
     */
    public void changeEmail(Hospital hospital, String email) {
        hospital.setEmail(email);
        hospitalDAO.save(hospital);
    }

    /**
     * Create a new hospital and save it to Database
     * @param hospital -- hospital to be added
     * @return hospital -- added hospital 
     */
    public Hospital createHospital(Hospital hospital) {
        hospitalDAO.save(hospital);
        return hospital;
    }

    /**
     * Delete the hospital with that ID
     * @param id -- the id of the hospital to be deleted
     */
    public void deleteHospital(int id) {
        hospitalDAO.delete(hospitalDAO.findById(id));
    }

    /**
     * Get all hospital
     * @return hospital -- the list of all hospital
     */
    public List<Hospital> getAllHospital() {
        List<Hospital> hospital = new ArrayList<>();
        this.hospitalDAO.findAll().forEach(hospital::add);
        return hospital;
    }


    
  
    

}
