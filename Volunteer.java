package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a user in the Urban Parks System. A volunteer will be
 * able to sign up for jobs, cancel jobs, and view jobs that they would like to
 * possibly sign up for.
 * @author Kai Stansfield
 * @version February 4, 2018
 */
public class Volunteer {

	private static final int MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP = 2;

	private String myName;

	private String myEmail;
	
	private String myNumber;
	
	private List<Job> myCurrentJobs;

	public Volunteer(String theName, String theEmail, String theNumber) {
		this.setMyName(theName);
		this.setMyEmail(theEmail);
		this.setMyNumber(theNumber);
		this.myCurrentJobs = new ArrayList<Job>();
	}

	/**
     * This method checks the start and end jobs of the candidate job to the
     * jobs that the volunteer is signed up for. Any conflict returns false.
     * 
     * @param theCandidate A job that has a potential conflicting start and end
     * date.
     * @return whether there is no conflict (true) or a conflict (false).
     */
    public boolean isNoNcheduleConflicts(Job theCandidate) {
        boolean isGood = true;
        
        for (Job aJob : myCurrentJobs) {
            isGood = (aJob.isNotSameStartDate(theCandidate) &&
                            aJob.isNotSameEndDate(theCandidate));
            if (!isGood)
                break;
        }
        
        return isGood;
    }
    
    /**
     * This method returns true if the candidate job is more than or equal to
     * two days away from todays date, false otherwise.
     * 
     * @param theCandidate The job the volunteer would like to sign up for.
     * @return Boolean if the time between now and the job's date is validate.
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
    
    public boolean notSignedUp(Job theJob) {
        return !myCurrentJobs.contains(theJob);
    }

	public String getMyName() {
		return myName;
	}

	public void setMyName(String theName) {
		this.myName = theName;
	}

	public String getMyEmail() {
		return myEmail;
	}

	public void setMyEmail(String theEmail) {
		this.myEmail = theEmail;
	}

	public String getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(String theNumber) {
		this.myNumber = theNumber;
	}
	
	/**
	 * Adds a job to the volunteer's current jobs if the job isn't already
	 * signed up for.
	 * 
	 * @param theJob A job that may already be in the current jobs.
	 * @return whether or not the job was successfully added. Enables output to
	 * user for success or failure.
	 */
	public boolean addJob(Job theJob) {
	    boolean isSuccessful;
	    if (this.notSignedUp(theJob) && this.isMoreThanMinimumDays(theJob) &&
	                    this.isNoNcheduleConflicts(theJob)) {
	        myCurrentJobs.add(theJob);
	        isSuccessful = true;
	    } else {
	        isSuccessful = false;
	    }
	    return isSuccessful;
	}
	
	
	public void removeJob(Job theJob) {
	    myCurrentJobs.remove(theJob);
	}
}
