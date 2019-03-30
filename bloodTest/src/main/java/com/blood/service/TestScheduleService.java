package com.blood.service;

import java.util.*;

import com.blood.dao.TestScheduleDAO;
import com.blood.pojo.Patient;
import com.blood.pojo.TestSchedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
/**
 * This class provides some methods for accessing the test schedule at DB
 */
@Service
public class TestScheduleService {
    @Autowired
    TestScheduleDAO testScheduleDAO;

    /**
     * Find the test schedule by ID
     * @param id -- id of the test schedule
     * @return test schedule returned
     */
    public TestSchedule findById(int id) {
        return testScheduleDAO.findById(id);
    }

    /**
     * Find the test schedule by patient
     * @param patient -- the patient referenced
     * @return test schedule of that result
     */
    public TestSchedule findByPatient(Patient patient) {
        return testScheduleDAO.findByPatient(patient);
    }

    /**
     * Delete the test with that id
     * @param id -- id of the test schedule
     */
    public void deleteTest(int id) {
        testScheduleDAO.delete(testScheduleDAO.findById(id));
    }

    /*
     * public TestSchedule findByIdPatient(int idpatient) { return
     * testScheduleDAO.findByIdPatient(idpatient); }
     * 
     * public TestSchedule findByIdLabel(int idlabel) { return
     * testScheduleDAO.findByIdLabel(idlabel); }
     */

    /**
     * Find by test completed
     * @param complete -- a boolean that describe test completed or not
     * @return completed test schedule 
     */
    public TestSchedule findByCompleted(boolean complete) {
        return testScheduleDAO.findByCompleted(complete);
    }
    
    /**
     * Save the test schedule to DB
     * @param testSchedule -- test schedule to be saved
     * @return saved test schedule
     */
    public TestSchedule save(TestSchedule testSchedule) {
        testScheduleDAO.save(testSchedule);
        return testSchedule;
    }

    /**
     * Update the test schedule label
     * @param testSchedule -- test schedule to be updated
     */
    public void updateLabel(TestSchedule testSchedule) {
        testScheduleDAO.save(testSchedule);
    }

    /**
     * Delete the test schedule by id
     * @param id -- id of the test schedule
     */
    public void deletePatient(int id) {
        testScheduleDAO.delete(testScheduleDAO.findById(id));
    }

    /**
     * Get all test schedule
     * @return List of all test schedule
     */
    public List<TestSchedule> getAllTestSchedule() {
        List<TestSchedule> testSchedule = new ArrayList<>();
        this.testScheduleDAO.findAll().forEach(testSchedule::add);
        return testSchedule;
    }

    /**
     * Shift the time of test schedule
     */
    public void timeShif() {
        Date date = new Date();
        List<TestSchedule> testSchedules = testScheduleDAO.findAll();
        for (TestSchedule testSchedule : testSchedules) {
            long diff = testSchedule.getDate().getTime() - date.getTime();
            if ((TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS) < 0)) {
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date);
                calendar.add(calendar.DATE, 7);
                date = calendar.getTime();
                testSchedule.setMissTest(testSchedule.getMissTest() + 1);
                if (testSchedule.getMissTest() > 1) {
                    testSchedule.setIdlabel("badge red");
                }
                testSchedule.setDate(date);
                testSchedule.setNotified(false);
                testScheduleDAO.save(testSchedule);
            }
        }
    }

    /**
     * Update the test schedule
     * @param tSchedule -- test schedule to be updated
     * @param id, location , date , completed. commet. notified, idpatient, idlabel -- To be set to test schedule
     */
    public void updateTestSchedule(TestSchedule tSchedule, int id, String location, Date date, boolean completed,
            String commet, boolean notified, int idpatient, String idlabel) {
        tSchedule.setId(id);
        tSchedule.setLocation(location);
        tSchedule.setDate(date);
        tSchedule.setCompleted(completed);
        tSchedule.setCommet(commet);
        tSchedule.setNotified(notified);
        // tSchedule.setIdpatient(idpatient);
        tSchedule.setIdlabel(idlabel);
        testScheduleDAO.save(tSchedule);
        // TODO:REST
    }

    /**
     * Find all test schedule
     * @return List of all test schedule
     */
    public List<TestSchedule> findAll() {
        return testScheduleDAO.findAll();
    }

}
