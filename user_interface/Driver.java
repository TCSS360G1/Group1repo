package user_interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The User Interface for the program.
 * 
 * @author Jenzel Villanueva
 * @version February 9, 2018
 */

public class Driver {
	
	public static void signIn() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("-Sign in-\nUsername: ");
		String username = br.readLine();
		
		// TODO: Check if User exists
		System.out.println("-Fetching information-\n...\n");
		
		// TODO: If User is not registered, tell them about it
		System.out.println("-You are not registered-");
		
		// TODO: If User exists, greet them like "Welcome, Employee Stanley"
		System.out.print("-Welcome, ");
	}
	
	public static void showVolunteerMenu() {
		System.out.println("1. Edit my account information.");
		System.out.println("2. View jobs volunteered for.");
		System.out.println("3. Sign Up for upcoming jobs.");
		System.out.println("4. Sign Out of account.");
		// TODO: scan for user input volunteerMenu
	}
	
	public static void showParkManagerMenu() {
		System.out.println("1. Edit my account information.");
		System.out.println("2. View current active jobs.");
		System.out.println("3. Create a new park job.");
		System.out.println("4. Sign Out of account.");
		// TODO: scan for user input parkManagerMenu
	}
	
	public static void volunteerSignUpForJob() {
		System.out.println("-Search for job by which category?-");
		System.out.println("1. Event Date.");
		System.out.println("2. Event Locations.");
		System.out.println("3. Difficulty.");
		
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
		
		// TODO: return to show park manager menu
	}
}
