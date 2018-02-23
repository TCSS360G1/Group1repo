package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import model.Job;
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
	
	@Before
	public void setup() {
	    myVolunteerDoesntMatter = new Volunteer("Kai", "Stansfield");
	    myMinDaysToSignUp = Job.MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP;
	    myMinDaysToUnvolunteer = Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER;
	    //DM = Doesnt matter.
	    myFirstJob = new Job("DM", "DM", "DM",
	                    LocalDate.now().plusDays(myMinDaysToSignUp + 15), 
	                    LocalDate.now().plusDays(myMinDaysToSignUp + 17));
	    mySecondJob = new Job("DM", "DM", "DM", 
	                    LocalDate.now().plusDays(myMinDaysToSignUp + 15),
	                    LocalDate.now().plusDays(myMinDaysToSignUp + 17));
	    myVolunteerDoesntMatter.addJob(myFirstJob);
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