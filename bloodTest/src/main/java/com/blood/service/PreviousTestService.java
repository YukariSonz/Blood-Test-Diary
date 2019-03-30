package com.blood.service;

import java.util.*;

import com.blood.dao.PreviousTestDAO;
import com.blood.pojo.PreviousTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * This class provides backend logic for previous test entities
 */
@Service
public class PreviousTestService {
    @Autowired
    PreviousTestDAO previousTestDAO;

    /**
     * Find the previous test by ID
     * @param id -- id of the previous test
     * @return previous test returend
     */
    public PreviousTest findById(int id) {
        return previousTestDAO.findById(id);
    }

    /**
     * Save the previous test
     * @param previousTest -- previous test to be saved to DB
     */
    public PreviousTest save(PreviousTest previousTest) {
        previousTestDAO.save(previousTest);
        return previousTest;
    }

    /**
     * Get all previous test
     * @return List of all previous test
     */
    public List<PreviousTest> getAllPreviousTest() {
        List<PreviousTest> previousTest = new ArrayList<>();
        this.previousTestDAO.findAll().forEach(previousTest::add);
        return previousTest;
    }

    /**
     * Get all previous test
     * @return List of all previous test
     */
    public List<PreviousTest> findAll() {
        return previousTestDAO.findAll();
    }

    public void deletePreviousTest(int id){
        previousTestDAO.delete(previousTestDAO.findById(id));
    }

}