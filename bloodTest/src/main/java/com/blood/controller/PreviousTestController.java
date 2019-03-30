package com.blood.controller;

import com.blood.pojo.Patient;
import com.blood.service.MailService;
import com.blood.service.PreviousTestService;

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
 * This class provide the HTTP response service for the previous test of the patient
 */
@Controller
public class PreviousTestController {
    @Autowired
    private PreviousTestService previousTestService;

    @Autowired
    public PreviousTestController(PreviousTestService previousTestService) {
        super();
        this.previousTestService = previousTestService;
    }

    /**
     * Get all test schedule
     * @param model
     * 
     * @return url of previousTest page
     */
    @GetMapping("/previousTests")
    public String getAllTestSchedule(Model model) {
        model.addAttribute("previousTests", this.previousTestService.getAllPreviousTest());
        return "previousTests";
    }

}
