package com.blood.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This class provides the HTTP Response service for test schedule of patients
 * And test scheduling for patients
 */
@Controller
public class TestScheduleController {
  @Autowired
  private TestScheduleService tScheduleService;
  @Autowired
  private PatientService patientService;

  @Autowired
  private MailService mailService;

  /**
   * Get the test of the specific patient with that ID
   * @param id
   * @param model 
   * 
   * @return url of the current page
   */
  @RequestMapping(value = "/addTest/{id}", method = RequestMethod.GET)
  public String getAddTest(@PathVariable("id") String id, Model model) {
    Patient patient = this.patientService.findById(Integer.parseInt(id));
    model.addAttribute("patient", patient);
    model.addAttribute("test", new TestSchedule());

    return "addTest";
  }

  /**
   * Convert the date to String
   * @param date -- date to be converted
   * 
   * @return dateString -- converted data in String
   */
  public String dateToString(Date date) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = formatter.format(date);
    String[] dateArr = dateString.split(" ");
    String[] dateArr2 = dateArr[1].split(":");
    dateString = dateArr[0] + "T" + dateArr2[0] + ":" + dateArr2[1];
    return dateString;
  }

  /** 
   * Retrieve Edit Test page, and id for the test
   * @return url of editTest
   */
  @RequestMapping(value = "/editTest/{id}", method = RequestMethod.GET)
  public String getTestsById(@PathVariable("id") String id, Model model) {
    TestSchedule testSchedule = this.tScheduleService.findById(Integer.parseInt(id));
    Patient patient = testSchedule.getPatient();
    patient.setDOB(dateToString(testSchedule.getDate()));
    model.addAttribute("testEdit", testSchedule);
    model.addAttribute("patient", patient);

    return "editTest";
  }
   /**
    * Edit test function
    *
    * @param patient
    * @param test
    * @param bindingResult
    * @param model
    *
    * @return URL -- current page if any error occured, else redirect to home page
    */
  @RequestMapping(value = "/editTest", method = RequestMethod.POST)
  public String editTest(@ModelAttribute("patient") Patient patient, @ModelAttribute("testEdit") TestSchedule test,
      BindingResult bindingResult, Model model) throws ParseException {
    Patient thePatient = patientService.findById(patient.getId());

    TestSchedule newTest = new TestSchedule(test.getLocation(), formatDate(patient.getDOB()), test.isCompleted(),
        test.getCommet(), test.isNotified(), test.getIdlabel(), test.getMissTest());
    newTest.setPatient(thePatient);
    newTest.setId(test.getId());
    // if (tScheduleService.findByPatient(thePatient) != null) {
    // newTest.setId(tScheduleService.findByPatient(thePatient).getId());
    // }
    // if (bindingResult.hasErrors()) {
    // return "editPatients";
    // }
    try {
      tScheduleService.save(newTest);
    } catch (Exception e) {
      return "editTest";
    }
    return "redirect:/home";
  }

  /**
   * Delete the test of a patient with specified ID
   * 
   * @param id -- id of the patient
   * 
   * @return url -- to current page if any error occured, else redirect to home page
   */
  @RequestMapping(value = "editTest/deleteTest/{id}", method = RequestMethod.GET)
  public String deletePatient(@PathVariable("id") String id) {
    try {
      tScheduleService.deleteTest(Integer.parseInt(id));
    } catch (Exception e) {
      return "editTest";
    }

    return "redirect:/home";
  }

  /**
   * Format the date to yyyy-MM-dd HH:mm:ss
   * @param date -- date to be formated
   * @return datetime -- formated date 
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
   * Add the test of a patient
   * @param patient -- the patient with this test
   * @param test -- the test of the patient
   * @param bindingResult
   * @param model
   * @return URL String -- current page if any error occured, else redirect to home page 
   */
  @RequestMapping(value = "/addTest", method = RequestMethod.POST)
  public String addTest(@ModelAttribute("patient") Patient patient, @ModelAttribute("test") TestSchedule test,
      BindingResult bindingResult, Model model) throws ParseException {

    Patient thePatient = patientService.findById(patient.getId());

    TestSchedule newTest = new TestSchedule(test.getLocation(), formatDate(patient.getDOB()), test.isCompleted(),
        test.getCommet(), test.isNotified(), test.getIdlabel(), 0);
    newTest.setPatient(thePatient);
    // if (tScheduleService.findByPatient(thePatient) != null) {
    // newTest.setId(tScheduleService.findByPatient(thePatient).getId());
    // }
    // if (bindingResult.hasErrors()) {
    // return "editPatients";
    // }
    try {
      tScheduleService.save(newTest);
    } catch (Exception e) {
      return "addTest";
    }
    return "redirect:/home";
  }

  private static Patient patient;

  private final String COLOR_RED = "badge red";
  private final String COLOR_GREEN = "badge green";
  private final String COLOR_ORANGE = "badge orange";
  private final String COLOR_WHITE = "badge white";
  private final String URGENT = "Mark Urgent";
  private final String MONITOR = "Mark Monitor";
  private final String CRITICAL = "Mark Critical";
  private final String OPA = "Mark OPA";


  /**
   * Get all the test schedule
   * @param model
   * 
   * @return URL String of home page
   */
  @GetMapping("/home")
  public String getAllTestSchedule(Model model) {
    model.addAttribute("testSchedules", this.tScheduleService.getAllTestSchedule());
    model.addAttribute("testEdit", new TestSchedule());
    tScheduleService.timeShif();
    mailService.sendNotification(); // <-- TO BE ENABLE (when you enable say tthe group)
    return "home";
  }

  /**
   * Edit the test schedule email
   * @param model
   * @return url of the current page
   */
  @GetMapping("/email")
  public String getEmailTest(Model model) {
    model.addAttribute("tests", this.tScheduleService.getAllTestSchedule());
    return "email";
  }

  /**
   * Edit the label of the patient by the urgent level of the patient
   * @param checkboxValue --
   * @param submitBtn -- 
   * @param model -- 
   * 
   * @return URL String -- redirect to home page
   */
  @RequestMapping(value = "/editLabel", method = RequestMethod.POST)
  public String editLabel(@RequestParam(value = "checkboxName", required = false) String[] checkboxValue,
      @RequestParam(value = "submitBtn", required = false) String submitBtn, Model model) {
    try {
      //If the urgent level is urgent, mark it to orange
      if (submitBtn.equals(URGENT) && checkboxValue.length > 0) {
        for (String id : checkboxValue) {
          TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
          ts.setIdlabel(COLOR_ORANGE);
          tScheduleService.updateLabel(ts);
        }
        //If the urgent level is monitor, mark it to green
      } else if (submitBtn.equals(MONITOR) && checkboxValue.length > 0) {
        for (String id : checkboxValue) {
          TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
          ts.setIdlabel(COLOR_GREEN);
          tScheduleService.updateLabel(ts);
        }
        //If the urgent level is critical, mark it to red
      } else if (submitBtn.equals(CRITICAL) && checkboxValue.length > 0) {
        for (String id : checkboxValue) {
          TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
          ts.setIdlabel(COLOR_RED);
          tScheduleService.updateLabel(ts);
        }
        //For all other urgent level, mark it to white
      } else if (submitBtn.equals(OPA) && checkboxValue.length > 0) {
        for (String id : checkboxValue) {
          TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
          ts.setIdlabel(COLOR_WHITE);
          tScheduleService.updateLabel(ts);
        }
      }

    } catch (Exception e) {
      return "redirect:/home";
    }

    return "redirect:/home";
  }

  

}