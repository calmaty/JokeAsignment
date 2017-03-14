/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Legendslayer
 */
public class DateFormatterTest {

    public DateFormatterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFormattedDate method, of class DateFormatter.
     */
    @Test
    public void testGetFormattedDate() throws Exception {
        String timeZone = "Europe/Copenhagen";
        Date date = new Date();
        DateFormatter df = new DateFormatter();
        String expResult = df.getFormattedDate(timeZone,date);
        Date time = new Date();
        String dateTimeFormat = "dd MMM yyyy hh:mm aa";
        SimpleDateFormat simpleFormat = new SimpleDateFormat(dateTimeFormat);
        simpleFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        String finalTime = simpleFormat.format(time);
        System.out.println("result : " + finalTime);
        assertEquals(expResult, finalTime);
    }

    /**
     * Test of main method, of class DateFormatter.
     */
//    @Test
//    public void testMain() throws Exception {
//        System.out.println("main");
//        String[] args = null;
//        DateFormatter.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
