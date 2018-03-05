package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import model.AlreadySignedUpException;
import model.Job;
import model.MinimumDaysException;
import model.ScheduleConflictException;
import model.Volunteer;

/**
 * Tests that addJobs functions, and that isNotSignedUp is functional.
 *
 * @author Kai Stansfield
 * @version February 11, 2018
 */
public class VolunteerTest {
	static Volunteer myVolunteerDoesntMatter;

	static int myMinDaysToSignUp;
	static int myMinDaysToUnvolunteer;

	static Job myFirstJob;
	static Job mySecondJob;

	// isNoScheduleConflicts
	private static Job testAgainstJob;
	private static Job badStart;
	private static Job badEnd;
	private static Job noConflicts;

	@Before
	public void setup() throws AlreadySignedUpException, MinimumDaysException,
			ScheduleConflictException {
		myVolunteerDoesntMatter = new Volunteer("Kai", "Stansfield");
		myMinDaysToSignUp = Job.MINIMUM_NUMBER_OF_DAYS_TO_VOLUNTEER;
		myMinDaysToUnvolunteer = Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER;
		// DM = Doesnt matter.
		myFirstJob = new Job("DM", "DM", "DM",
				LocalDate.now().plusDays(myMinDaysToSignUp + 15),
				LocalDate.now().plusDays(myMinDaysToSignUp + 17));
		mySecondJob = new Job("DM", "DM", "DM",
				LocalDate.now().plusDays(myMinDaysToSignUp + 15),
				LocalDate.now().plusDays(myMinDaysToSignUp + 17));
		myVolunteerDoesntMatter.addJob(myFirstJob);

		testAgainstJob = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
				Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 5),
				LocalDate.now().plusDays(
						Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 8));
		badStart = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
				Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 7),
				LocalDate.now().plusDays(
						Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 10));
		badEnd = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
				Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 3),
				LocalDate.now().plusDays(
						Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 6));
		noConflicts = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
				Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 9),
				LocalDate.now().plusDays(
						Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 12));
	}
	@Test
    public void isGoodStart_startsDuringCurrent_False() {
        assertFalse(testAgainstJob.isGoodStart(badStart));
    }
    
    @Test
    public void isGoodStart_DoesntstartsDuringCurrent_True() {
        assertTrue(testAgainstJob.isGoodStart(noConflicts));
    }
    
    @Test
    public void isGoodEnd_endsDuringCurrent_False() {
        assertFalse(testAgainstJob.isGoodEnd(badEnd));
    }
    
    @Test
    public void isGoodEnd_DoesntendsDuringCurrent_True() {
        assertTrue(testAgainstJob.isGoodEnd(noConflicts));
    }
    
    @Test
    public void isNoScheduleConflicts_noConflicts_True() {
        assertTrue(testAgainstJob.isGoodEnd(noConflicts));
    }
	@Test
	public void isNotSignedUp_SameJob_False() {
		assertFalse(myVolunteerDoesntMatter.isNotSignedUp(myFirstJob));
	}

	@Test
	public void isNotSignedUp_DifferentJob_True() {
		assertTrue(myVolunteerDoesntMatter.isNotSignedUp(mySecondJob));
	}
}