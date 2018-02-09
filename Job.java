package model;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

public class Job {

  ////Fields
    private String title;
    private String description;
    private String location;
    private Date startDate;      //use .equals 
    private Date endDate;
//    private int numberVolsNeeded;

  ////List of Volunteers for Job
//    public ArrayList<User> Volunteers = new ArrayList<User>();
    
    public Job() {
    }


    private void setJobTitle(String theTitle){
        this.title = theTitle;
    }
    
    private String getTitle(){
    	return this.title;
    }
    
    
    
    private void setDescription(String theDescription){
    	this.description = theDescription;
    }
    
    private String getDescription(){
    	return this.description;
    }
    
    
    
    
    private void setLocation(String theLocation){
    	this.location = theLocation;
    }
    
    private String getLocation(){
    	return this.location;
    }
    
    
    
    
    private void setStartDate(Date theStartDate){
    	this.startDate = theStartDate;
    }
    
    private Date getStartDate(){
    	return this.startDate;
    }
    
    
    
    
    private void setEndDate(Date theEndDate){
    	this.endDate = theEndDate;
    }
    
    private Date getEndDate(){
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
