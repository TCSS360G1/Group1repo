package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.Job;
import model.Volunteer;
	 

class VolunteerTest {
	
	int NUMBER_OF_DAYS_TO_SIGN_UP = 2;

	Volunteer VolunteerDoesntMatter = new Volunteer("Kai Stansfield",
	                "kai.n.stansfield@gmail.com", "XXX-XXX-XXXX");
	
	Job wayAfter = new Job(LocalDate.now().plusDays(
	                NUMBER_OF_DAYS_TO_SIGN_UP + 15), 
	                LocalDate.now().plusDays(NUMBER_OF_DAYS_TO_SIGN_UP + 17));
	
	Job justOnTheLimit = new Job(LocalDate.now().plusDays(
	                NUMBER_OF_DAYS_TO_SIGN_UP), 
	                LocalDate.now().plusDays(NUMBER_OF_DAYS_TO_SIGN_UP + 2));
	
	Job pastLimit = new Job(LocalDate.now().plusDays(
	                NUMBER_OF_DAYS_TO_SIGN_UP - 1),
	                LocalDate.now().plusDays(NUMBER_OF_DAYS_TO_SIGN_UP));
	
	@Test
	public void isMoreThanTwoDays_wayAfter_True() {
		assertTrue(VolunteerDoesntMatter.isMoreThanMinimumDays(wayAfter));
	}
	
	@Test
	public void isMoreThanTwoDays_justOnTheLimit_True() {
		assertTrue(VolunteerDoesntMatter.isMoreThanMinimumDays(justOnTheLimit));
	}
	
	@Test
	public void isMoreThanTwoDays_pastLimit_False() {
		assertFalse(VolunteerDoesntMatter.isMoreThanMinimumDays(pastLimit));
	}

}
