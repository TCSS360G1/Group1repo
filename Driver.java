package user_interface;



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Job;
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

	public static void signIn() {
		
		

		System.out.print("-Sign in-\nUsername: ");

		String username = user.next();

		// TODO: Check if User exists

		System.out.println("-Fetching information-\n...\n");

		// TODO: If User is not registered, tell them about it

		System.out.println("-You are not registered-");

		// TODO: If User exists, greet them like "Welcome, Employee Stanley"

		System.out.print("-Welcome, ");
		
		
	}

	

	public static void showVolunteerMenu() {
		String choice = user.next();
		
		System.out.println("1. View jobs volunteered for.");
		System.out.println("2. Sign Up for upcoming jobs.");
		System.out.println("3. Sign Out of account.");
		if (choice == "1") {
			
		} else if (choice == "2") {
			volunteerSignUpForJob();
		} else if (choice == "3") {
			signIn();
		} else {
			System.out.println("You did not input a valid answer so the menu will be displayed again.");
			showVolunteerMenu();
		}
	}

	

	public static void showParkManagerMenu() {
		System.out.println("Please choose from one of the following (1-3): ");
		

		System.out.println("1. View current active jobs.");
		System.out.println("2. Create a new park job.");
		System.out.println("3. Sign Out of account.");
		System.out.println("Please type a number between 1 and 3: ");
		String choice = user.next();
		
		// TODO: scan for user input parkManagerMenu
		if (choice == "1") {
			//parse through the list and display the jobs.
			//call the method that displays the job that will let the user decide what job they want to choose.
			
		} else if (choice == "2") {
			//add all of this to the collection. 
			//CHECK THE AMOUNT OF JOBS
			newParkJob();
		} else if (choice == "3") {
			signIn();
		} else {
			System.out.println("You did not input a valid answer so the menu will be displayed again.");
			showParkManagerMenu();
		}
	}

	


	public static void volunteerSignUpForJob() {
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
		    volunteer.addJob(array.get(value));
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

		showVolunteerMenu();
	}

	public static void newParkJob() {
		Job newJob = new Job();
		
		System.out.println("-Please provide a job title-");
		System.out.print("Job Title: ");
		String t = user.next();
		newJob.setJobTitle(t);
		
		System.out.println("-What is the starting date for this job?-");
		System.out.print("Date (MM/DD/YYYY): ");
		String s = user.next();
		String[] dateArray = s.split("/");
		LocalDate start = LocalDate.of(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[0]), 
							Integer.parseInt(dateArray[1]));
		newJob.setStartDate(start);

		System.out.println("-What is the ending date for this job?-");
		System.out.print("Date (MM/DD/YYYY): ");
		String e = user.next();
		
		String[] dateArray2 = e.split("/");
		LocalDate end = LocalDate.of(Integer.parseInt(dateArray2[2]), Integer.parseInt(dateArray2[0]), 
							Integer.parseInt(dateArray2[1]));
		newJob.setStartDate(end);


		System.out.println("-Please provide a job description-");
		System.out.print("Job Description: ");
		String d = user.next();
		newJob.setDescription(d);



		System.out.println("-This job has been created-");
		//System.out.println(newJob.getTitle()+ " " + newJob.getStartDate() + " To " + 
							//newJob.getEndDate() + " Description: " + newJob.getDescription());
		newJob.toString();

		showParkManagerMenu();
		
	}

}