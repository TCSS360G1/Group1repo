package model;



import java.io.Serializable;



import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

import java.util.ArrayList;

import java.util.List;



/**

 * This class represents a User in the Urban Parks System. A Park Manager

 * will be able to check the length of the job and how far away the job is.

 * 

 * @author Deepjot Kaur

 * @date February 11, 2018

 *

 */

public class ParkManager extends User implements Serializable{	

	private static final long serialVersionUID = 1L;

	

	/* Fields */

	private static final int MAX_LENGTH = 3;

	// private static final int MAX_JOBS = 20;

	private static final int MAX_DISTANCE = 75;

	

	private List<Job> myListedJobs;



	/**

	 * The constructor for a Park Manager, which extends User,

	 * giving its first name and last name.

	 * 

	 * @param theFirstName the first name of the Park Manager User.

	 * @param theLastName the last name of the Park Manager User.

	 */

	public ParkManager(String theFirstName, String theLastName) {

	    super(theFirstName, theLastName, "Manager");

	    

	    this.myListedJobs = new ArrayList<Job>();

	}

	

	/** 

	 * No job can be specified that takes more than the maximum 

	 * number of days.

	 * 

	 * @param cadidateJob a prospective job that is being checked of its days.

	 * @return true if the job will take under max specified days, false

	 * otherwise.

	 */

	public boolean isMaxDaysUnder(LocalDate theStart, LocalDate theEnd) { 

		long amountDays = ChronoUnit.DAYS.between(theStart,

				theEnd);

		

		if (amountDays > MAX_LENGTH-1) {

			// need to subtract one because the last day is not counted.

			return false;

		}

		return true;

	}

	

	/**

	 * No job can be maximum days into the future.

	 * 

	 * @param cadidateJob a prospective job being checked for its days.

	 * @return false if it is over max days away, return true otherwise.

	 */

	public boolean isJobNotTooFar(LocalDate theStart) {

		LocalDate farthestDate = LocalDate.now().plusDays(MAX_DISTANCE);

		if(ChronoUnit.DAYS.between(farthestDate, 

				theStart) > 0) {

			// a job is more than 75 days into the future- FALSE

			return false;

		} else {

			return true;

		}

	}

	

	/**

	 * precondition: theJob != null

	 * postcondition: 

	 * 

	 * @param theJob 

	 */

	public void addJob(Job theJob) {

		// are there any conflicts with Park Manager's list?

		

		myListedJobs.add(theJob);

	}

	

	/**

	 * precondition: theJob != null

	 * postcondition: 

	 * 

	 * @param theJob 

	 */

	public void removeJob(Job theJob) {

		myListedJobs.remove(theJob);

	}

	

	/**

	 * precondition: 

	 * postcondition: non-null Jobs related to Park Manager are returned.

	 * 

	 * @return 

	 */

	public ArrayList<Job> getJobs() {

		ArrayList<Job> listedJobs = new ArrayList<Job>(myListedJobs);

		

		return listedJobs;

	}

	

}