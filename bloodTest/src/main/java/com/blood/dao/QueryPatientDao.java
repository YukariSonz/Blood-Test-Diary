package com.blood.dao;

import com.blood.pojo.Patient;

import java.util.List;


/**
 * @Author Yilei Liang
 */

public interface QueryPatientDao{
	
	/**
	 * Find all expired patients
	 */
	List<Patient> findExpired();
	
	/**
	 * Update the information of the patient
	 */
	Patient update(Patient patient);

	/**
	 * Delete the patient
	 */
	Patient delete(Patient patient);
	
	
	/**
	 * Add new patient
	 */
	void add(Patient patient);
	 
	/**
	 * Find all patients records
	 */
	
	List<Patient> findAllPatients();
	
	/**
	 * Search By Key Word of the Forename
	 */
	 
	List<Patient> findByForename(String keyWord);


	/**
	 * Search By Key Word of the Surname
	 */

	List<Patient> findBySurname(String keyWord);
}