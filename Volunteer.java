package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 * This class represents a user in the Urban Parks System. A volunteer will be able to sign up for jobs, cancel jobs,
 * and view jobs that they would like to possibly sign up for.
 * @author Kai Stansfield
 * @version February 4, 2018
 */
public class Volunteer {
	/**
	 * The minimum number of days between the current day and the day a job is set to be.
	 */
	int NUMBER_OF_DAYS_TO_SIGN_UP = 2;

	/**
	 * The full name of the volunteer.
	 */
	private String myName;
	
	/**
	 * The email of the volunteer.
	 */
	private String myEmail;

	/**
	 * Currently an empty parameter constructor that sets dummy instance variables for the purposes of testing.
	 */
	public Volunteer() {
		this.myName = "Testee Name";
		this.myEmail = "Testee@test.gov";
	}

	/**
	 * This method returns true if the candidate job is more than or equal to two days away from todays date,
	 * false otherwise.
	 * 
	 * @param theCandidate The job the volunteer would like to sign up for.
	 * @return Boolean if the time between now and the job's date is validate.
	 */
	public boolean isMoreThanTwoDays(Job theCandidate) {
		boolean isGood = true;
		LocalDate currentDate = LocalDate.now();
		
		long timeBetween = ChronoUnit.DAYS.between(currentDate, theCandidate.getDate());
		
		if (timeBetween < NUMBER_OF_DAYS_TO_SIGN_UP) {
			isGood = false;
		}
		return isGood;
	}
}
