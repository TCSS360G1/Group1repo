/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
	private static final int MAX_DISTANCE = 75;
	private ParkManager myManager;
	/*There can be more than the maximum number of pending myManagers at a
	 *  time in the entire system, default of 20
	 */
	@Before
    public void setUp() {
       myManager = new ParkManager("Deepjot", "Kaur");
      
    }

//	/*test far fewer*/
//	@Test
//	public void isMaxmyManagerAmountReached_pendingmyManagersFarFewer_true() {
//		assertSame(driver.isMaxJobAmountReached(), false);
//	}
//	
//
//
//	/*test one fewer*/
//	@Test
//	public void isMaxmyManagerAmountReached_pendingmyManagersOneFewer_true() {
//		assertSame(driver.isMaxJobAmountReached(), false);
//	}
//	
//	/*test exactly 20*/
//	@Test
//	public void isMaxmyManagerAmountReached_pendingmyManagers20_false() {
//		assertSame(driver.isMaxJobAmountReached(), true);
//	}
	
	
	/*No myManager can be specified that takes more than the maximum number of 
	 * days, default of 3*/
	/*test max number 3*/
	@Test
	public void isMaxDaysUnder_Max_true() {
		assertTrue(myManager.isMaxDaysUnder(LocalDate.of(2018, 3, 9), 
				LocalDate.of(2018, 3, 9)));
	}

	/*test under 3*/
	@Test
	public void isMaxDaysUnder_under_true() {
		assertTrue(myManager.isMaxDaysUnder(LocalDate.of(2018, 3, 9), 
				LocalDate.of(2018, 3, 9)));
	}

	/*test above max number 3*/
	@Test
	public void isMaxDaysUnder_over_false() {
		assertFalse(myManager.isMaxDaysUnder(LocalDate.of(2018, 3, 9), 
				LocalDate.of(2018, 3, 15)));
	}
	
	/**/
	@Test
	public void isJobTooFar_OneFar_false() {
		LocalDate OneFar = LocalDate.now().plusDays(MAX_DISTANCE+1);
		assertFalse(myManager.isJobNotTooFar(OneFar));
	}
	/**/
	@Test
	public void isJobTooFar_OneFewer_True() {
		LocalDate OneFewer= LocalDate.now().plusDays(MAX_DISTANCE-1);
		assertTrue(myManager.isJobNotTooFar(OneFewer));
	}
	/**/
	@Test
	public void isJobTooFar_MaxDistance_True() {
		LocalDate max = LocalDate.now().plusDays(MAX_DISTANCE);
		assertTrue(myManager.isJobNotTooFar(max));
		//System.out.println(ChronoUnit.DAYS.between(LocalDate.of
		//(2018, 9, 03), LocalDate.of(2018, 13, 03)));
	}
	

	
	
	
	
	

}
