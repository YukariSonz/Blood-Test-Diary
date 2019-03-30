package com.blood.controller;

import com.blood.pojo.Patient;
import com.blood.service.MailService;
import com.blood.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This class provides HTTP response for patient
 */
@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private MailService mailService;

    @Autowired
    public PatientController(PatientService patientService) {
        super();
        this.patientService = patientService;
    }

    /**
     * Get the registration form for adding a patient
     * @param model
     * @return url to AddPatient
     */
    @RequestMapping(value = "/AddPatient", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "AddPatient";
    }

    /**
     * Save the registration for patient to Database
     * @param patient -- patient to be added to DB
     * @param bindingResult
     * @param model
     * @return url to addPatient page if any error occured, else redirect to page showing all patients
     */
    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("patient") Patient patient, BindingResult bindingResult, Model model) {
        // patientValidator.validate(patient, bindingResult);
        Patient newPatient = new Patient(patient.getForename(),patient.getSurname(),patient.getDOB(),patient.getSex(),patient.getAddress(),
                                        patient.getDiagnosis(),patient.getTransplant(),patient.getLocal_hospital(),patient.getSurgery(),patient.getComments(), patient.getPhone(), patient.getEmail());

       /* if (bindingResult.hasErrors()) {
            return "AddPatient";
        }*/
        try {
            patientService.createPatient(newPatient);
        } catch (Exception e) {
            return "AddPatient";
        }

        return "redirect:/patients";
    }

    /**
     * Get the patients by referencing the id of patient in url
     * @param id
     * @param model
     * @return url to editPatients page
     */
    @RequestMapping(value = "/editPatient/{id}", method = RequestMethod.GET)
    public String getPatientsById(@PathVariable("id") String id, Model model) {
        Patient patient = this.patientService.findById(Integer.parseInt(id));
        model.addAttribute("patient", patient);
        return "editPatients";
    }

    /**
     * Applied the changes for the patient and save it to DB
     * @param patient -- edited patient
     * @param bindingResult
     * @param model
     * 
     * @return url to editPatients page if any error occured, else redirect to page showing all patients
     */
    @RequestMapping(value = "/editPatient", method = RequestMethod.POST)
    public String saveEditPatient(@ModelAttribute("patient") Patient patient, BindingResult bindingResult,Model model) {
        Patient patient2 = new Patient();
        patient2.setId(patient.getId());
        patient2.setForename(patient.getForename());
        patient2.setSurname(patient.getSurname());
        patient2.setAddress(patient.getAddress());
        patient2.setSex(patient.getSex());
        patient2.setDOB(patient.getDOB()); 
        patient2.setDiagnosis(patient.getDiagnosis());
        patient2.setSurgery(patient.getSurgery());
        patient2.setTransplant(patient.getTransplant());
        patient2.setLocal_hospital(patient.getLocal_hospital());
        patient2.setEmail(patient.getEmail());
        patient2.setPhone(patient.getPhone());
        patient2.setComments(patient.getComments());
        if (bindingResult.hasErrors()) {
            return "editPatients";
        }
        try {
            patientService.createPatient(patient2);
        } catch (Exception e) {
            return "editPatients";
        }
        return "redirect:/patients";
    }

    /**
     * Delete the specific patient by referencing the ID
     * @param id -- The id of the patient to be deleted
     * 
     * @return editPatient page if any error occured, else redirect to page showing all patients
     */
    @RequestMapping(value = "editPatient/deletePatient/{id}", method = RequestMethod.GET)
    public String deletePatient(@PathVariable("id") String id){
        try{
            patientService.deletePatient(Integer.parseInt(id));
        } catch (Exception e){
            return "editPatient";
        }

        return "redirect:/patients";
    }


    /**
     * Get all the patients
     * @param model
     * 
     * @return Page containing all the patients
     */
    @GetMapping("/patients")
    public String getAllPatients(Model model){
        model.addAttribute("patients", this.patientService.getAllPatients());
        return "patients";
    }
}
