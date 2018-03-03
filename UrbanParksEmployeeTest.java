package testing;
import org.junit.Before;
import org.junit.Test;

import model.UrbanParksEmployee;

import static org.junit.Assert.*;
public class UrbanParksEmployeeTest {
    
	@Before
    public void setUp() {
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
