package model;

import java.io.Serializable;

import java.time.LocalDate;

/**
 * This class holds methods for the Job class. A Job consists of a title,
 * description, location, start date, and end date.
 * 
 * @author Deepjot Kaur, Luke Manca
 * @version February 11, 2018
 */
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

    /* Fields */
    private String title;
    private String description;
    private String location;
    private LocalDate startDate; //use .equals to compare
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
    	return getTitle()+ " " + getLocation()+ " "+ getStartDate() + " To " + 
				getEndDate() + " Description: " + getDescription();
    }
    
}