package model;

import java.io.Serializable;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

import java.util.ArrayList;

import java.util.List;

/**
 * 
 * This class represents a User in the Urban Parks System. A Park Manager
 * 
 * will be able to check the length of the job and how far away the job is.
 * 
 * 
 * 
 * @author Deepjot Kaur
 * 
 * @date February 11, 2018
 *
 * 
 * 
 */

public class ParkManager extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Job> myListedJobs;

	/**
	 * 
	 * The constructor for a Park Manager, which extends User,
	 * 
	 * giving its first name and last name.
	 * 
	 * 
	 * 
	 * @param theFirstName
	 *            the first name of the Park Manager User.
	 * 
	 * @param theLastName
	 *            the last name of the Park Manager User.
	 * 
	 */

	public ParkManager(String theFirstName, String theLastName) {

		super(theFirstName, theLastName, "Manager");

		this.myListedJobs = new ArrayList<Job>();

	}




	/**
	 * 
	 * precondition: theJob != null
	 * 
	 * postcondition: add the job
	 * 
	 * 
	 * 
	 * @param theJob
	 * 
	 */

	public void addJob(Job theJob) {

		// are there any conflicts with Park Manager's list?

		myListedJobs.add(theJob);

	}

	/**
	 * 
	 * precondition: theJob != null
	 * 
	 * postcondition:
	 * 
	 * 
	 * 
	 * @param theJob
	 * 
	 */

	public void removeJob(Job theJob) {

		myListedJobs.remove(theJob);

	}

	/**
	 * 
	 * precondition:
	 * 
	 * postcondition: non-null Jobs that are in the future related to Park
	 * Manager are returned. 
	 * 
	 */

	public ArrayList<Job> getJobs() {
		
		ArrayList<Job> listedJobs = new ArrayList<Job>(myListedJobs);
		//System.out.println(listedJobs.size());
//		for (int i = listedJobs.size(); i > 0; i--) {
//			//System.out.println("00");
//			if (listedJobs.get(i).isInPast()) { // if it is in the past
////				listedJobs.remove(i);
//			}
//		}
		
		return listedJobs;

	}

}
