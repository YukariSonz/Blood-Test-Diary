package com.blood.service;

import com.blood.dao.PatientDAO;
import com.blood.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provide methods about patinets in this web appllication include:
 *   - Email Sending
 *   - Add a new patient
 *   - Delete a patient
 *   - List all paitent that should be notified
 *   - Get all patients
 *   - Update a patient
 *   - find a patient by ID/Surname/Forename/Email
 */
@Service
public class PatientService {
    @Autowired
    PatientDAO patientDAO;

    /**
     * Find a patient by email
     * @param email -- email of the patient
     * @return patient with that email
     */
    public Patient findByEmail(String email) {
        return patientDAO.findByEmail(email);
    }
    
    
    
    /**
     * Add a new patient and return it
     * @param patient -- patient to be added to DB
     * @return patient -- same as above
     */
    public Patient createPatient(Patient patient) {
        patientDAO.save(patient);
        return patient;
    }

    /**
     * Delete the patient with specific ID
     * @param id -- id of the patient to be deleted
     */
    public void deletePatient(int id) {
        patientDAO.delete(patientDAO.findById(id));
    }

    

    /** 
     * retrive all patient
     * @return List of all patients
     */
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        this.patientDAO.findAll().forEach(patients::add);
        return patients;
    }


    /**
     * Delete the patient
     * @param patient -- patient to be deleted
     */
    public void deletePatient(Patient patient) {
        patientDAO.delete(patient);
    }

    /**
     * Find all patients
     * @return List of all patients
     */
    public List<Patient> findAll() {
        return patientDAO.findAll();
    }

    /**
     * Find the patient by ID
     * @param id -- id of the patient
     * @return patient returned 
     */
    public Patient findById(int id) {
        return patientDAO.findById(id);
    }

    /**
     * Find the patient by surname
     * @param keyWord -- surname of the patient
     * @return matched patients list
     */
    public List<Patient> findBySurname(String keyWord) {
        List<Patient> patients = patientDAO.findAll();
        List<Patient> res = new ArrayList<Patient>();
        for (Patient patient : patients) {
            if (patient.getSurname().equals(keyWord)) {
                res.add(patient);
            }
        }
        return res;

    }

    /**
     * Find the patient by forename
     * @param keyWord -- forename of the patient
     * @return matched patients list
     */
    public List<Patient> findByForename(String keyWord) {
        List<Patient> patients = patientDAO.findAll();
        List<Patient> res = new ArrayList<Patient>();
        for (Patient patient : patients) {
            if (patient.getForename().equals(keyWord)) {
                res.add(patient);
            }
        }
        return res;
    }

}
