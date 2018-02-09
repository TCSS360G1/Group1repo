/**
 * 
 */
package urbanParks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	
	private Date d = new Date();
	private int currentDate = d.getDate();
	
	/*Business Rule: There can be more than the maximum 
	 * number of pending jobs at a time in the entire system
	 *  Check the job class to see how many jobs there are 
	 *  @return true is there are  exactly max jobs in system.
	 */
	public boolean isMaxJobAmountReached() throws FileNotFoundException { //check system for the amount of jobs. 
		/*1. Parse through the text file and count the amount of jobs in the system.*/
		File jobFile = new File("Jobs.txt");
		
		
		return false;
		
	}
	
	/*Business Rule:
	 *  No job can be specified that takes more than the maximum 
	 *  number of days
	 *  @param cadidateJob- 
	 *  @return true if the job will take under max specified days
	 */
	public boolean isMaxDaysUnder(Job candidateJob) { 
		
		if (candidateJob.getLength() > MAX_LENGTH) {
			return false;
		}
		return true;
	}
	
	/*Business Rule:
	 * No job can be maximum days into the future.
	 * @param cadidateJob- a prospective job.
	 * @return true if it is over max days away then return false else return true.
	 */
	public boolean isJobTooFar(Job candidateJob) {
		
		Calendar cal = Calendar.getInstance();
		cal.add(currentDate, MAX_DISTANCE);
		Date farthestDate = cal.getTime();
		if(candidateJob.getStartDate() > farthestDate.getDate()) {
			//a job is more than 75 days into the future- FALSE
			return false;
		} else if (candidateJob.getStartDate()<=farthestDate.getDate()) {
			return true;
		}
		return false; 
		
	}
	

}
