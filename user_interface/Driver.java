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
		System.out.print("-Welcome, -");
	}
	
	public static void showVolunteerMenu() {
		System.out.println("1. Edit my account information.");
		System.out.println("2. View jobs volunteered for.");
		System.out.println("3. Sign Up for upcoming jobs.");
		System.out.println("4. Sign Out of account.");
		
	}
	
	public static void showParkManagerMenu() {
		System.out.println("1. Edit my account information.");
		System.out.println("2. View current active jobs.");
		System.out.println("3. Create a new park job.");
		System.out.println("4. Sign Out of account.");
		
	}
}
