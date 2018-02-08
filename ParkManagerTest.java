package model;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParkManagerTest {



	@Before
	public void setUp() throws Exception {
	        ParkManager myParkManager = new ParkManager();
	        Date Today = new Date("currentDay");

	        myParkManager.createNewJob();
	        newEntry.setTitle("DayUnder");
	        


	        myParkManager.createNewJob();
	        newEntry2.setTitle("DayOf");
	        


	        myParkManager.createNewJob();
	        newEntry3.setTitle("DayOver");
	        

	    }

	}

	@Test
	public void testOneDayUnderLimit(){
		assertTrue(newEntry.setStartDay(Today + 73 Days));
		} 
		
		
	@Test
	public void testDayOfLimit(){
			assertTrue(newEntry2.setStartDay(Today + 74 Days));
			}
	
	@Test
	public void testOneDayOverLimit(){
			assertFalse(newEntry3.setStartDay(Today + 75 Days));
			}

}
