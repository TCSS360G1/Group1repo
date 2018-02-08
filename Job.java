package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * This class represents a job for the Urban Parks system. It will hold its date, description, and other parameters it
 * may need like amount of volunteers already volunteered for it.
 * 
 * @author Kai Stansfield
 * @version February 4, 2018
 *
 */
public class Job {

	LocalDate myStartDate;
	LocalDate myEndDate;

	/**
	 * Currently takes three integers to create the date. Would take in more items to fully implement the job.
	 * 
	 * @param theMonth The month, 1-12
	 * @param theDay The day, 1-31
	 * @param theYear The year, whatever the year is
	 */
	public Job(LocalDate theStartDate, LocalDate theEndDate) {
		this.myStartDate = theStartDate;
		this.myEndDate = theEndDate;
	}

	public boolean isNotSameStartDate(Job theJob) {
	    boolean isGood = true;
	    if (ChronoUnit.DAYS.between(this.myStartDate, 
	                    theJob.getStartDate()) == 0)
	        isGood = false;
	    return isGood;
	}
	
	public boolean isNotSameEndDate(Job theJob) {
        boolean isGood = true;
        if (ChronoUnit.DAYS.between(this.myEndDate, 
                        theJob.getEndDate()) == 0)
            isGood = false;
        return isGood;
    }
	
	public LocalDate getStartDate() {
		return this.myStartDate;
	}
	
	public LocalDate getEndDate() {
        return this.myEndDate;
    }
}
