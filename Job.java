package model;
import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;
<<<<<<< HEAD

=======
import java.util.Date;
import java.time.LocalDate;
>>>>>>> 6c597166ac76a8a256fdefce49fa0a93fdbde635
public class Job {

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
