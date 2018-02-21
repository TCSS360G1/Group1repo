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
 * @version February 15, 2018
 */
public class Volunteer extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP = 3;
    public static final int MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER = 3;
	private List<Job> myCurrentJobs;

	/**
	 * A Volunteer requires A first name and last name. The volunteer will
	 * identify itself as a volunteer to user, and will also provide an empty
	 * ArrayList of jobs for itself.
	 * 
	 * @param theFirstName the first name of the Volunteer User.
	 * @param theLastName the last name of the Volunteer User.
	 */
	public Volunteer(String theFirstName, String theLastName) {
		super(theFirstName, theLastName, "Volunteer");
		this.myCurrentJobs = new ArrayList<Job>();

	}

	/**
	 * This method requires a job with a valid start and end date. This method
	 * will compare theCandidates start and end dates with all of the
	 * volunteer's currently signed up jobs, and will return a boolean to show
	 * the status of potential conflicts.
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
	 * This method requires a candidate job with a valid start date, and a
	 * current job with valid start and end date. It will compare to see if any
	 * of the volunteer's current jobs is occurring when theCandidate starts. A
	 * boolean is returned for the status of the potential conflict. It is
	 * expected that isNoScheduleConflicts() is called instead, as it will call
	 * the this method and sister method isGoodEnd(), and will run through all
	 * current volunteer jobs, rather than comparing one job at a time.
	 * 
	 * @param theCurrent A job the volunteer is signed up for.
	 * @param theCandidate A job that has a potential conflicting
	 * start date.
	 * @return true whether there is no conflict, false otherwise.
	 * 
	 */
	public boolean isGoodStart(Job theCurrent, Job theCandidate) {
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
	 * This method requires a candidate job with a valid end date, and a
     * current job with valid start and end date. It will compare to see if any
     * of the volunteer's current jobs is occurring when theCandidate starts. A
     * boolean is returned for the status of the potential conflict. It is
     * expected that isNoScheduleConflicts() is called instead, as it will call
     * the this method and sister method isGoodStart(), and will run through all
     * current volunteer jobs, rather than comparing one job at a time.
	 * 
	 * @param theCurrent A job the volunteer is signed up for. 
	 * @param theCandidate A job that has a potential conflicting
	 * end date.
	 * @return true whether there is no conflict, false otherwise.
	 * 
	 */
	public boolean isGoodEnd(Job theCurrent, Job theCandidate) {
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
	 * This method requires a job with a valid start date, and returns a boolean
	 * for whether the job is within a valid time frame to sign up for.
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
	 * This method requires a job, and will check if the job is in the
	 * volunteer's current list of jobs. A boolean is returned whether or not
	 * the job was in the list.
	 * 
	 * @param theJob the job to be checked for the Volunteer.
	 * @return true if they are not signed up for the job, false otherwise.
	 */
	public boolean isNotSignedUp(Job theJob) {
		return !myCurrentJobs.contains(theJob);

	}

	
	/**
	 * This method requires a job that will not conflict with a volunteers
	 * current jobs that they are signed up for, or a exception related to the
	 * reason why the job can't be signed up for is thrown. If no exception is
	 * thrown, the job is added to the volunteer's list.
	 * 
	 * @param theJob a job that the volunteer would like to sign up for.
	 * @throws AlreadySignedUpException Thrown if IsNotSignedUp() returns false.
	 * @throws MinimumDaysException Thrown if isMoreThanMinimumDays() returns
	 * false.
	 * @throws ScheduleConflictException Thrown if isNoScheduleConflicts()
	 * returns false.
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
	 * Requires a job with a valid start date, and compares it with the current
	 * date. Returns a boolean signifying if the day is too close for
	 * unvolunteering.
	 * 
	 * @param theCandidate is a potential job to remove.
	 * @return True if the job is too close, false otherwise.
	 */
	public boolean isTooClose(Job theCandidate) {
	    boolean isTooClose = false;
	    
	    LocalDate currentDate = LocalDate.now();
	    long timeBetween = ChronoUnit.DAYS.between(currentDate,
	                    theCandidate.getStartDate());
	    if (timeBetween < MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER)
	        isTooClose = true;
	    
	    return isTooClose;
	}
	
	/**
	 * Requires a job with a valid start and end date, and will return whether
	 * or not the job is active.
	 * 
	 * @param theCandidate a potentially active job.
	 * @return true if the job is active, false otherwise.
	 */
	public boolean isActiveJob(Job theCandidate) {
	    boolean isActive = false;
	    LocalDate currentDate = LocalDate.now();
	    long currToEnd = ChronoUnit.DAYS.between(theCandidate.getEndDate(),
	                    currentDate);
	    long currToStart = ChronoUnit.DAYS.between(theCandidate.getStartDate(),
	                    currentDate);
	    if (currToEnd <= 0 && currToStart >= 0)
	        isActive = true;
	    
	    return isActive;
	}
	
	/**
	 * This method requires any job, and will attempt to remove the job if it is
	 * in the list. Throws exceptions to report on why the job could not be
	 * removed.
	 * 
	 * @param theJob the job that the Volunteer wants to remove.
	 * @throws TooCloseException Throws when a job is too close to be canceled,
	 * if isTooClose() returns true.
	 * @throws ActiveJobException Throws when the volunteer tries to cancel a
	 * currently active job, if isActiveJob() returns true.
	 */
	public void removeJob(Job theJob) throws TooCloseException,
	        ActiveJobException {
	    if (isActiveJob(theJob))
            throw new ActiveJobException();
	    if (isTooClose(theJob))
	        throw new TooCloseException();
	    
		myCurrentJobs.remove(theJob);
	}
	
	/**
	 * This method will return a copy of the Volunteer's current list of sign up
	 * for jobs.
	 * 
	 * @return the list of Jobs currently signed up for Volunteer.
	 */
	public ArrayList<Job> getJobs() {
	    ArrayList<Job> ret = new ArrayList<Job>(myCurrentJobs);
	    return ret;
	}

}