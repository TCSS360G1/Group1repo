package model;


public abstract class User {	
	
	private String userName;
	private String firstName;
	private String lastName;
	private String birthdate;
	private String email;
	private int phone;
	private int age;
	private String credentials;
	private String workload;    //Do we need to have the user specify their potential workload for their account?
								//Could have user choose which workload to sign up for within job sign up. 
	

	
	public void setUserName(String theUserName){
		this.userName = theUserName;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	
	/* Have user enter full name in one step. Ex:"Luke Manca" */
	public void setName(String theName){
		this.firstName = theName.split(" ")[0];
		this.lastName = theName.split(" ")[1];
	}
	
	public String getName(){
		return this.firstName + " " + this.lastName; 
	}
	
	
	
	public void setBirthdate(String theDate){
		this.birthdate = theDate;
	}
	
	public String getBirthdate(){
		return this.birthdate;
	}
	
	
	
	public void setEmail(String theEmail){
		this.email = theEmail;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	
	
	public void setPhone(int theNumber){
		this.phone = theNumber;
	}
	
	public int getPhone(){
		return this.phone;
	}
	
	
	
	public void setAge(int theAge){
		this.age = theAge;
	}
	
	public int getAge(){
		return this.age;
	}
	
	
	
	public void setWorkload(String theWorkload){
		this.workload = theWorkload;
	}
	
	public String getWorkload(){
		return this.workload;
	}
}
