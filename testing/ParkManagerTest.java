/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import urbanParks.Job;
import urbanParks.ParkManager;
import urbanParks.User;
/**
 * Test for Park Manager class.
 * 
 * @author deepjot
 *
 */
public class ParkManagerTest {
	private ParkManager myManager;
	private Job job;
	/*There can be more than the maximum number of pending myManagers at a time in the entire system, default of 20
	 */
	@Before
    public void setUp() {
       myManager = new ParkManager();
       job = new Job();
    }

	/*test far fewer*/
	@Test
	public void isMaxmyManagerAmountReached_pendingmyManagersFarFewer_true() {
		assertSame(myManager.isMaxJobAmountReached(), false);
	}
	


	/*test one fewer*/
	@Test
	public void isMaxmyManagerAmountReached_pendingmyManagersOneFewer_true() {
		assertSame(myManager.isMaxJobAmountReached(), false);
	}
	
	/*test exactly 20*/
	@Test
	public void isMaxmyManagerAmountReached_pendingmyManagers20_false() {
		assertSame(myManager.isMaxJobAmountReached(), true);
	}
	
	
	/*No myManager can be specified that takes more than the maximum number of days, default of 3*/
	/*test max number 3*/
	@Test
	public void isMaxDays3Under_Max_true() {
		assertSame(myManager.isMaxDays3Under(job), true);
	}

	/*test under 3*/
	@Test
	public void isMaxDays3Under_under3_true() {
		assertSame(myManager.isMaxDays3Under(job), true);
	}

	/*test above max number 3*/
	@Test
	public void isMaxDays3Under_over3_false() {
		assertSame(myManager.isMaxDays3Under(job), false);
	}

	
	
	
	

}
