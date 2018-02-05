package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.Job;
import model.Volunteer;
	 

class VolunteerTest {
	/**
	 * The default minimum days between the current day and job that should be signed up for.
	 */
	int NUMBER_OF_DAYS_TO_SIGN_UP = 2;

	/**
	 * A volunteer object. It has no effect on the job eligibility.
	 */
	Volunteer VolunteerDoesntMatter = new Volunteer();
	
	/**
	 * This job will have a date way after the current day. (more than the current day).
	 */
	Job wayAfter = new Job(LocalDate.now().plusDays(NUMBER_OF_DAYS_TO_SIGN_UP + 15));
	
	/**
	 * This job will have a date that is exactly the minimum number of days to sign up.
	 */
	Job justOnTheLimit = new Job(LocalDate.now().plusDays(NUMBER_OF_DAYS_TO_SIGN_UP));
	
	/**
	 * This job will have a date that is below the minimum sign up time.
	 */
	Job pastLimit = new Job(LocalDate.now().plusDays(NUMBER_OF_DAYS_TO_SIGN_UP - 1));
	
	/**
	 * Tests for if the way after is working. Likely the most common situation.
	 */
	@Test
	public void isMoreThanTwoDays_wayAfter_True() {
		assertTrue(VolunteerDoesntMatter.isMoreThanTwoDays(wayAfter));
	}
	
	/**
	 * Tests for the minimum day value. Should return true.
	 */
	@Test
	public void isMoreThanTwoDays_justOnTheLimit_True() {
		assertTrue(VolunteerDoesntMatter.isMoreThanTwoDays(justOnTheLimit));
	}
	
	/**
	 * Tests if dates less than the minimum days can't be signed up for.
	 */
	@Test
	public void isMoreThanTwoDays_pastLimit_False() {
		assertFalse(VolunteerDoesntMatter.isMoreThanTwoDays(pastLimit));
	}

}
