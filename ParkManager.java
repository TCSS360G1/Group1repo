package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Park manager is a user. 
 * This class provides for 2 business rules- it checks the 
 * length of the job and how far away is the job.
 * @author deepjot
 * @date 2/8
 *
 */
public class ParkManager extends User implements Serializable{	

	private static final long serialVersionUID = 1L;
	private static final int MAX_LENGTH = 3;
	private static final int MAX_JOBS = 20;
	private static final int MAX_DISTANCE = 75;

	public ParkManager(String theFirstName, String theLastName) {
	    super(theFirstName, theLastName, "Manager");
	}
	
	/*  No job can be specified that takes more than the maximum 
	 *  number of days
	 *  @param cadidateJob- 
	 *  @return true if the job will take under max specified days
	 */
	public boolean isMaxDaysUnder(Job theCandidateJob) { 
		long amountDays = ChronoUnit.DAYS.between(theCandidateJob.getStartDate(),
				theCandidateJob.getEndDate());
		
		if (amountDays > MAX_LENGTH) {
			return false;
		}
		return true;
	}
	
	/* No job can be maximum days into the future.
	 * @param cadidateJob- a prospective job.
	 * @return true if it is over max days away then return false else return 
	 * true.
	 */
	public boolean isJobNotTooFar(Job theCandidateJob) {
		LocalDate farthestDate = LocalDate.now().plusDays(MAX_DISTANCE);
		if(ChronoUnit.DAYS.between(farthestDate, 
				theCandidateJob.getStartDate()) > 0) {
			//a job is more than 75 days into the future- FALSE
			return false;
		} else {
			return true;
		}
	}
}
