package model;

import java.io.Serializable;

public class UrbanParksEmployee extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UrbanParksEmployee(String theFirstName, String theLastName) {
	    super(theFirstName, theLastName, "Urban Parks Employee");
	}
	
	public static void viewStartDate() {
		// TODO: View all jobs between a start and end date.
	}
	
	/*NEW METHOD by Jenzel Villanueva*/
	public static boolean identifyUrbanParksEmployee(User theEmployee) {
		boolean isEmployee = false;
		
		if (theEmployee.getType().equals("Urban Parks Employee")) {
			System.out.print("\n-Welcome, Urban Parks Employee: "
					+ theEmployee.getFirstName() + " "
					+ theEmployee.getLastName() + "\n");
		
			isEmployee = true;
		}
		
		return isEmployee;
	}
	
	/*Allow the employee to change the amount of jobs in the system.*/
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
