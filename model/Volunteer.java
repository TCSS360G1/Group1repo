package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a User in the Urban Parks System. A volunteer will
 * be able to sign up for jobs, cancel jobs, and view jobs that they would
 * like to possibly sign up for.
 * 
 * @author Kai Stansfield
 * @version February 15, 2018
 */
public class Volunteer extends User implements Serializable {
    private static final long serialVersionUID = 1L;

	private List<Job> myCurrentJobs;

	public Volunteer(String theFirstName, String theLastName) {
		super(theFirstName, theLastName, "Volunteer");
		this.myCurrentJobs = new ArrayList<Job>();

	}

	/**
	 * precondition: This method requires a job, and will check if the job is in
	 * the volunteer's current list of jobs.
	 * 
	 * postcondition: true is returned if they are not signed up for the job,
	 * false otherwise.
	 */
	public boolean isNotSignedUp(Job theJob) {
		return !myCurrentJobs.contains(theJob);
	}

	/**
	 * precondition: The job should be non-null.
	 * 
	 * postcondition: This method adds the job to the user.
	 */
	public void addJob(Job theJob) {
		myCurrentJobs.add(theJob);
	}

	/**
	 * precondition: The job exists for volunteer.
	 * 
	 * postcondition: This method attempts to remove the job. No issues occur
	 * when the job is non-existent for the volunteer.
	 */
	public void removeJob(Job theJob) {
		myCurrentJobs.remove(theJob);
	}
	
	/**
	 * precondition: 
	 * 
	 * postcondition: return the list of Jobs currently signed up for Volunteer.
	 */
	public ArrayList<Job> getJobs() {
	    ArrayList<Job> ret = new ArrayList<Job>(myCurrentJobs);
	    return ret;
	}
}