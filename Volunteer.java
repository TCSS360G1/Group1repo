package model;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a User in the Urban Parks System. A volunteer will
 * be able to sign up for jobs, cancel jobs, and view jobs that they would
 * like to possibly sign up for.
 * 
 * @author Kai Stansfield
 * @version February 11, 2018
 */
public class Volunteer extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7001992405582133870L;
	/* Fields */
    public static final int MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP = 3;
	private List<Job> myCurrentJobs;

	/**
	 * The constructor for a Volunteer, which extends User,
	 * giving its first name and last name. This User can also
	 * have a list of Jobs they would sign up for.
	 * 
	 * @param theFirstName the first name of the Volunteer User.
	 * @param theLastName the last name of the Volunteer User.
	 */
	public Volunteer(String theFirstName, String theLastName) {
		super(theFirstName, theLastName, "Volunteer");
		this.myCurrentJobs = new ArrayList<Job>();

	}
	
	

	/**
	 * This method checks the start and end jobs of the candidate job to the
	 * jobs that the volunteer is signed up for. Any conflict returns false.
	 * 
	 * @param theCandidate A job that has a potential conflicting
	 * start and end date.
	 * @return true whether there is no conflict, false otherwise.
	 * 
	 */
	public boolean isNoScheduleConflicts(Job theCandidate) {
		boolean isGood = true;

		for (Job aJob : myCurrentJobs) {
			isGood = (isGoodStart(aJob, theCandidate) &&
					isGoodEnd(aJob, theCandidate));
			if (!isGood) {
				break;
			}
		}

		return isGood;
	}

	/**
	 * This method checks whether the Job has a good start time that
	 * a Volunteer can choose to sign up in.
	 * 
	 * @param theCandidate A job that has a potential conflicting
	 * start date.
	 * @return true whether there is no conflict, false otherwise.
	 * 
	 */
	private boolean isGoodStart(Job theCurrent, Job theCandidate) {
		boolean isGood = true;

		long lengthOfCurr = ChronoUnit.DAYS.between(theCurrent.getStartDate(),
				theCurrent.getEndDate());

		long between = ChronoUnit.DAYS.between(theCurrent.getEndDate(),
				theCandidate.getStartDate());

		if (between <= 0 && between >= lengthOfCurr * -1) {
			isGood = false;
		}

		return isGood;
	}

	/**
	 * This method checks whether the Job has a good end time that
	 * a Volunteer can choose to sign up in.
	 * 
	 * @param theCandidate A job that has a potential conflicting
	 * end date.
	 * @return true whether there is no conflict, false otherwise.
	 * 
	 */
	private boolean isGoodEnd(Job theCurrent, Job theCandidate) {
		boolean isGood = true;

		long lengthOfCurr = ChronoUnit.DAYS.between(theCurrent.getStartDate(),
				theCurrent.getEndDate());

		long between = ChronoUnit.DAYS.between(theCurrent.getStartDate(),
				theCandidate.getEndDate());

		if (between >= 0 && between <= lengthOfCurr) {
			isGood = false;
		}

		return isGood;
	}

	/**
	 * This method returns true if the candidate job is more than or equal to
	 * two days away from todays date, false otherwise.
	 * 
	 * @param theCandidate the job the volunteer would like to sign up for.
	 * @return true if the time between now and the job's date is validate.
	 */
	public boolean isMoreThanMinimumDays(Job theCandidate) {
		boolean isGood = true;

		LocalDate currentDate = LocalDate.now();
		long timeBetween = ChronoUnit.DAYS.between(currentDate,
				theCandidate.getStartDate());

		if (timeBetween < MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP) {
			isGood = false;

		}

		return isGood;

	}

	/**
	 * This method checks whether or not they are signed up for a job or not.
	 * 
	 * @param theJob the job to be checked for the Volunteer.
	 * @return true if they are not signed up for the job, false otherwise.
	 */
	public boolean isNotSignedUp(Job theJob) {
		return !myCurrentJobs.contains(theJob);

	}

	/**
	 * Adds a job to the volunteer's current jobs if the job isn't already
	 * signed up for.
	 * 
	 * @param theJob a job that may already be in the current jobs.
	 * @throws exceptions based on what failed in adding the job.
	 */

	public void addJob(Job theJob) throws AlreadySignedUpException,
			MinimumDaysException, ScheduleConflictException {

		if (!this.isNotSignedUp(theJob)) {
			throw new AlreadySignedUpException();
		}

		if (!this.isMoreThanMinimumDays(theJob)) {
			throw new MinimumDaysException();
		}

		if (!this.isNoScheduleConflicts(theJob)) {
			throw new ScheduleConflictException();
		}

		myCurrentJobs.add(theJob);
	}

	/**
	 * Removes the Job that the Volunteer chooses to take off.
	 * 
	 * @param theJob the job that the Volunteer wants to remove.
	 */
	public void removeJob(Job theJob) {
		myCurrentJobs.remove(theJob);

	}
	
	/**
	 * The list of Jobs that the Volunteer has signed up for.
	 * 
	 * @return the list of Jobs currently signed up for Volunteer.
	 */
	public ArrayList<Job> getJobs() {
	    ArrayList<Job> ret = new ArrayList<Job>(myCurrentJobs);
	    return ret;
	}

}