/**
	 * 
	 */
package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Job;
import model.JobCollection;
import model.ParkManager;
import model.UrbanParksEmployee;

import model.Volunteer;

public class JobCollectionTest {

	private static JobCollection myJob;
	Job past = new Job("x", "x", "x", LocalDate.now().minusDays(2),
			LocalDate.now().minusDays(2));
	Job current = new Job("x", "x", "x", LocalDate.now(), LocalDate.now());
	Job future = new Job("x", "x", "x", LocalDate.now().plusDays(2),
			LocalDate.now().plusDays(2));

	Job minimumDaysOut = new Job("x", "x", "x",
			LocalDate.now().plusDays(Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER),
			LocalDate.now()
					.plusDays(Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER));
	private ArrayList<Job> myVolJobs;

	/**
	 * 
	 */
	public JobCollectionTest() {
		myJob = new JobCollection();
		myVolJobs = new ArrayList<Job>();
	}

	@Before
	public void setup() {
		myJob.addNewJob(past);
		myJob.addNewJob(current);
		myJob.addNewJob(future);

		myVolJobs.add(future);
		myVolJobs.add(current);
		myVolJobs.add(minimumDaysOut);
	}

	@Test
	public void filterPast_past_false() {
		assertFalse(myJob.filterPast().contains(past));
	}

	@Test
	public void filterPast_current_true() {
		assertTrue(myJob.filterPast().contains(current));
	}

	@Test
	public void filterPast_future_true() {
		assertTrue(myJob.filterPast().contains(future));
	}

	
}
