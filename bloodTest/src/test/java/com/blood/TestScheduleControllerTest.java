package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.blood.controller.TestScheduleController;

import org.junit.Test;

public class TestScheduleControllerTest {
    @Test
    public void testDateformatter() throws ParseException {
        TestScheduleController test = new TestScheduleController();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = "2019-12-12 11:11:00";
        assertEquals(test.formatDate("2019-12-12T11:11"), formatter.parse(datetime));
    }

    @Test
    public void testDateReverseToString() throws ParseException {
        TestScheduleController test = new TestScheduleController();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = "2019-12-12 11:11:00";
        Date data = formatter.parse(datetime);
        assertEquals( test.dateToString(data),"2019-12-12T11:11");
    }
    


}