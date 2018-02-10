package model;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Date;

import java.time.LocalDate;

public class Job  implements Serializable{	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



  ////Fields

    private String title;

    private String description;

    private String location;

    private LocalDate startDate;      //use .equals 

    private LocalDate endDate;

//    private int numberVolsNeeded;



  ////List of Volunteers for Job

//    public ArrayList<User> Volunteers = new ArrayList<User>();

    public Job() {
    	//empty constructor
    }

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

//    private void setStartDate(Date theDate){

//    	if (theDate < currentDate + 74 Days){

//    		this.startDate = theDate;

//    	}

//    	else {

//    		System.out.println("Not Valid");

//    	}

//        

//    }

//    private void setEndDate(Date theDate){

//       

//        if (theDate < currentDate + 74 Days){

//    		this.endDate = theDate;

//    	}

//    	else {

//    		System.out.println("Not Valid");

//    	}

//    }





}