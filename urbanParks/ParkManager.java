/**
 * 
 */
package urbanParks;

/**
 * User is an urban parks employee. 
 * We can to be able to create a new job. 
 * @author deepjot
 *
 */
public class ParkManager extends Job{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*Business Rule: There can be more than the maximum 
	 * number of pending jobs at a time in the entire system,
	 *  default of 20
	 *  Check the job class to see how many jobs there are 
	 *  in the entire system and compare to 20. 
	 */
	public boolean isMaxJobAmountReached() {
		return false;
		/*return true if there are 20 jobs in the system. 
		 * this will NOT allow the park manager to submit job.*/
		/*return false if there are less than 20 pending jobs currently*/
	}
	
	/*Business Rule:
	 *  No job can be specified that takes more than the maximum 
	 *  number of days, default of 3
	 */
	public boolean isMaxDays3Under(Job candidateJob) {
		return false;
		/*return true if the job will take 3 days or less.. 
		 * this will allow the park manager to submit job.*/
		/*return false if the job takes more than 3 days.*/
	}
	

}
