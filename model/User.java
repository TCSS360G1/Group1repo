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
	public static int myLegalJobAmount;
	// private String myBirthdate;
	// private String myEmail;
	// private int myPhone;
	// private int myAge;
    
	public User(String theFirstName, String theLastName, String theType) {
		this.myFirstName = theFirstName;
		this.myLastName = theLastName;
		this.myType = theType;
	}
	
	/* Empty constructor for a User.*/
	public User() {
	    
	}
	
	public String getFirstName() {
		return this.myFirstName;
	}
	
	public void setFirstName(String theFirst) {
		this.myFirstName = theFirst;		
	}
	
	public String getLastName() {
		return this.myLastName;
	}
	
	public void setLastName(String theLast) {
		this.myLastName = theLast;
	}
	
	public String getName(){
		return this.myFirstName + " " + this.myLastName; 
	}
	
	public void setName(String theName){
		this.myFirstName = theName.split(" ")[0];
		this.myLastName = theName.split(" ")[1];
	}
	
	public String getType() {
		return this.myType;
	}
	
	public void setType(String theType){
		this.myType = theType;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getType();
	}
	
	public static void setLegalJobAmount(int theLegalJobAmount) {
		myLegalJobAmount = theLegalJobAmount;
	}
	
	public static int getLegalJobAmount() {
		return myLegalJobAmount;
	}
}