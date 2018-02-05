import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * SignIn Object uses to check if a User exists from a given username
 * from keyboard input.
 * 
 * @author Jenzel Villanueva
 * @version February 4, 2018
 */

public class SignIn implements Serializable {
	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = 8462426474036696155L;
	
	Collection<User> myUsers = new HashSet<User>();
	
	/**
	 * Creates new existing Users.
	 */
	public SignIn() {
		myUsers.add(new User("Stanley427", "Stanley", "Volunteer"));
        myUsers.add(new User("harmelody2897", "Harmony", "Staff Member"));
        myUsers.add(new User("cjohnson2", "Cave", "Park Manager"));
        myUsers.add(new User("potatOS360", "Aotuto", "Not Any 3"));
	}
	
	/**
	 * Checks to see if the User exists, and returns the User if true.
	 * Otherwise, null is returned.
	 * 
	 * @param username the Username of the User in question.
	 * @return the User that matches the given Username.
	 */
	public User checkUserExists(String username) {
		User userMatch = null;
		
		for (User user : myUsers) {
	        if (username.equals(user.getUsername())) {
	        	userMatch = user;
	        }
	    }
		return userMatch;
	}
	
	/**
	 * Checks the Type of the User, in order to identify them properly.
	 * 
	 * @param candidateUser The User subject to be greeted.
	 * @return the String memper type of the user.
	 */
    public String checkType(User candidateUser) {
        String typeMatch = "No Title or Access";
        System.out.print("-Fetching information-\n...\n");
        
    	    for (User user : myUsers) {
    	    	if (user.isParkManager(candidateUser)
    	    			|| user.isStaffMember(candidateUser)
    	    			|| user.isVolunteer(candidateUser)) {
    	    		typeMatch = "Welcome, " + candidateUser.getType()
    	    				+ " " + candidateUser.getName();
    	    	}
    	    }
    	
        return "-" + typeMatch + "-";
    }
}
