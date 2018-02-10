/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Job;
import model.ParkManager;
import model.User;
import user_interface.Driver;
/**
 * Test for Park Manager class.
 * 
 * @author deepjot
 *
 */
public class ParkManagerTest {
	private ParkManager myManager;
	private Job job;
	private Driver d;
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
		assertSame(d.isMaxJobAmountReached(), false);
	}
	


	/*test one fewer*/
	@Test
	public void isMaxmyManagerAmountReached_pendingmyManagersOneFewer_true() {
		assertSame(d.isMaxJobAmountReached(), false);
	}
	
	/*test exactly 20*/
	@Test
	public void isMaxmyManagerAmountReached_pendingmyManagers20_false() {
		assertSame(d.isMaxJobAmountReached(), true);
	}
	
	
	/*No myManager can be specified that takes more than the maximum number of days, default of 3*/
	/*test max number 3*/
	@Test
	public void isMaxDaysUnder_Max_true() {
		assertSame(myManager.isMaxDaysUnder(job), true);
	}

	/*test under 3*/
	@Test
	public void isMaxDaysUnder_under_true() {
		assertSame(myManager.isMaxDaysUnder(job), true);
	}

	/*test above max number 3*/
	@Test
	public void isMaxDaysUnder_over_false() {
		assertSame(myManager.isMaxDaysUnder(job), false);
	}
	
	
	@Test
	public void isMaxDays3Under_tooFar_false() {
		assertSame(myManager.isMaxDaysUnder(job), false);
	}
	@Test
	public void isMaxDays3Under_Good_false() {
		assertSame(myManager.isMaxDaysUnder(job), false);
	}
	@Test
	public void isMaxDays3Under_-----_false() {
		assertSame(myManager.isMaxDaysUnder(job), false);
	}
	

	
	
	
	
	

}
