package testing;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.AlreadySignedUpException;
import model.Job;
import model.MinimumDaysException;
import model.ScheduleConflictException;
import model.Volunteer;
	 
/**
 * Tests important methods in Volunteer to ensure functionality, and to implicitly test addJob.
 *
 *@author Kai Stansfield
 *@version February 10, 2018
 */
class VolunteerTest {
	static int NUMBER_OF_DAYS_TO_SIGN_UP = 2;

	static Volunteer volunteerDoesntMatter;
	
	static Job wayAfter;
	static Job justOnTheLimit;
	static Job pastLimit;
	
	static Job CurrentJob;
	static Job startsDuringCurrent;
	static Job endsDuringCurrent;
	static Job noConflicts;
	
	@BeforeAll
	public static void setup() {
	    volunteerDoesntMatter = new Volunteer("Kai", "Stansfield");
	    // DM = Doesn't matter -- isMoreThanTwoDays testers.
	    wayAfter = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
	            NUMBER_OF_DAYS_TO_SIGN_UP + 15), 
	            LocalDate.now().plusDays(NUMBER_OF_DAYS_TO_SIGN_UP + 17));
	    justOnTheLimit = new Job("DM", "DM", "DM",
	            LocalDate.now().plusDays(NUMBER_OF_DAYS_TO_SIGN_UP), 
	            LocalDate.now().plusDays(NUMBER_OF_DAYS_TO_SIGN_UP + 2));
	    pastLimit = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
	            NUMBER_OF_DAYS_TO_SIGN_UP - 1),
	            LocalDate.now().plusDays(NUMBER_OF_DAYS_TO_SIGN_UP));
	    // -- isNoScedhuleConflicts testers.
	    CurrentJob = new Job("DM", "DM", "DM", LocalDate.now().plusDays(2),
	            LocalDate.now().plusDays(4));
	    try {
            volunteerDoesntMatter.addJob(CurrentJob);
        } catch (AlreadySignedUpException | MinimumDaysException
                        | ScheduleConflictException e) {
            // No code because we know it won't fail, in this instance.
        }
	    
	    startsDuringCurrent = new Job("DM", "DM", "DM",
	            LocalDate.now().plusDays(3), LocalDate.now().plusDays(5));
	    endsDuringCurrent = new Job("DM", "DM", "DM",
	            LocalDate.now().minusDays(1), LocalDate.now().plusDays(3));
	    noConflicts = new Job("DM", "DM", "DM",
	            LocalDate.now().plusDays(5), LocalDate.now().plusDays(7));
	}
	
	@Test
	public void isMoreThanTwoDays_wayAfter_True() {
		assertTrue(volunteerDoesntMatter.isMoreThanMinimumDays(wayAfter));
	}
	
	@Test
	public void isMoreThanTwoDays_justOnTheLimit_True() {
		assertTrue(volunteerDoesntMatter.isMoreThanMinimumDays(justOnTheLimit));
	}
	
	@Test
	public void isMoreThanTwoDays_pastLimit_False() {
		assertFalse(volunteerDoesntMatter.isMoreThanMinimumDays(pastLimit));
	}

	@Test
	public void isNoScheduleConflicts_startsDuringCurrent_False() {
	    
	    assertFalse(volunteerDoesntMatter.isNoScheduleConflicts(
	                    startsDuringCurrent));
	}
	
	@Test
    public void isNoScheduleConflicts_endsDuringCurrent_False() {
	    
	    assertFalse(volunteerDoesntMatter.isNoScheduleConflicts(
                        endsDuringCurrent));
    }
	
	@Test
	public void isNoScheduleConflicts_noConflicts_True() {
	    assertTrue(volunteerDoesntMatter.isNoScheduleConflicts(noConflicts));
	}
}
