package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * This class represents a user in the Urban Parks System. A volunteer will be
 * able to sign up for jobs, cancel jobs, and view jobs that they would like to
 * possibly sign up for.
 * @author Kai Stansfield
 * @version February 4, 2018
 */
public class Volunteer {

	public static final int MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP = 2;

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
    public boolean isNoScheduleConflicts(Job theCandidate) {
        boolean isGood = true;
        
        for (Job aJob : myCurrentJobs) {
            isGood = (isGoodStart(aJob, theCandidate) &&
                            isGoodEnd(aJob, theCandidate));
            if (!isGood)
                break;
        }
        
        return isGood;
    }
    
    private boolean isGoodStart(Job theCurrent, Job theCandidate) {
        boolean isGood = true;
        long lengthOfCurr = ChronoUnit.DAYS.between(theCurrent.getStartDate(),
                        theCurrent.getEndDate());
        
        long between = ChronoUnit.DAYS.between(theCurrent.getEndDate(),
                        theCandidate.getStartDate());
        if (between < 0 && between > lengthOfCurr * -1)
            isGood = false;
        return isGood;
    }
    
    private boolean isGoodEnd(Job theCurrent, Job theCandidate) {
        boolean isGood = true;
        long lengthOfCurr = ChronoUnit.DAYS.between(theCurrent.getStartDate(),
                        theCurrent.getEndDate());
        
        long between = ChronoUnit.DAYS.between(theCurrent.getStartDate(),
                        theCandidate.getEndDate());
        if (between > 0 && between < lengthOfCurr)
            isGood = false;
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
    
    public boolean isNotSignedUp(Job theJob) {
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
	 * @throws exceptions based on what failed in adding the job.
	 */
	public void addJob(Job theJob) throws AlreadySignedUpException,
	                           MinimumDaysException, ScheduleConflictException {
	    if (!this.isNotSignedUp(theJob))
	        throw new AlreadySignedUpException();
	    if (!this.isMoreThanMinimumDays(theJob))
	        throw new MinimumDaysException();
	    if (!this.isNoScheduleConflicts(theJob))
	        throw new ScheduleConflictException();
	    myCurrentJobs.add(theJob);
	}
	
	
	public void removeJob(Job theJob) {
	    myCurrentJobs.remove(theJob);
	}
}
