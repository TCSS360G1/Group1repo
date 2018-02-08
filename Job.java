package model;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

public class Job {

  ////Fields
    private String title;
    private String description;
    private String location;
    private String startDate;      //use .equals 
    private String endDate;
    //private Date startDate;
    //private Date endDate;
    private int numberVolsNeeded;

  ////List of Volunteers for Job
    public ArrayList<User> Volunteers = new ArrayList<User>();
    
    public Job() {
    }


    private void setJobTitle(String theTitle){
        this.title = theTitle;
    }
    private void setStartDate(Date theDate){
    	if (theDate < currentDate + 74 Days){
    		this.startDate = theDate;
    	}
    	else {
    		System.out.println("Not Valid");
    	}
        
    }
    private void setEndDate(Date theDate){
       
        if (theDate < currentDate + 74 Days){
    		this.endDate = theDate;
    	}
    	else {
    		System.out.println("Not Valid");
    	}
    }


}
