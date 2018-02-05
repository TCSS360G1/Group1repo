import java.io.Serializable;

/**
 * User Object which contains username, name, and type.
 * 
 * @author Jenzel Villanueva
 * @version February 4, 2018
 */

public class User implements Serializable {
	
	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = 441840138167609100L;
	
	public String username;
	public String name;
	public String type;
    
	/**
	 * Constructor sets up User's username, name, and member type.
	 * @param un the User's username.
	 * @param nm the User's name.
	 * @param tp the User's member type.
	 */
    public User(String un, String nm, String tp) {
    	this.username = un;
    	this.name = nm;
    	this.type = tp;
    }
    
    /**
     * Gets the User's username.
     */
    public String getUsername() {
    	return username;
    }
    
    /**
     * Gets the User's name.
     */
    public String getName() {
    	return name;
    }
    
    /**
     * Gets the User's member type.
     */
    public String getType() {
    	return type;
    }
    
    /**
     * Sets the User's username.
     * 
     * @param tp The User's username.
     */
    public void setUsername(String un) {
    	username = un;
    }
    
    /**
     * Sets the User's name.
     * 
     * @param tp The User's name to set.
     */
    public void setName(String nm) {
    	name = nm;
    }
    
    /**
     * Sets the User member type.
     * 
     * @param tp The User member type to set.
     */
    public void setType(String tp) {
    	type = tp;
    }
    
    /**
	 * Check to see if a User is a Park Manager.
	 * 
	 * @param candidateUser the User being checked.
	 * @return true if User is a Park Manager, false otherwise.
	 */
	public boolean isParkManager(User candidateUser) {
        boolean typeMatch = false;
		
		if (candidateUser.type.equals("Park Manager")) {
        	typeMatch = true;
        	
        }
		return typeMatch;
	}
	
	/**
	 * Check to see if a User is a Staff Member.
	 * 
	 * @param candidateUser the User being checked.
	 * @return true if User is a Staff Member, false otherwise.
	 */
	public boolean isStaffMember(User candidateUser) {
        boolean typeMatch = false;
		
		if (candidateUser.type.equals("Staff Member")) {
        	typeMatch = true;
        	
        }
		return typeMatch;
	}
	
	/**
	 * Check to see if a User is a Volunteer.
	 * 
	 * @param candidateUser the User being checked.
	 * @return true if User is a Volunteer, false otherwise.
	 */
	public boolean isVolunteer(User candidateUser) {
        boolean typeMatch = false;
		
		if (candidateUser.type.equals("Volunteer")) {
        	typeMatch = true;
        	
        }
		return typeMatch;
	}
    
}
