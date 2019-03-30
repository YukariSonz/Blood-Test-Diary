package com.blood.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.MimeBodyPart;

import com.blood.pojo.Patient;
import com.blood.pojo.TestSchedule;
import com.blood.service.MailService;
import com.blood.service.PatientService;
import com.blood.service.TestScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class provides the HTTP Response for mail service
 */

@Controller
public class MailController<StandardMultipartFile> {
    @Autowired
    private TestScheduleService tScheduleService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private MailService mailService;


    /**
     * Send the notification to the patient
     */
    @PostMapping("SendNotification")
    public void send() throws Exception {
        mailService.sendNotification();
    }

    /**
     * 
     */
    @PostMapping("sendDeleteEmail")
    public Object sendDelete(Patient patient) throws Exception {
        boolean res = mailService.sendDeleteResult(patient);
        if (res == true) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Convert MultipartFile into File
     * @param MultipartFile file
     * @return File
     */
    public File convert(MultipartFile file) {
        try {
            File convFile = new File(file.getOriginalFilename());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            return convFile;
        } catch (IOException e) {
            return null;
        }

    }

    /** 
     * Send Result (send attachment)
     * @param id
     * @param model
     * @return 
     */
    @RequestMapping(value = "/sendTestResult/{id}", method = RequestMethod.GET)
    public String sendResultById(@PathVariable("id") String id, Model model) {
        TestSchedule testSchedule = this.tScheduleService.findById(Integer.parseInt(id));
        Patient patient = testSchedule.getPatient();
        patient.setDOB(dateToString(testSchedule.getDate()));
        model.addAttribute("test", testSchedule);
        model.addAttribute("patient", patient);

        return "sendTestResult";
    }

    /**
     * @param model
     * @return 
     */
    @GetMapping("/sendTestResult")
    public String getResult(Model model) {
        // model.addAttribute("tests", this.tScheduleService.getAllTestSchedule());
        return "sendTestResult";
    }

    /**
     * Send the result file
     * @param file -- The result file
     * @param patient
     * @param test
     * @param bindingResult
     * @param model 
     * 
     * @return redirection to current page if any error occured, else redirct to home page
     */
    @RequestMapping(value = "/sendTestResult", method = RequestMethod.POST)
    public String editLabel(@RequestParam(value = "file", required = false) MultipartFile file,
            @ModelAttribute("patient") Patient patient, 
            @ModelAttribute("test") TestSchedule test,
            @RequestParam(value = "comments", required = false) String comments,
            BindingResult bindingResult, Model model) {
        try {
            // System.out.println("Upload PDF" + file.getOriginalFilename());
            // System.out.println(patient.getId() + " " + test.getId());
            // System.out.println("Upload PDF" +
            // file.getResource().getFile().getAbsolutePath());
            File fl = convert(file);
            // System.out.println(fl.getAbsolutePath());
            mailService.sendResult(fl.getAbsolutePath(), patientService.findById(patient.getId()),
                    tScheduleService.findById(test.getId()),comments  );

        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/sendTestResult/" + test.getId();
        }
        return "redirect:/home";
    }

    /**
     * Send Manual Notification with attachment
     * 
     * @param String id
     * @param Model  model
     * @return String
     */
    @RequestMapping(value = "/sendManualReminder/{id}", method = RequestMethod.GET)
    public String manualNotificationById(@PathVariable("id") String id, Model model) {
        // TestSchedule testSchedule =
        // this.tScheduleService.findById(Integer.parseInt(id));
        Patient patient = this.patientService.findById(Integer.parseInt(id));
        // patient.setDOB(dateToString(testSchedule.getDate()));
        // model.addAttribute("test", testSchedule);
        model.addAttribute("patient", patient);

        return "sendManualReminder";
    }

    @GetMapping("/sendManualReminder")
    public String sendManualReminder(Model model) {
        // model.addAttribute("tests", this.tScheduleService.getAllTestSchedule());
        return "sendManualReminder";
    }

    /**
     * Send Manual Notification with attachment
     * 
     * @param String  dateTime
     * @param String  location
     * @param String  comments
     * @param Patient patient, BindingResult bindingResult, Model model
     * 
     * @return String
     */
    @RequestMapping(value = "/sendManualReminder", method = RequestMethod.POST)
    public String sendManualReminder(@RequestParam(value = "dateTime", required = false) String dateTime,
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "comments", required = false) String comments,
            @ModelAttribute("patient") Patient patient, BindingResult bindingResult, Model model) {
        try {
            // System.out.println("Upload PDF" + file.getOriginalFilename());

            System.out.println(dateToString(formatDate(patient.getDOB())) + " " + location + " " + comments);
            System.out.println(patient.getId());

            mailService.sendManualReminder(this.patientService.findById(patient.getId()),
                    dateToString(formatDate(patient.getDOB())), location, comments);

        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/sendManualReminder/" + patient.getId();
        }
        return "redirect:/home";
    }

    /**
     * Format the date of a string
     * 
     * @param: String date
     * @return Date
     */
    public Date formatDate(String date) throws ParseException {
        String[] dates = date.split("T");
        date = dates[0] + " " + dates[1] + ":00";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date datetime = formatter.parse(date);
        return datetime;
    }

    /**
     * Convert Date to String
     * 
     * @param: Date date
     * @return String
     */
    public String dateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        String[] dateArr = dateString.split(" ");
        String[] dateArr2 = dateArr[1].split(":");
        dateString = dateArr[0] + "T" + dateArr2[0] + ":" + dateArr2[1];
        return dateString;
    }

}
