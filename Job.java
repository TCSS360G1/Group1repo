package model;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * This class holds methods for the Job class. A Job consists of a title,
 * description, location, start date, and end date.
 * 
 * @author Deepjot Kaur, Luke Manca
 * @version February 11, 2018
 */
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;
	
    public static final int MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP = 3;
    public static final int MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER = 3;

    private String title;
    private String description;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * The constructor for a Job, containing its title, description,
     * location, start date, and end date.
     * 
     * @param theTitle the title given to the Job.
     * @param theDescription the description explaining the Job details.
     * @param theLocation the location of which the Job takes place.
     * @param theStartDate the date that the Job starts at.
     * @param theEndDate the date that the Job ends at.
     */
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
     * This method requires a job with a valid start and end date. This method
     * will compare theCandidates start and end dates with this jobs', and will
     * return a boolean to show the status of potential conflicts.
     * 
     * @param theCandidate A job that has a potential conflicting
     * start and end date.
     * @return true when there is no conflict, false otherwise.
     * 
     */
    public boolean isNoScheduleConflicts(Job theCandidate) {
        boolean isGood = true;
            isGood = (isGoodStart(theCandidate) && isGoodEnd(theCandidate));
        return isGood;
    }

    /**
     * This method requires a candidate job with a valid start date. It will
     * compare to see if this job is occurring when theCandidate starts. A
     * boolean is returned for the status of the potential conflict. It is
     * expected that isNoScheduleConflicts() is called instead, as it will call
     * this method and sister method isGoodEnd().
     * 
     * @param theCandidate A job that has a potential conflicting
     * start date.
     * @return true when there is no conflict, false otherwise.
     * 
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
     * This method requires a candidate job with a valid end date. It will
     * compare to see if this job is occurring when theCandidate ends. A
     * boolean is returned for the status of the potential conflict. It is
     * expected that isNoScheduleConflicts() is called instead, as it will call
     * this method and sister method isGoodEnd().
     * 
     * @param theCandidate A job that has a potential conflicting
     * start date.
     * @return true when there is no conflict, false otherwise.
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
     * This method tests to see if this job's start date is more than or equal
     * to the minimum days for a job to be signed up for.
     * 
     * @return true if the time between now and the job's date is valid, false
     * otherwise.
     */
    public boolean isMoreThanMinimumDays() {
        boolean isGood = true;

        LocalDate currentDate = LocalDate.now();
        long timeBetween = ChronoUnit.DAYS.between(currentDate,
                this.startDate);

        if (timeBetween < MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP) {
            isGood = false;

        }
        return isGood;
    }
    
    /**
     * Tests to see if this job is too close to be unvolunteered for.
     * 
     * @return True if the job is too close, false otherwise.
     */
    public boolean isTooClose() {
        boolean isTooClose = false;
        
        LocalDate currentDate = LocalDate.now();
        long timeBetween = ChronoUnit.DAYS.between(currentDate,
                        this.startDate);
        if (timeBetween < MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER)
            isTooClose = true;
        
        return isTooClose;
    }
    
    /**
     * Tests to see if this job is currently active. Active is defined as having
     * started before or on the current day, and ending on or after the current
     * day.
     * 
     * @return true if the job is active, false otherwise.
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
     * This method tests if this job is in the past; The job ended before today.
     * 
     * @return True if the job is in the past, false otherwise.
     */
    public boolean isInPast() {
        boolean inPast = false;
        
        LocalDate currentDate = LocalDate.now();
        long endToCurr = ChronoUnit.DAYS.between(this.endDate, currentDate);
        
        if (endToCurr > 0)
            inPast = true;
        return inPast;
    }
    //---Getters and setters ---//
    /**
     * Gets the title given to the Job.
     * 
     * @return the Job's title as a String.
     */
    public String getTitle(){
    	return this.title;
    }
    
    /**
     * Sets the title for the Job.
     * 
     * @param theTitle the title given to the Job.
     */
    public void setJobTitle(String theTitle){
        this.title = theTitle;
    }

    /**
     * Gets the description given to the Job.
     * 
     * @return the description given to the Job as a String.
     */
    public String getDescription(){
    	return this.description;
    }
    
    /**
     * Sets the description that explains what the Job is about.
     * 
     * @param theDescription the description explaining the Job details.
     */
    public void setDescription(String theDescription){
    	this.description = theDescription;
    }

    /**
     * Gets the location given to the Job.
     * 
     * @return the location of the Job as a String.
     */
    public String getLocation(){
    	return this.location;
    }
    
    /**
     * Sets the location for the Job.
     * 
     * @param theLocation the location of which the Job takes place.
     */
    public void setLocation(String theLocation){
    	this.location = theLocation;
    }
    
    /**
     * Gets the starting date for the Job.
     * 
     * @return the start date of the Job as a LocalDate.
     */
    public LocalDate getStartDate(){
    	return this.startDate;
    }
    
    /**
     * Sets the start date for the Job.
     * 
     * @param theStartDate the date that the Job starts at.
     */
    public void setStartDate(LocalDate theStartDate){
    	this.startDate = theStartDate;
    }
 
    /**
     * Gets the ending date for the Job.
     * 
     * @return the end date of the Job as a LocalDate.
     */
    public LocalDate getEndDate(){
    	return this.endDate;
    }
    
    /**
     * Sets the end date for the Job.
     * 
     * @param theEndDate the date that the Job ends at.
     */
    public void setEndDate(LocalDate theEndDate){
    	this.endDate = theEndDate;
    }

    @Override
    public String toString() {
    	return getTitle()+ " " + getStartDate() + " To " + 
				getEndDate() + " Description: " + getDescription();
    }
    
}
