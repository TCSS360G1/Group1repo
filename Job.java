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
    
    
    
    
    public void setStartDate(Date theStartDate){
    	this.startDate = theStartDate;
    }
    
    public Date getStartDate(){
    	return this.startDate;
    }
    
    
    
    
    public void setEndDate(Date theEndDate){
    	this.endDate = theEndDate;
    }
    
    public Date getEndDate(){
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
