/**
 * 
 */
package testing;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.ParkManager;
import model.UrbanParksEmployee;
import model.User;
import model.UserCollection;
import model.Volunteer;
/**
 * @author deepjot
 *
 */
public class UserCollectionTest {
	private static User a;
	private static User b;
	private static User c;
	private static ArrayList<User> myUsers;
	/**
	 * 
	 */
	public UserCollectionTest() {
		myUsers = new ArrayList<>();
		a = new ParkManager("Deepjot", "Kaur");
		b = new UrbanParksEmployee("Luke", "Manca");
		c = new Volunteer("Jenzel", "Villanueva");
		
	}
	@Before
    public void setup() {
		myUsers.add(a);
		myUsers.add(b);
		myUsers.add(c);
	}
	@Test
	public void clearUsers_True(){
		
		UserCollection.clearUsers();
		int y = UserCollection.getSize();
		assertTrue(y==0);
	}

}
