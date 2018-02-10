package model;


public abstract class User {	
	
	private String myUserName;
	private String myFirstName;
	private String myLastName;
	private String myType;
	//private String myBirthdate;
	//private String myEmail;
	//private int myPhone;
	//private int myAge;
	
	public User(String theUserName, String theFirstName,
	                String theLastName, String theType) {
		this.myUserName = theUserName;
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
	
	public void setUserName(String theUserName){
		this.myUserName = theUserName;
	}
	
	public String getUserName(){
		return this.myUserName;
	}
	
	
	/* Have user enter full name in one step. Ex:"Luke Manca" */
	public void setName(String theName){
		this.myFirstName = theName.split(" ")[0];
		this.myLastName = theName.split(" ")[1];
	}
	
	public String getName(){
		return this.myFirstName + " " + this.myLastName; 
	}
	
	@Override
	public String toString() {
		return getName() + " " + getType();
	}
	
	/*
	public void setBirthdate(String theDate){
		this.myBirthdate = theDate;
	}
	
	public String getBirthdate(){
		return this.myBirthdate;
	}
	
	
	
	public void setEmail(String theEmail){
		this.myEmail = theEmail;
	}
	
	public String getEmail(){
		return this.myEmail;
	}
	
	
	
	public void setPhone(int theNumber){
		this.myPhone = theNumber;
	}
	
	public int getPhone(){
		return this.myPhone;
	}
	
	
	
	public void setAge(int theAge){
		this.myAge = theAge;
	}
	
	public int getAge(){
		return this.myAge;
	}
	*/
}
