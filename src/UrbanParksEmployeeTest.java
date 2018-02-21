package testing;
import org.junit.Before;
import org.junit.Test;

import model.UrbanParksEmployee;
import model.User;
import model.Volunteer;

import static org.junit.Assert.*;
public class UrbanParksEmployeeTest {
	static UrbanParksEmployee employeeDoesntMatter;
	@Before
    public void setUp() {
		employeeDoesntMatter = new UrbanParksEmployee("Frank", "Sinatra");
		
	}
	
	@Test
	public void viewAllJobs_something_shouldReturnSomething() {
		// TODO: Test for viewing all jobs between certain start and end date.
		// As Urban Parks staff, I want to view all jobs between a start
		// and end date (inclusive), which might be in the past.
		
	}
	
	/*NEW METHOD by Jenzel Villanueva*/
	@Test
	public void identifyUrbanParksEmployee_validUrbanParksEmployeeUser_True() {
		assertTrue(employeeDoesntMatter.identifyUrbanParksEmployee(employeeDoesntMatter));
	}
	
	@Test
	public void changeJobAmount_zero_true() {
		assertTrue(UrbanParksEmployee.changeLegalJobAmount(0));
	}
	@Test
	public void changeJobAmount_negative_false() {
		assertFalse(UrbanParksEmployee.changeLegalJobAmount(-1));
	}
	@Test
	public void changeJobAmount_positive_true() {
		assertTrue(UrbanParksEmployee.changeLegalJobAmount(5));
	}
	@Test
	public void changeJobAmount_nonInteger_false() {
		assertFalse(UrbanParksEmployee.changeLegalJobAmount(0));
	}
	

}
