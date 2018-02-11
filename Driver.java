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
	
	static Scanner user = new Scanner(System.in);

	/*The initial display. this will decide if the user is a volunteer or a PM
	 *then will call methods to display the correct menus for type.*/
	public static void signIn() {System.out.print("-Sign in-\nFULL NAME: ");

		String username = user.next();

		// TODO: Check if User exists
		System.out.println("-Fetching information-\n...\n");

		if(type == "Park Manager") {
			ParkManager myManager = new ParkManager();/////////////add constructor fields once the collections have been created.
			System.out.print("-Welcome, ");
			showParkManagerMenu(myManager);
		} else if(type == "Volunteer") {
			System.out.print("-Welcome, ");
			Volunteer myVolunteer = new Volunteer();
			showVolunteerMenu(myVolunteer);
		}
		
		else {
			System.out.println("-You are not registered-");
		}
	}

	
	/*Shows volunteers menu. 3 options to choose from and shows 
	 * the users job info.
	 * @param- theVolunteer- the volunteer that has signed in.
	 */
	public static void showVolunteerMenu(Volunteer theVolunteer) {
		String choice = user.next();
		
		System.out.println("1. View jobs volunteered for.");
		System.out.println("2. Sign Up for upcoming jobs.");
		System.out.println("3. Sign Out of account.");
		if (choice == "1") {
			///////////////////////////////////////////////////////
		} else if (choice == "2") {
			volunteerSignUpForJob(theVolunteer);
		} else if (choice == "3") {
			signIn();
		} else {
			System.out.println("You did not input a valid answer so the "
					+ "menu will be displayed again.");
			showVolunteerMenu(theVolunteer);
		}
	}

	

	public static void showParkManagerMenu(ParkManager theManager) {
		System.out.println("Please choose from one of the following (1-3): ");
		
		System.out.println("1. View current active jobs.");
		System.out.println("2. Create a new park job.");
		System.out.println("3. Sign Out of account.");
		System.out.println("Please type a number between 1 and 3: ");
		String choice = user.next();
		
		
		if (choice == "1") {
			//parse through the list and display the jobs.
			//call the method that displays the job that will let the user 
			//decide what job they want to choose.
			
		} else if (choice == "2") {
			//add all of this to the collection. 
			//CHECK THE AMOUNT OF JOBS
			//if job amount is not yet reached
			newParkJob(theManager);
			//else- 
			//System.out.println("Sorry, we are currently filled, please check back in tomorrow.");
			//display park manager menu.
		} else if (choice == "3") {
			signIn();
		} else {
			System.out.println("You did not input a valid answer so the menu "
					+ "will be displayed again.");
			showParkManagerMenu(theManager);
		}
	}

	

	/*Allows Volunteer to sign up for a job.*/
	public static void volunteerSignUpForJob(Volunteer theVolunteer) {
	    List<Job> array = new ArrayList<Job>();
		System.out.println("Here are all of the current jobs that are available. "
				+ "Please choose which job you want by selecting a number. ");
		for (int i = 0; i < array.size(); i++) {
		    System.out.println(array.get(i).getTitle()+ " " +
		                array.get(i).getStartDate() + " To " +
		                array.get(i).getEndDate() + " Description: " +
		                array.get(i).getDescription());
		}

		System.out.println("-Which job would you like to sign up for this job?-");

		try {
		    theVolunteer.addJob(array.get(value));
		catch (AlreadySignedUpException ex) {
		    System.out.println("Sorry, you have already" +
		                       "signed up for that job");
		} catch (MinimumDaysException ec) {
		    System.out.println("Sorry, that job is too close. We ask" + 
		                       "That jobs are signed up for no sooner than" + 
		                       Volunteer.MINIMUM_DAYS_OUT + "Days out");
		} catch (ScheduleConflictException ed) {
		    System.out.println("Sorry, looks like that jobs' dates conflict" +
		                       "with one of your current ones.");
		}

		System.out.println("-You have successfully signed up for this job-");

		showVolunteerMenu(theVolunteer);
	}
	
	/*Asks for information for a new job. Checks to see if the job length is max days or under.
	 * checks to see if the job is not too far away,
	 * and checks to see how many jobs there are.*/
	public static void newParkJob(ParkManager theManager) {
		
		System.out.println("-Please provide a job title-");
		System.out.print("Job Title: ");
		String t = user.next();
		
		System.out.println("-Please provide a job location-");
		System.out.print("Job Location: ");
		String l = user.next();
		
		
		System.out.println("-What is the starting date for this job?-");
		System.out.print("Date (MM/DD/YYYY): ");
		String s = user.next();
		String[] dateArray = s.split("/");
		LocalDate start = LocalDate.of(Integer.parseInt(dateArray[2]), 
				Integer.parseInt(dateArray[0]), 
				Integer.parseInt(dateArray[1]));
		//CHECK TO SEE IF START DATE IS NOT TOO FAR.
		while(!theManager.isJobNotTooFar(start)) { //while this is false. ask for a new input
			System.out.println("This date is too far. Please input a date that "
					+ "is closer.");
			System.out.print("Date (MM/DD/YYYY): ");
			s = user.next();
			dateArray = s.split("/");
			start = LocalDate.of(Integer.parseInt(dateArray[2]), 
					Integer.parseInt(dateArray[0]), 
					Integer.parseInt(dateArray[1]));
		}
			
		

		System.out.println("-What is the ending date for this job?-");
		System.out.print("Date (MM/DD/YYYY): ");
		String e = user.next();
		LocalDate end;
		String[] dateArray2 = e.split("/");
		end = LocalDate.of(Integer.parseInt(dateArray2[2]), 
				Integer.parseInt(dateArray2[0]), 
				Integer.parseInt(dateArray2[1]));
		while(!theManager.isMaxDaysUnder(start, end)) {
			System.out.println("Please limit your job to 3 days or under.");
			System.out.print("Date (MM/DD/YYYY): ");
			e = user.next();
			dateArray2 = e.split("/");
			end = LocalDate.of(Integer.parseInt(dateArray2[2]), 
					Integer.parseInt(dateArray2[0]), 
					Integer.parseInt(dateArray2[1]));
		}
		


		System.out.println("-Please provide a job description-");
		System.out.print("Job Description: ");
		String d = user.next();
		//newJob.setDescription(d);
		
		Job newJob = new Job(t,d,l, start, end);


		System.out.println("-This job has been created-");
		//System.out.println(newJob.getTitle()+ " " + 
		//newJob.getStartDate() + " To " + 
		//newJob.getEndDate() + " Description: " + newJob.getDescription());
		newJob.toString();

		showParkManagerMenu(theManager);
		
	}

}