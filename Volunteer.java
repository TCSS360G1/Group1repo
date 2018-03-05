package model;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a User in the Urban Parks System. A volunteer will
 * be able to sign up for jobs, cancel jobs, and view jobs that they would
 * like to possibly sign up for.
 * 
 * @author Kai Stansfield
 * @version February 11, 2018
 */
public class Volunteer extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7001992405582133870L;
	/* Fields */
    public static final int MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP = 3;
	private List<Job> myCurrentJobs;

	/**
	 * The constructor for a Volunteer, which extends User,
	 * giving its first name and last name. This User can also
	 * have a list of Jobs they would sign up for.
	 * 
	 * @param theFirstName the first name of the Volunteer User.
	 * @param theLastName the last name of the Volunteer User.
	 */
	public Volunteer(String theFirstName, String theLastName) {
		super(theFirstName, theLastName, "Volunteer");
		this.myCurrentJobs = new ArrayList<Job>();

	}
	
	/**
	 * This method checks whether or not they are signed up for a job or not.
	 * 
	 * @param theJob the job to be checked for the Volunteer.
	 * @return true if they are not signed up for the job, false otherwise.
	 */
	public boolean isNotSignedUp(Job theJob) {
		return !myCurrentJobs.contains(theJob);

	}

	/**
	 * Adds a job to the volunteer's current jobs if the job isn't already
	 * signed up for.
	 * 
	 * @param theJob a job that may already be in the current jobs.
	 * @throws exceptions based on what failed in adding the job.
	 */
	public void addJob(Job theJob) {
		myCurrentJobs.add(theJob);
	}

	/**
	 * Removes the Job that the Volunteer chooses to take off.
	 * 
	 * @param theJob the job that the Volunteer wants to remove.
	 */
	public void removeJob(Job theJob) {
	    System.out.println("Remove: " + theJob.toString());
	    for (int i = 0; i < myCurrentJobs.size(); i++) {
	        if (myCurrentJobs.get(i).toString().equals(theJob.toString()))
	            myCurrentJobs.remove(myCurrentJobs.get(i));
	    }
		myCurrentJobs.remove(theJob);

	}
	
	/**
	 * The list of Jobs that the Volunteer has signed up for.
	 * 
	 * @return the list of Jobs currently signed up for Volunteer.
	 */
	public ArrayList<Job> getJobs() {
	    ArrayList<Job> ret = new ArrayList<Job>(myCurrentJobs);
	    
	    return ret;
	}

}