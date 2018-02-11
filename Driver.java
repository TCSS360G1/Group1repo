package user_interface;



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.AlreadySignedUpException;
import model.Job;
import model.MinimumDaysException;
import model.ParkManager;
import model.ScheduleConflictException;
import model.User;
import model.Volunteer;



/**

 * The User Interface for the program.

 * This class will have methods to display to the console.

 * @author Jenzel Villanueva

 * @version February 9, 2018

 */
public class Driver {
	
	private static final int MAX_JOBS_IN_SYSTEM = 20;
	static Scanner user = new Scanner(System.in);

	/*The initial display. this will decide if the user is a volunteer or a PM
	 *then will call methods to display the correct menus for type.*/
	
	public static void signIn(ArrayList<User> theUsers, 
			ArrayList<Job> theJobs) {
	    System.out.println("Type 'exit' to exit sign in.\n");
		System.out.print("-Sign in-\nFirst and last name "
		                + "(separated by a space): ");
		
		String name = user.nextLine();
		boolean userFound = false;
		if (name.equals("exit")) {
		    //Dummy branch
		} else {
    		for(int i = 0; i<theUsers.size(); i++) {
    			if (theUsers.get(i).getName().equals(name)) {
    				userFound = true;
    				if(theUsers.get(i).getType().equals("Manager")) {
    					ParkManager myManager = (ParkManager) (theUsers.get(i));
    					System.out.print("\n-Welcome, Manager: "+ 
    						theUsers.get(i).getFirst()+ " " + 
    					                theUsers.get(i).getLast() + "\n");
    					showParkManagerMenu(myManager, theUsers, theJobs);
    					
    				} else if(theUsers.get(i).getType().equals("Volunteer")) {
    					System.out.print("\n-Welcome, Volunteer: "+ 
    							theUsers.get(i).getFirst()+ " " + 
    					                theUsers.get(i).getLast() + "\n");
    					Volunteer myVolunteer = (Volunteer) (theUsers.get(i));
    					showVolunteerMenu(myVolunteer, theUsers, theJobs);
    				}
    			}
    		}
		}
		if (userFound == false && !name.equals("exit")) {
            signIn(theUsers, theJobs);
		}
	}

	
	/**Shows volunteers menu. 3 options to choose from and shows 
	 * the users job info.
	 * @param- theVolunteer- the volunteer that has signed in.
	 */
	public static void showVolunteerMenu(Volunteer theVolunteer, 
			ArrayList<User> theUsers, ArrayList<Job> theJobs) {
		
		System.out.println("1. View jobs volunteered for.");
		System.out.println("2. Sign Up for upcoming jobs.");
		System.out.println("3. Sign Out of account.");
		
		String choice = user.next();
		if (choice.equals("1")) {
			ArrayList<Job> volunteerJobs = theVolunteer.getJobs();
			if (volunteerJobs.isEmpty()) {
			    System.out.println("No jobs signed up for!\n");
			    showVolunteerMenu(theVolunteer, theUsers, theJobs);
			} else {
			    for (int i = 0; i < volunteerJobs.size(); i++) {
			        System.out.println((i+1)+ ". " +
                                volunteerJobs.get(i).getTitle() + " At: " +
                                volunteerJobs.get(i).getLocation() +" " +
                                volunteerJobs.get(i).getStartDate() + " To " +
                                volunteerJobs.get(i).getEndDate() +
                                " Description: " +
                                volunteerJobs.get(i).getDescription());
			    }
			    System.out.println();
			    showVolunteerMenu(theVolunteer, theUsers, theJobs);
			}
		} else if (choice.equals("2")) {
			volunteerSignUpForJob(theVolunteer, theUsers, theJobs);
		} else if (choice.equals("3")) {
		    user.nextLine();
			signIn(theUsers, theJobs);
		} else {
			System.out.println("You did not input a valid answer so the "
					+ "menu will be displayed again.\n");
			showVolunteerMenu(theVolunteer, theUsers, theJobs);
		}
	}
	

	public static void showParkManagerMenu(ParkManager theManager, 
			ArrayList<User> theUsers, ArrayList<Job> theJobs) {
		System.out.println("Please choose from one of the following (1-3): ");
		
		System.out.println("1. View current active jobs.");
		System.out.println("2. Create a new park job.");
		System.out.println("3. Sign Out of account.");
		System.out.println("Please type a number between 1 and 3: ");
		String choice = user.nextLine();
		
		
		if (choice.equals("1")) {
			
			System.out.println("Here are all of the current Jobs in the System,"
					+ " you will be re-directed to the main menu: ");
			for (int i = 0; i < theJobs.size(); i++) {
				
			    System.out.println((i+1)+ ". " + theJobs.get(i).getTitle()+ 
			                    " At: " +
			    			theJobs.get(i).getLocation() +" " +
			                theJobs.get(i).getStartDate() + " To " +
			                theJobs.get(i).getEndDate() + " Description: " +
			                theJobs.get(i).getDescription());
			} 
			System.out.println();
			showParkManagerMenu(theManager, theUsers, theJobs);
		} else if (choice.equals("2")) {
			//add all of this to the collection. 
			if(isJobsAmountLegal(theJobs)) {
				newParkJob(theManager, theUsers, theJobs);
			}
			else {
				System.out.println("Sorry, we are currently filled with the max"
						+ " amount of jobs, please check back in tomorrow.");
			}
			
		} else if (choice.equals("3")) {
			signIn(theUsers, theJobs);
		} else {
			System.out.println("You did not input a valid answer so the menu "
					+ "will be displayed again.");
			showParkManagerMenu(theManager, theUsers, theJobs);
		}
	}


	/*Allows Volunteer to sign up for a job.*/
	public static void volunteerSignUpForJob(Volunteer theVolunteer, 
			ArrayList<User> theUsers, ArrayList<Job> theJobs) {
		System.out.println("\nHere are all of the jobs that are available. "
				+ "Please choose which job you want by typing a number.\n");
		for (int i = 0; i < theJobs.size(); i++) {
		    System.out.println((i + 1) + ")" + "Location:  " +
		                theJobs.get(i).getTitle()+ " " + "Date:  " +
		                theJobs.get(i).getStartDate() + " To " +
		                theJobs.get(i).getEndDate() + " Description:  " +
		                theJobs.get(i).getDescription());
		}

		System.out.println("\n-Which job would you like to sign up for? "
		                   + "0 to exit to main menu.");
		int value = user.nextInt() - 1;
		if (value == -1)
		    showVolunteerMenu(theVolunteer, theUsers, theJobs);
		else {
    		try {
    		    theVolunteer.addJob(theJobs.get(value));
    		    System.out.println("-You have successfully "
    		                       + "signed up for this job-");
    		} catch (AlreadySignedUpException ex) {
    		    System.out.println("Sorry, you have already" +
    		                       " signed up for that job");
    		    volunteerSignUpForJob(theVolunteer, theUsers, theJobs);
    		} catch (MinimumDaysException ec) {
    		    System.out.println("Sorry, that job is too close. We ask " + 
    		                      "That jobs are signed up for no sooner than "+ 
    		                      Volunteer.MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP +
    		                      " Days out");
    		    volunteerSignUpForJob(theVolunteer, theUsers, theJobs);
    		} catch (ScheduleConflictException ed) {
    		    System.out.println("Sorry, looks like that jobs' "
    		                       + "dates conflict " +
    		                       "with one of your current ones.");
    		    volunteerSignUpForJob(theVolunteer, theUsers, theJobs);
    		}
    
    		showVolunteerMenu(theVolunteer, theUsers, theJobs);
		}
	}
	
	
	/*Asks for information for a new job. Checks to see if the job length is 
	 * max days or under.
	 * checks to see if the job is not too far away,
	 * and checks to see how many jobs there are.*/
	public static void newParkJob(ParkManager theManager, 
			ArrayList<User> theUsers, ArrayList<Job> theJobs) {
		
		System.out.println("-Please provide a job title-");
		System.out.print("Job Title: ");
		String t = user.nextLine();
		while(t.isEmpty()) {
			System.out.println("-Please provide a VALID job title-");
			System.out.print("Job Title: ");
			t = user.nextLine();
		}
		
		System.out.println("-Please provide a job location-");
		System.out.print("Job Location: ");
		String l = user.nextLine();
		while(l.isEmpty()){
			System.out.println("-Please provide a VALID job location-");
			System.out.print("Job Location: ");
			l = user.nextLine();
		}
		
		System.out.println("-What is the starting date for this job?-");
		System.out.print("Date (MM/DD/YYYY): ");
		String s = user.nextLine();
		while(s.isEmpty()){
			System.out.println("-Please provide a VALID job starting date-");
			System.out.print("Date (MM/DD/YYYY): ");
			s = user.nextLine();
		}
		String[] dateArray = s.split("/");
		LocalDate start = LocalDate.of(Integer.parseInt(dateArray[2]), 
				Integer.parseInt(dateArray[0]), 
				Integer.parseInt(dateArray[1]));
		
		while(!theManager.isJobNotTooFar(start)) { 
			
			//while this is false. ask for a new input
			System.out.println("This date is too far. Please input a date that "
					+ "is closer.");
			System.out.print("Date (MM/DD/YYYY): ");
			s = user.nextLine();
			dateArray = s.split("/");
			start = LocalDate.of(Integer.parseInt(dateArray[2]), 
					Integer.parseInt(dateArray[0]), 
					Integer.parseInt(dateArray[1]));
		}

		System.out.println("-What is the ending date for this job?-");
		System.out.print("Date (MM/DD/YYYY): ");
		String e = user.nextLine();
		while(e.isEmpty()){
			System.out.println("-Please provide a VALID job ending date-");
			System.out.print("Date (MM/DD/YYYY): ");
			e = user.nextLine();
		}
		LocalDate end;
		String[] dateArray2 = e.split("/");
		end = LocalDate.of(Integer.parseInt(dateArray2[2]), 
				Integer.parseInt(dateArray2[0]), 
				Integer.parseInt(dateArray2[1]));
		while(!theManager.isMaxDaysUnder(start, end)) {
			System.out.println("Please limit your job to 3 days or under.");
			System.out.print("Date (MM/DD/YYYY): ");
			e = user.nextLine();
			dateArray2 = e.split("/");
			end = LocalDate.of(Integer.parseInt(dateArray2[2]), 
					Integer.parseInt(dateArray2[0]), 
					Integer.parseInt(dateArray2[1]));
		}
		
		System.out.println("-Please provide a job description-");
		System.out.print("Job Description: ");
		String d = user.nextLine();
		while(d.isEmpty()){
			System.out.println("-Please provide a valid job description-");
			System.out.print("Job Description: ");
			d = user.nextLine();
		}
		Job newJob = new Job(t,d,l, start, end);
		System.out.println("-This job has been created-");

		System.out.println(newJob.toString());
		theJobs.add(newJob);
		showParkManagerMenu(theManager, theUsers, theJobs);
	}
	
	
	/*
	 * If the size of the jobs is greater than the max amount that there can 
	 * be return false.
	 * else return true.
	 * */
	public static boolean isJobsAmountLegal(ArrayList<Job> theJobs) {
		if(theJobs.size() >= MAX_JOBS_IN_SYSTEM) {
			return false;
		} else {
			return true;
		}
	}
}