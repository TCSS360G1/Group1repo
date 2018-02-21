package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import model.ActiveJobException;
import model.AlreadySignedUpException;
import model.Job;
import model.MinimumDaysException;
import model.ScheduleConflictException;
import model.TooCloseException;
import model.Volunteer;
	 
/**
 * Tests important methods in Volunteer to ensure functionality,
 * and to implicitly test addJob.
 *
 * @author Kai Stansfield
 * @version February 11, 2018
 */
public class VolunteerTest {

	static Volunteer volunteerDoesntMatter;
	static int myMinDaysToSignUp;
	static int myMinDaysToUnvolunteer;
	
	static Job wayAfter;
	static Job justOnTheLimit;
	static Job pastLimit;
	
	static Job CurrentJob;
	static Job startsDuringCurrent;
	static Job endsDuringCurrent;
	static Job noConflicts;
	
	static Job tooCloseToUnvolunteer;
	static Job activeJob;
	
	@Before
	public void setup() {
	    volunteerDoesntMatter = new Volunteer("Kai", "Stansfield");
	    myMinDaysToSignUp = Volunteer.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER;
	    myMinDaysToUnvolunteer = 
	                    Volunteer.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER;
	    // DM = Doesn't matter -- isMoreThanTwoDays testers.
	    wayAfter = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
	            myMinDaysToSignUp + 15), 
	            LocalDate.now().plusDays(myMinDaysToSignUp + 17));
	    justOnTheLimit = new Job("DM", "DM", "DM",
	            LocalDate.now().plusDays(myMinDaysToSignUp), 
	            LocalDate.now().plusDays(myMinDaysToSignUp + 3));
	    pastLimit = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
	            myMinDaysToSignUp - 1),
	            LocalDate.now().plusDays(myMinDaysToSignUp));
	    // -- isNoScedhuleConflicts testers.
	    CurrentJob = new Job("DM", "DM", "DM", LocalDate.now().plusDays(3),
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
	    
	    // -- isActiveJob tester.
	    activeJob = new Job("DM", "DM", "DM", LocalDate.now().minusDays(1),
	                    LocalDate.now().plusDays(1));
	    
	    // -- isTooClose tester.
	    tooCloseToUnvolunteer = new Job("DM", "DM", "DM",
	                    LocalDate.now().plusDays(myMinDaysToUnvolunteer - 1),
	                    LocalDate.now().plusDays(myMinDaysToUnvolunteer + 1));
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
	
	@Test
	public void isActiveJob_ActiveJob_True() {
	    assertTrue(volunteerDoesntMatter.isActiveJob(activeJob));
	}
	
	@Test
	public void isActiveJob_NotActiveJob_Falses() {
	    assertFalse(volunteerDoesntMatter.isActiveJob(wayAfter));
	}
	
	@Test
	public void isTooClose_JobTooClose_True() {
	    assertTrue(volunteerDoesntMatter.isTooClose(tooCloseToUnvolunteer));
	}
	
	@Test
    public void isTooClose_JobNotTooClose_False() {
        assertFalse(volunteerDoesntMatter.isTooClose(wayAfter));
    }
	
	@Test
	public void removeJob_JobTooClose_False() {
	    try {
            volunteerDoesntMatter.removeJob(tooCloseToUnvolunteer);
        } catch (TooCloseException e) {
            assertFalse(false);
        } catch (ActiveJobException e) {
            assertFalse(true);
        }
	}
	
	@Test
    public void removeJob_ActiveJob_False() {
	    try {
            volunteerDoesntMatter.removeJob(activeJob);
        } catch (TooCloseException e) {
            assertFalse(true);
        } catch (ActiveJobException e) {
            assertFalse(false);
        }
    }
	
	@Test
    public void removeJob_afterMinimum_True() {
	    try {
            volunteerDoesntMatter.removeJob(wayAfter);
        } catch (TooCloseException e) {
            assertFalse(true);
        } catch (ActiveJobException e) {
            assertFalse(true);
        }
        assertTrue(true);
    }
	
	@Test
    public void removeJob_OnMinimum_True() {
	    try {
            volunteerDoesntMatter.removeJob(justOnTheLimit);
        } catch (TooCloseException e) {
            assertFalse(true);
        } catch (ActiveJobException e) {
            assertFalse(true);
        }
        assertTrue(true);
    }
}