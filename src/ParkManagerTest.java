/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import java.time.LocalDate;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Job;
import model.ParkManager;

import user_interface.Driver;

/**
 * Test for Park Manager class.
 * 
 * @author Deepjot Kaur
 * @version February 11, 2018
 */
public class ParkManagerTest {
	private static final int MAX_DISTANCE = 75;
	private ParkManager myManager;
	private Driver myDriver;
	ArrayList<Job> theJobs_farFewer;
	private ArrayList<Job> theJobs_MAX;
	private ArrayList<Job> theJobs_oneFewer;
	
	/* There can be more than the maximum number of pending myManagers at a
	 * time in the entire system, default of 20
	 */
	@Before
    public void setUp() {
       myManager = new ParkManager("Deepjot", "Kaur");
       myDriver = new Driver();
       
       theJobs_farFewer = new ArrayList<Job>();
       theJobs_oneFewer = new ArrayList<Job>();
       theJobs_MAX = new ArrayList<Job>();
       
       //create all of the jobs.
       Job job1 = new Job("Gas Works Park", "Pick up trash", "Seattle",
				LocalDate.of(2018, 3, 4), LocalDate.of(2018, 3, 4));
		theJobs_farFewer.add(job1);
		theJobs_oneFewer.add(job1);
		theJobs_MAX.add(job1);
		
		Job job2 = new Job("Alki Beach", "Picking up litter", "Seattle",
				LocalDate.of(2018, 3, 19), LocalDate.of(2018, 3, 20));
		theJobs_farFewer.add(job2);
		theJobs_oneFewer.add(job2);
		theJobs_MAX.add(job2);
		
		Job job3 = new Job("Seahurst Beach", "Cleaning trails", "Burien",
				LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 20));
		theJobs_farFewer.add(job3);
		theJobs_oneFewer.add(job3);
		theJobs_MAX.add(job3);
		
		Job job4 = new Job("Lake Meridian", "Trimming Trees and shrubs, "
				+ "mowing the grass", "Kent", LocalDate.of(2018, 2, 22),
				LocalDate.of(2018, 2, 24));
		theJobs_farFewer.add(job4);
		theJobs_oneFewer.add(job4);
		theJobs_MAX.add(job3);
		
		Job job5 = new Job("Wapato Park", "Setting up for events", "Tacoma",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_farFewer.add(job5);
		theJobs_oneFewer.add(job5);
		theJobs_MAX.add(job5);
		
		Job job6 = new Job("Point Defiance Park", "Cleaning trails", "Tacoma",
				LocalDate.of(2018, 2, 12), LocalDate.of(2018, 2, 12));
		theJobs_farFewer.add(job6);
		theJobs_oneFewer.add(job6);
		theJobs_MAX.add(job6);
		
		Job job7 = new Job("Jefferson Park", "Set up for events", "Tacoma",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_farFewer.add(job7);
		theJobs_oneFewer.add(job7);
		theJobs_MAX.add(job7);
		
		Job job8 = new Job("Discovery Park", "Clean up beaches", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_farFewer.add(job8);
		theJobs_oneFewer.add(job8);
		theJobs_MAX.add(job8);
		
		Job job9 = new Job("Kerry Park", "Clean up trash", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job9);
		theJobs_MAX.add(job9);
		
		Job job10 = new Job("Seahurst Park", "Clean up beaches", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job10);
		theJobs_MAX.add(job10);
		
		Job job11 = new Job("Magnuson Park", "Clean up beaches", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job11);
		theJobs_MAX.add(job11);
		
		Job job12 = new Job("Lincoln Park", "Clean up beaches", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job12);
		theJobs_MAX.add(job12);
		
		Job job13 = new Job("Carkeek Park", "Clean up shrubs", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job13);
		theJobs_MAX.add(job13);
		
		Job job14 = new Job("WaterFront Park", "Clean up trash", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job14);
		theJobs_MAX.add(job14);
		
		Job job15 = new Job("Seattle Japanees gard", "Plant trees", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job15);
		theJobs_MAX.add(job15);
		
		Job job16 = new Job("Olympic Sculpture Park", "Plant trees", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job16);
		theJobs_MAX.add(job16);
		
		Job job17 = new Job("Mrytle Edwards Park", "paint tables", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job17);
		theJobs_MAX.add(job17);
		
		Job job18 = new Job("Seaward Park", "Plant trees", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job18);
		theJobs_MAX.add(job18);
		
		Job job19 = new Job("Kubota", "Clean shrubs", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_oneFewer.add(job19);
		theJobs_MAX.add(job19);
		
		Job job20 = new Job("Seattle Japanees gard", "Plant trees", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		theJobs_MAX.add(job20);
    }

	/* test far fewer jobs */
	@Test
	public void isJobAmountLegal_FarFewer_true() {
		assertTrue(myDriver.isJobsAmountLegal(theJobs_farFewer));
	}

	/* test one fewer jobs */
	@Test
	public void isMaxmyManagerAmountReached_OneFewer_true() {
		assertTrue(myDriver.isJobsAmountLegal(theJobs_oneFewer));
	}
	
	/* test exactly 20 jobs */
	@Test
	public void isMaxmyManagerAmountReached_Max_false() {
		assertFalse(myDriver.isJobsAmountLegal(theJobs_MAX));
	}
	
	
	/*No myManager can be specified that takes more than the maximum number of 
	 * days, default of 3*/
	/*test max number 3*/
	@Test
	public void isMaxDaysUnder_Max_true() {
		assertTrue(myManager.isMaxDaysUnder(LocalDate.of(2018, 3, 9), 
				LocalDate.of(2018, 3, 9)));
	}

	/* test under 3 days */
	@Test
	public void isMaxDaysUnder_under_true() {
		assertTrue(myManager.isMaxDaysUnder(LocalDate.of(2018, 3, 9), 
				LocalDate.of(2018, 3, 9)));
	}

	/* test above max number 3 days */
	@Test
	public void isMaxDaysUnder_over_false() {
		assertFalse(myManager.isMaxDaysUnder(LocalDate.of(2018, 3, 9), 
				LocalDate.of(2018, 3, 15)));
	}
	
	/* test if job date is too far */
	@Test
	public void isJobTooFar_OneFar_false() {
		LocalDate OneFar = LocalDate.now().plusDays(MAX_DISTANCE+1);
		assertFalse(myManager.isJobNotTooFar(OneFar));
	}
	
	/*test for one fewer faraway job day */
	@Test
	public void isJobTooFar_OneFewer_True() {
		LocalDate OneFewer= LocalDate.now().plusDays(MAX_DISTANCE-1);
		assertTrue(myManager.isJobNotTooFar(OneFewer));
	}
	
	/* test for if the day is not too far away */
	@Test
	public void isJobTooFar_MaxDistance_True() {
		LocalDate max = LocalDate.now().plusDays(MAX_DISTANCE);
		assertTrue(myManager.isJobNotTooFar(max));
		//System.out.println(ChronoUnit.DAYS.between(LocalDate.of
		//(2018, 9, 03), LocalDate.of(2018, 13, 03)));
	}
}
