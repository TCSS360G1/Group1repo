package model;

import java.io.Serializable;

/**
 * This abstract class represents a User in the Urban Parks System.
 * 
 * @author Luke Manca
 * @version February 11, 2018
 */
public abstract class User implements Serializable{
    private static final long serialVersionUID = 1L;

    /* Fields */
    // private String myUsername;
	private String myFirstName;
	private String myLastName;
	private String myType;
	// private String myBirthdate;
	// private String myEmail;
	// private int myPhone;
	// private int myAge;
	
	/**
	 * The constructor for a User, containing its first name, last name,
	 * and what type of user it us.
	 * 
	 * @param theFirstName the first name of the User.
	 * @param theLastName the last name of the User.
	 * @param theType the member type of the User.
	 */
	public User(String theFirstName, String theLastName, String theType) {
		this.myFirstName = theFirstName;
		this.myLastName = theLastName;
		this.myType = theType;
	}
	
	/**
	 * Empty constructor for a User.
	 */
	public User() {
	    
	}
	
	/**
	 * Gets the User's first name.
	 * 
	 * @return the User's first name as a String.
	 */
	public String getFirstName() {
		return this.myFirstName;
	}
	
	/**
	 * Sets the first name for the User.
	 * 
	 * @param theFirst the first name of the User.
	 */
	public void setFirstName(String theFirst) {
		this.myFirstName = theFirst;		
	}
	
	/**
	 * Gets the User's last name.
	 * 
	 * @return the User's last name as a String.
	 */
	public String getLastName() {
		return this.myLastName;
	}
	
	/**
	 * Sets the last name for the User.
	 * 
	 * @param theLast the last name of the User.
	 */
	public void setLastName(String theLast) {
		this.myLastName = theLast;
	}
	
	/**
	 * Gets the combined first name and last name of a User.
	 * 
	 * @return the User's full name as a String.
	 */
	public String getName(){
		return this.myFirstName + " " + this.myLastName; 
	}
	
	/**
	 * Have the User enter full name in one step. Ex:"Luke Manca"
	 * 
	 * @param theName the first and last name of the User.
	 */
	public void setName(String theName){
		this.myFirstName = theName.split(" ")[0];
		this.myLastName = theName.split(" ")[1];
	}
	
	/**
	 * Gets the member type of the User.
	 * 
	 * @return the type of User as a String.
	 */
	public String getType() {
		return this.myType;
	}
	
	/**
	 * Sets the member type that the User is. Ex: "Park Manager"
	 * 
	 * @param theType the member type of the User.
	 */
	public void setType(String theType){
		this.myType = theType;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getType();
	}
	
}