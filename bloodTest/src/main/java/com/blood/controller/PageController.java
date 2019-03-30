package com.blood.controller;

import com.blood.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class controlls the pages
 */
@Controller
public class PageController {
    
    /**
     * Get the home page
     * @return redirection to home page
     */
    @GetMapping(value="/")
    public String index(){
        return "redirect:home";
    }
   
    /*@GetMapping(value="/home")
    public String home(){
        return "/home";
    }*/

    /**
     * Get the registration page
     * @return url to registration page
     */
    @GetMapping(value="/registers")
    public String registers(){
        return "/registers";
    }
    
    /**
     * Get the patient edit page
     * @return url to edit page
     */
    @GetMapping(value="/editPatients")
    public String editPatients(){
        return "/editPatients";
    }

    /**
     * Get the add test page
     * @return url to add test page
     */
    @GetMapping(value="/addTest")
    public String addTests(){
        return "/addTests";
    }

    /*@GetMapping(value="/AddPatient")
    public String addPattien(){
        return "/AddPatient";
    }*/

    // @GetMapping(value="/email")
    // public String email(){
    //     return "/email";
    // }

   /* @GetMapping(value="/hospitals")
    public String hospitals(){
        return "/hospitals";
    }*/
    
   /* @GetMapping(value="/AddHospital")
    public String addhospitals(){
        return "/AddHospital";
    }*/

}
