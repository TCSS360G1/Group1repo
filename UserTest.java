import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	SignIn users;
	
	@Before
    public void setUp() {
        users = new SignIn();
    }
	
	@Test
	public void isStaffMember_ExistingUserGiven_ShouldReturnTrue() {
		User existingUser = users.checkUserExists("harmelody2897");
		User givenStaffMemberUser = existingUser;
		
		assertTrue(existingUser.isStaffMember(givenStaffMemberUser));
	}
	
	@Test
	public void isStaffMember_ExistingUserGiven_ShouldReturnFalse() {
		User existingUser = users.checkUserExists("potatOS360");
		User givenNonStaffMemberUser = existingUser;
		
		assertFalse(existingUser.isStaffMember(givenNonStaffMemberUser));
	}
	
	@Test
	public void isParkManager_ExistingUserGiven_ShouldReturnTrue() {
		User existingUser = users.checkUserExists("cjohnson2");
		User givenParkManagerUser = existingUser;
		
		assertTrue(existingUser.isParkManager(givenParkManagerUser));
	}
	
	@Test
	public void isParkManager_ExistingUserGiven_ShouldReturnFalse() {
		User existingUser = users.checkUserExists("potatOS360");
		User givenNonParkManagerUser = existingUser;
		
		assertFalse(existingUser.isStaffMember(givenNonParkManagerUser));
	}
	
	@Test
	public void isVolunteer_ExistingUserGiven_ShouldReturnTrue() {
		User existingUser = users.checkUserExists("Stanley427");
		User givenVolunteerUser = existingUser;
		
		assertTrue(existingUser.isVolunteer(givenVolunteerUser));
	}
	
	@Test
	public void isVolunteer_ExistingUserGiven_ShouldReturnFalse() {
		User existingUser = users.checkUserExists("potatOS360");
		User givenNonVolunteerUser = existingUser;
		
		assertFalse(existingUser.isStaffMember(givenNonVolunteerUser));
	}

}
