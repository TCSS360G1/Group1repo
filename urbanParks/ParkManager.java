/**
 * 
 */
package urbanParks;

import java.util.Calendar;
import java.util.Date;

/**
 * Park manager is a user. 
 * We can to be able to create a new job. 
 * @author deepjot
 *
 */
public class ParkManager extends User {
	private int MAX_LENGTH = 3;
	private int MAX_JOBS = 20;
	private int MAX_DISTANCE = 75;
	
	private Date d = new Date();
	private int currentDate = d.getDate();
	
	/*Business Rule: There can be more than the maximum 
	 * number of pending jobs at a time in the entire system,
	 *  default of 20
	 *  Check the job class to see how many jobs there are 
	 *  in the entire system and compare to 20. 
	 */
	public boolean isMaxJobAmountReached() { //check system for the amount of jobs. 
		
		return false;
		/*return true if there are 20 jobs in the system. 
		 * this will NOT allow the park manager to submit job.*/
		/*return false if there are less than 20 pending jobs currently*/
	}
	
	/*Business Rule:
	 *  No job can be specified that takes more than the maximum 
	 *  number of days, default of 3
	 */
	public boolean isMaxDays3Under(Job candidateJob) { //candidateJob.getlength
		/*return true if the job will take 3 days or less.. 
		 * this will allow the park manager to submit job.*/
		/*return false if the job takes more than 3 days.*/
		if (candidateJob.getLength() > MAX_LENGTH) {
			return false;
		}
		return true;
	}
	
	/*Business Rule:
	 * No job can be 75 days into the future.
	 */
	public boolean isJobTooFar(Job candidateJob) {//candidateJob.getStartdate.
		/*get current date and compare to the date that the 
		 * job will be starting at, if it is over 75 days away then return false else return true. */
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
