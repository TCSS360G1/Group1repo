package model;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * This class holds methods for the Job class. A Job consists of a title,
 * description, location, start date, and end date.
 * 
 * @author Deepjot Kaur, Luke Manca
 * @version February 11, 2018
 */
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;
	
    public static final int MINIMUM_NUMBER_OF_DAYS_TO_VOLUNTEER = 3;
    public static final int MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER = 3;
	public static final int MAX_LENGTH = 4;
	public static final int MAX_DISTANCE = 60;
    private static int MAX_JOBS = 10;

    private String title;
    private String description;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;

    public Job(String theTitle, String theDescription, String theLocation, 
    		LocalDate theStartDate, LocalDate theEndDate) {
    	title = theTitle;
    	description = theDescription;
    	location = theLocation;
    	startDate = theStartDate;
    	endDate = theEndDate;
    }

    //---Validation methods---//
    
    /**
     * precondition: This method requires a data (assumed to be the start date
     * of a job) and tests if it is less than or equal to the maximum days away
     * for a job to start at. MAX_DISTANCE is the maximum days away. Generally
     * for the of testing if a potential jobs' start date would be an issue.
     * 
     * postcondition: true is returned if the date is greater than the
     * MAX_DISTANCE days allowed, otherwise false is returned.
     */
    public static boolean isDateTooFar(LocalDate theDate) {
        boolean tooFar = false;
        LocalDate currentDate = LocalDate.now();
        long lengthTillJob = ChronoUnit.DAYS.between(currentDate, theDate);
        if(lengthTillJob > MAX_DISTANCE) {
            tooFar = true;
        }
        return tooFar;
    }
    
    /**
     * precondition: This method requires a job with a valid start and end date.
     * This method will compare theCandidates start and end dates with this
     * jobs', and will return a boolean to show the status of potential
     * conflicts.
     * 
     * postcondition: true is returned when there is no job schedule conflict,
     * false otherwise.
     */
    public boolean isNoScheduleConflicts(Job theCandidate) {
        boolean isGood = true;
            isGood = (isGoodStart(theCandidate) && isGoodEnd(theCandidate));
        return isGood;
    }

    /**
     * precondition: This method requires a candidate job with a valid start
     * date. It will compare to see if this job is occurring when theCandidate
     * starts. A boolean is returned for the status of the potential conflict.
     * It is expected that isNoScheduleConflicts() is called instead, as it
     * will call this method and sister method isGoodEnd().
     * 
     * postcondition: true is returned when there is no conflict with the jobs'
     * starting day, false otherwise.
     */
    public boolean isGoodStart(Job theCandidate) {
        boolean isGood = true;

        long lengthOfCurr = ChronoUnit.DAYS.between(this.startDate,
                this.endDate);

        long between = ChronoUnit.DAYS.between(this.endDate,
                theCandidate.getStartDate());

        if (between <= 0 && between >= lengthOfCurr * -1) {
            isGood = false;
        }

        return isGood;
    }
    
    /**
     * postcondition: This method requires a candidate job with a valid end
     * date. It will compare to see if this job is occurring when theCandidate
     * ends. A boolean is returned for the status of the potential conflict.
     * It is expected that isNoScheduleConflicts() is called instead, as it
     * will call this method and sister method isGoodEnd().
     * 
     * postcondition: true is returned when there is no conflict with the jobs'
     * ending day, false otherwise.
     * 
     */
    public boolean isGoodEnd(Job theCandidate) {
        boolean isGood = true;

        long lengthOfCurr = ChronoUnit.DAYS.between(this.startDate,
                this.endDate);

        long between = ChronoUnit.DAYS.between(this.startDate,
                theCandidate.getEndDate());

        if (between >= 0 && between <= lengthOfCurr) {
            isGood = false;
        }

        return isGood;
    }
    
    /**
     * precondition: This method tests to see if this job's start date is more
     * than or equal to the minimum days for a job to be signed up for.
     * 
     * postcondition: true if the time between now and the job's date is valid,
     * false otherwise.
     */
    public boolean isMoreThanMinimumDaysVol() {
        boolean isGood = true;

        LocalDate currentDate = LocalDate.now();
        long timeBetween = ChronoUnit.DAYS.between(currentDate,
                this.startDate);

        if (timeBetween < MINIMUM_NUMBER_OF_DAYS_TO_VOLUNTEER) {
            isGood = false;

        }
        return isGood;
    }
    
    /**
     * precondition: This method tests to see if this job is too close to be
     * unvolunteered for.
     * 
     * postcondition: true is returned if the job is too close, false otherwise.
     */
    public boolean isMoreThanMinimumDaysUnvol() {
        boolean isGood = true;
        
        LocalDate currentDate = LocalDate.now();
        long timeBetween = ChronoUnit.DAYS.between(currentDate,
                        this.startDate);
        if (timeBetween < MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER)
            isGood = false;
        
        return isGood;
    }
    
    /**
     * precondition: Tests to see if this job is currently active. Active is defined as having
     * started before or on the current day, and ending on or after the current
     * day.
     * 
     * postcondition: true is returned if the job is active, false otherwise.
     */
    public boolean isActiveJob() {
        boolean isActive = false;
        LocalDate currentDate = LocalDate.now();
        long currToEnd = ChronoUnit.DAYS.between(this.endDate,
                        currentDate);
        long currToStart = ChronoUnit.DAYS.between(this.startDate,
                        currentDate);
        if (currToEnd <= 0 && currToStart >= 0)
            isActive = true;
        
        return isActive;
    }

	
	
    /**
     * precondition: This method tests if this job is in the past; Being in the
     * past is defined as a job that has ended before today.
     * 
     * postcondition: true is returned if the job checked is in the past,
     * false otherwise.
     */
    public boolean isInPast() {
        boolean inPast = false;
        
        LocalDate currentDate = LocalDate.now();
        long endToCurr = ChronoUnit.DAYS.between(this.endDate, currentDate);
        
        if (endToCurr > 0)
            inPast = true;
        return inPast;
    }
    
    /**
	 * precondition: This method requires a valid JobCollection, and will test
	 * the number of jobs within the JobCollection to see if it is more than
	 * the max amount of jobs.
	 * 
	 * postcondition: false if there are too many jobs a Volunteer can carry,
	 * true otherwise.
	 */
	public static boolean isJobsAmountLegal(JobCollection myJobs) {
		if(myJobs.getSize() > MAX_JOBS) {
			return false;
		} else {
			return true;
		}
	}
    
    /**
     * precondition: ALWAYS PASS IN users current jobs list.
     * will not allow user to cancel a job if it is too far.
     * 
	 * postcondition: The ArrayList<Job> for Cancellations is returned.
	 */
	public static ArrayList<Job> filterForCancellation(
			ArrayList<Job> theJobList) {
		ArrayList<Job> myCancellationJobs = new ArrayList<Job>();
		for (int i = 0; i < theJobList.size(); i++) {
			if (!theJobList.get(i).isMoreThanMinimumDaysVol()) {
				myCancellationJobs.add(theJobList.get(i));
			}
		}
		return myCancellationJobs;

	}
	
	
	//---Getters and setters ---//
    public String getTitle(){
    	return this.title;
    }
    
    public void setJobTitle(String theTitle){
        this.title = theTitle;
    }

    public String getDescription(){
    	return this.description;
    }
    
    public void setDescription(String theDescription){
    	this.description = theDescription;
    }

    public String getLocation(){
    	return this.location;
    }
    
    public void setLocation(String theLocation){
    	this.location = theLocation;
    }
    
    public LocalDate getStartDate(){
    	return this.startDate;
    }

    public void setStartDate(LocalDate theStartDate){
    	this.startDate = theStartDate;
    }
 
    public LocalDate getEndDate(){
    	return this.endDate;
    }
    
    public void setEndDate(LocalDate theEndDate){
    	this.endDate = theEndDate;
    }

    @Override
    public String toString() {
    	return getTitle()+ " " + getStartDate() + " To " + 
				getEndDate() + " Description: " + getDescription();
    }
    
    
    public static void setLegalJobAmount(int theLegalJobAmount) {
		MAX_JOBS = theLegalJobAmount;
	}
	
	public static int getLegalJobAmount() {
		return MAX_JOBS;
	}
}
