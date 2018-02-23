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

	/**
	 * A Volunteer requires A first name and last name. The volunteer will
	 * identify itself as a volunteer to user, and will also provide an empty
	 * ArrayList of jobs for itself.
	 * 
	 * @param theFirstName the first name of the Volunteer User.
	 * @param theLastName the last name of the Volunteer User.
	 */
	public Volunteer(String theFirstName, String theLastName) {
		super(theFirstName, theLastName, "Volunteer");
		this.myCurrentJobs = new ArrayList<Job>();

	}

	/**
	 * This method requires a job, and will check if the job is in the
	 * volunteer's current list of jobs. A boolean is returned whether or not
	 * the job was in the list.
	 * 
	 * @param theJob the job to be checked for the Volunteer.
	 * @return true if they are not signed up for the job, false otherwise.
	 */
	public boolean isNotSignedUp(Job theJob) {
		return !myCurrentJobs.contains(theJob);
	}

	/**
	 * This method adds the job to the user. The job should be non-null.
	 * 
	 * @param theJob a job that the volunteer would like to sign up for.
	 */
	public void addJob(Job theJob) {
		myCurrentJobs.add(theJob);
	}

	/**
	 * This method attempts to remove the job. No issues occur when the job is
	 * non-existent for the volunteer.
	 */
	public void removeJob(Job theJob) {
		myCurrentJobs.remove(theJob);
	}
	
	/**
	 * This method will return a copy of the Volunteer's current list of sign up
	 * for jobs.
	 * 
	 * @return the list of Jobs currently signed up for Volunteer.
	 */
	public ArrayList<Job> getJobs() {
	    ArrayList<Job> ret = new ArrayList<Job>(myCurrentJobs);
	    return ret;
	}
}