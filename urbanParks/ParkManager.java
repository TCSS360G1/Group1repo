/**
 * 
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Park manager is a user. 
 * This class provides for 3 business rules- it checks the length of the job, 
 * how many jobs are in the system, and how far away is the job.
 * @author deepjot
 * @date 2/8
 *
 */
public class ParkManager extends User {
	private int MAX_LENGTH = 3;
	private int MAX_JOBS = 20;
	private int MAX_DISTANCE = 75;
	
	
	
//	/*Business Rule: There can be more than the maximum 
//	 * number of pending jobs at a time in the entire system
//	 *  Check the job class to see how many jobs there are 
//	 *  @return true is there are  exactly max jobs in system.
//	 */
//	public boolean isMaxJobAmountReached() throws FileNotFoundException { //check system for the amount of jobs. 
//		/*1. Parse through the text file and count the amount of jobs in the system.*/
//		File jobFile = new File("Jobs.txt");
//		
//		
//		return false;
//		
//	}
	
	/*Business Rule:
	 *  No job can be specified that takes more than the maximum 
	 *  number of days
	 *  @param cadidateJob- 
	 *  @return true if the job will take under max specified days
	 */
	public boolean isMaxDaysUnder(Job theCandidateJob) { 
		int amountDays = ChronoUnit.DAYS.between(theCandidateJob.getStartDate(),theCandidateJob.getEndDate());
		
		if (amountDays > MAX_LENGTH) {
			return false;
		}
		return true;
	}
	
	/*Business Rule:
	 * No job can be maximum days into the future.
	 * @param cadidateJob- a prospective job.
	 * @return true if it is over max days away then return false else return true.
	 */
	public boolean isJobTooFar(Job theCandidateJob) {
		
		
		LocalDate farthestDate = LocalDate.now().plusDays(MAX_DISTANCE);
		if(ChronoUnit.DAYS.between(farthestDate, theCandidateJob.getStartDate()) > 0) {
			//a job is more than 75 days into the future- FALSE
			return false;
		} else {
			return true;
		}
		return false; 
		
	}
	

}
