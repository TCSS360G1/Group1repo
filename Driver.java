package user_interface;



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Scanner;

import model.Job;



/**

 * The User Interface for the program.

 * This class will have methods to display to the console.

 * @author Jenzel Villanueva

 * @version February 9, 2018

 */



public class Driver {

	static Scanner user = new Scanner(System.in);

	public static void signIn() throws IOException {
		
		

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

		

		System.out.println("1. View jobs volunteered for.");

		System.out.println("2. Sign Up for upcoming jobs.");

		System.out.println("3. Sign Out of account.");

		// TODO: scan for user input volunteerMenu

	}

	

	public static void showParkManagerMenu() {
		System.out.println("P");
		

		System.out.println("1. View current active jobs.");

		System.out.println("2. Create a new park job.");

		System.out.println("3. Sign Out of account.");
		System.out.println("Please type a number between 1 and 3: ");
		String choice = user.next();
		
		// TODO: scan for user input parkManagerMenu
		if (choice == "1") {
			//parse through the list and display the jobs.
			//call the method that displays the job that will let the user decide what job
			
		} else if (choice == "2") {
			//add all of this to the collection. 
			//CHECK THE AMOUNT OF JOBS
			newParkJob();
		}
	}

	

	public static void volunteerSignUpForJob() {

		System.out.println("");


		// TODO: Show valid available jobs the user can choose

		System.out.println("-Event Dates-");


		System.out.println("-Event Locations-");


		System.out.println("-Difficulty-");


		System.out.println("-Would you like to sign up for this job?-");

		// TODO: Confirm choice by showing the job info the user picked

		System.out.println("1. Yes.");

		System.out.println("2. No.");

		

		System.out.println("-You have successfully signed up for this job-");

		// TODO: Showing the job info again

		

		// TODO: Return to volunteer's main menu

	}

	

	public static void newParkJob() {

		System.out.println("-What is the starting date for this job?-");

		System.out.print("Date (MM/DD/YYYY): ");

		// TODO: scan for user input job start date

		

		System.out.println("-What is the ending date for this job?-");

		System.out.print("Date (MM/DD/YYYY): ");

		// TODO: scan for user input job end date

		

		System.out.println("-Please provide a job title-");

		System.out.print("Job Title: ");

		// TODO: scan for user input job title

		

		System.out.println("-Please provide a job description-");

		System.out.print("Job Description: ");

		// TODO: scan for user input job description

		

		System.out.println("-This job has been created-");

		// TODO: verification of job: title, date start, date end, description

		System.out.println("-What would you like to do now?-");
		Job newJob = new Job();
		System.out.println("What is the job title: ");
		String t = user.next();
		newJob.setJobTitle(t);
		
		System.out.println("What is the job description: ");
		String d = user.next();
		newJob.setDescription(d);
		
		System.out.println("What is the jobs starting date: ");
		String s = user.next();
		s.split("/");
		newJob.setStartDate(s);
		
		System.out.println("What is the jobs ending date: ");
		String d = user.next();
		newJob.setDescription(d);
		

		// TODO: return to show park manager menu

	}

}