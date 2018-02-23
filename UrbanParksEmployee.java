package model;

import java.io.Serializable;

public class UrbanParksEmployee extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7001992405582133870L;
	
	public UrbanParksEmployee(String theFirstName, String theLastName) {
	    super(theFirstName, theLastName, "Urban Parks Employee");
	}
	
	/*Allow the employee to change the amount of jobs in the system.*/
	//.hasnextInt()
	public static boolean changeLegalJobAmount(int newAmount) {
		//check the newAmount to see if it is a valid number. 
		if(newAmount>=0) {
			setLegalJobAmount(newAmount);
		} else {
			return false;
		}
		
		if(getLegalJobAmount() == newAmount) {
			return true;
		} else {
			return false;
		}
	}

}
