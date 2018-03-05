package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UrbanParksEmployee extends User implements Serializable {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 7001992405582133870L;
		
		private List<Job> myListedJobs;
		
		public UrbanParksEmployee(String theFirstName, String theLastName) {
		    super(theFirstName, theLastName, "Urban Parks Employee");
		}
		
		/*Allow the employee to change the amount of jobs in the system.*/
		//.hasnextInt()
		public static boolean changeLegalJobAmount(int newAmount) {
			//check the newAmount to see if it is a valid number. 
			if(newAmount>=0) {
				Job.setLegalJobAmount(newAmount);
			} else {
				return false;
			}
			
			if(Job.getLegalJobAmount() == newAmount) {
				return true;
			} else {
				return false;
			}
		}
		
		/**

		 * precondition: 

		 * postcondition: non-null Jobs related to Park Manager are returned.

		 * 

		 * @return 

		 */

		public ArrayList<Job> getJobs() {

			ArrayList<Job> listedJobs = new ArrayList<Job>(myListedJobs);

			

			return listedJobs;

		}

	}


