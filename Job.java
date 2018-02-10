package model;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * This class holds methods for the Job class.
 * @author Deepjot Luke 
 * @date 2.10
 */
public class Job  implements Serializable{	


	private static final long serialVersionUID = 1L;



  ////Fields

    private String title;

    private String description;

    private String location;

    private LocalDate startDate;      //use .equals 

    private LocalDate endDate;

//    public ArrayList<User> Volunteers = new ArrayList<User>();


    public Job(String theTitle, String theDescription, String theLocation, LocalDate theStartDate, LocalDate theEndDate) {
    	title = theTitle;
    	description = theDescription;
    	location = theLocation;
    	startDate = theStartDate;
    	endDate = theEndDate;
    }

    public void setJobTitle(String theTitle){
        this.title = theTitle;
    }

    public String getTitle(){
    	return this.title;
    }

    public void setDescription(String theDescription){
    	this.description = theDescription;
    }

    public String getDescription(){
    	return this.description;
    }

    public void setLocation(String theLocation){
    	this.location = theLocation;
    }

    public String getLocation(){
    	return this.location;
    }
    
    public void setStartDate(LocalDate theStartDate){
    	this.startDate = theStartDate;
    }
 
    public LocalDate getStartDate(){
    	return this.startDate;
    }

    @Override
    public String toString() {
    	return getTitle()+ " " + getStartDate() + " To " + 
				getEndDate() + " Description: " + getDescription();
    }

    public void setEndDate(LocalDate theEndDate){
    	this.endDate = theEndDate;
    }

    public LocalDate getEndDate(){
    	return this.endDate;
    }
}