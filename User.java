package model;


public abstract class User {	
	
	//private String myUserName;
	private String myFirstName;
	private String myLastName;
	private String myType;
	//private String myBirthdate;
	//private String myEmail;
	//private int myPhone;
	//private int myAge;
	
	public User(String theFirstName, String theLastName, String theType) {
		this.myFirstName = theFirstName;
		this.myLastName = theLastName;
		this.myType = theType;
	}
	
	public void setType(String theType){
		this.myType = theType;
	}
	public String getType() {
		return this.myType;
	}
	
	/* Have user enter full name in one step. Ex:"Luke Manca" */
	public void setName(String theName){
		this.myFirstName = theName.split(" ")[0];
		this.myLastName = theName.split(" ")[1];
	}
	
	public String getName(){
		return this.myFirstName + " " + this.myLastName; 
	}
	public String getFirst() {
		return this.myFirstName;
	}
	public String getLast() {
		return this.myLastName;
	}
	public void setFirst(String theFirst) {
		this.myFirstName = theFirst;		
	}
	public void setLast(String theLast) {
		this.myLastName = theLast;
	}
	@Override
	public String toString() {
		return getName() + " " + getType();
	}
	
	
}