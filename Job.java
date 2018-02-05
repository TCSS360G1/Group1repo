package model;

import java.time.LocalDate;

/**
 * This class represents a job for the Urban Parks system. It will hold its date, description, and other parameters it
 * may need like amount of volunteers already volunteered for it.
 * 
 * @author Kai Stansfield
 * @version February 4, 2018
 *
 */
public class Job {
	/**
	 * The date of the job.
	 */
	LocalDate myDate;

	/**
	 * Currently takes three integers to create the date. Would take in more items to fully implement the job.
	 * 
	 * @param theMonth The month, 1-12
	 * @param theDay The day, 1-31
	 * @param theYear The year, whatever the year is
	 */
	public Job(LocalDate theDate) {
		this.myDate = theDate;
	}

	/**
	 * Returns the date of the job.
	 * 
	 * @return The date.
	 */
	public LocalDate getDate() {
		return this.myDate;
	}
}
