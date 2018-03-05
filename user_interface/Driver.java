package user_interface;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import model.AlreadySignedUpException;
import model.Job;
import model.JobCollection;
import model.MinimumDaysException;
import model.ParkManager;
import model.ScheduleConflictException;
import model.UrbanParksEmployee;
import model.User;
import model.UserCollection;
import model.Volunteer;

/**
 * The User Interface for the program.
 * This class will have methods to display to the console.
 * 
 * @version February 25, 2018
 */
public class Driver {
	
	
	static Scanner user = new Scanner(System.in);
	private static ArrayList<Job> myCurrentJobs;
	public static ArrayList<Job> myCurrentJobsCancellation;
	/* The initial display. this will decide if the user is a volunteer or a PM
	 *then will call methods to display the correct menus for type. */
	
	public static void signIn(UserCollection myUsers, 
			JobCollection myJobs) {
		for(int i = 0; i<myJobs.getSize(); i++) {
			System.out.println(myJobs.getIndex(i).toString());
		}
	    System.out.println("Type 'exit' to exit sign in.\n");
		System.out.print("-Sign in-\nFirst and last name "
		                + "(separated by a space): ");
		
		String name = user.nextLine();
		
		boolean userFound = false;
		if (name.equals("exit")) {
		    //Dummy branch
		} else {
    		for(int i = 0; i<myUsers.getSize(); i++) {
    			if (myUsers.getIndex(i).getName().toLowerCase().equals(name.toLowerCase())) {
    				myCurrentJobs = myJobs.filterPast();
    				myCurrentJobsCancellation = Job.filterForCancellation(myCurrentJobs);
    				
    				userFound = true;
    				if(myUsers.getIndex(i).getType().equals("Manager")) {
    					ParkManager myManager = (ParkManager) (myUsers.getIndex(i));
    					System.out.print("\n-Welcome, Manager: "+ 
    						myUsers.getIndex(i).getFirstName()+ " " + 
    					                myUsers.getIndex(i).getLastName() + "\n");
    					showParkManagerMenu(myManager, myUsers, myJobs, myCurrentJobs, myCurrentJobsCancellation);
    					
    				} else if(myUsers.getIndex(i).getType().equals("Volunteer")) {
    					System.out.print("\n-Welcome, Volunteer: "+ 
    							myUsers.getIndex(i).getFirstName()+ " " + 
    					                myUsers.getIndex(i).getLastName() + "\n");
    					Volunteer myVolunteer = (Volunteer) (myUsers.getIndex(i));
    					showVolunteerMenu(myVolunteer, myUsers, myJobs, myCurrentJobs);
    					
    				} else if(myUsers.getIndex(i).getType().equals("Urban Parks Employee")) {
    					System.out.println("\n-Welcome, Park Employee");
    					UrbanParksEmployee employee = (UrbanParksEmployee) (myUsers.getIndex(i));
    					showParkEmployeeMenu(employee, myUsers, myJobs, myCurrentJobs);
    				}
    			}
    		}
		}

		if (userFound == false && !name.equals("exit")) {
			System.out.println("Invalid user. Please check the spelling!\n");
            signIn(myUsers, myJobs);
		}
	}

	
	private static void showParkEmployeeMenu(UrbanParksEmployee employee, UserCollection theUsers, JobCollection theJobs, ArrayList<Job> myCurrentJobs2) {
		// TODO Auto-generated method stub
		System.out.println("1. Change the amount of jobs.");
		String choice = user.next();
		if(choice.equals("1")) {
			System.out.println("Enter amount of jobs you would like to limit to: ");
			choice = user.next();
			Job.setLegalJobAmount(Integer.parseInt(choice));
			System.out.println(Job.getLegalJobAmount());
		} if(choice.equals("2")) {
			signIn(theUsers, theJobs);
		}
		else {
			showParkEmployeeMenu(employee, theUsers, theJobs, myCurrentJobs2);
		}
		
		
	}


	/**
	 * Shows Volunteers Menu. 3 options to choose from and shows 
	 * the users job info.
	 * 
	 * @param theVolunteer the Volunteer that has signed in.
	 * @param myCurrentJobs 
	 */
	public static void showVolunteerMenu(Volunteer theVolunteer, 
			UserCollection theUsers, JobCollection theJobs, ArrayList<Job> myCurrentJobs) {
		
		System.out.println("1. View jobs volunteered for.");
		System.out.println("2. Sign Up for upcoming jobs.");
		System.out.println("3. Sign Out of account.");
		System.out.println("4. Unvolunteer for a job.");
		
		String choice = user.next();
		ArrayList<Job> volunteerJobs = theVolunteer.getJobs();
		if (choice.equals("1")) {
			if (volunteerJobs.isEmpty()) {
			    System.out.println("No jobs signed up for!\n");
			    showVolunteerMenu(theVolunteer, theUsers, theJobs, myCurrentJobs);
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
			    showVolunteerMenu(theVolunteer, theUsers, theJobs, myCurrentJobs);
			}
		} else if (choice.equals("2")) {
			volunteerSignUpForJob(theVolunteer, theUsers, theJobs, myCurrentJobs);
		} else if (choice.equals("3")) {
		    user.nextLine();
			signIn(theUsers, theJobs);
		} else if (choice.equals("4")) {
			
			
		} else {
			System.out.println("You did not input a valid answer so the "
					+ "menu will be displayed again.\n");
			showVolunteerMenu(theVolunteer, theUsers, theJobs, myCurrentJobs);
		}
	}
	

	/**
	 * Shows Park Manager Menu. 3 options to choose from and shows 
	 * the current active job info.
	 * 
	 * @param theManager the Park Manager that has signed in.
	 * @param myUsers the Users that are in the system.
	 * @param myJobs the Jobs that are in the System.
	 */
	public static void showParkManagerMenu(ParkManager theManager, 
			UserCollection myUsers, JobCollection myJobs, ArrayList<Job> myCurrentJobs, ArrayList<Job> myCurrentCancellations) {
		
		System.out.println("Please choose from one of the following (1-3): ");
		
		System.out.println("1. View current active jobs.");
		
		System.out.println("2. Create a new park job.");
		System.out.println("3. Sign Out of account.");
		System.out.println("4. View all my jobs");
		System.out.println("5. remove a job.");
		System.out.println("Please type a number between 1 and 4: ");
		String choice = user.nextLine();

		if (choice.equals("1")) {
			
			System.out.println("Here are all of the current Jobs in the System,"
					+ " you will be re-directed to the main menu: ");
			
			
			for (int i = 0; i < myCurrentJobs.size(); i++) {
				
			    System.out.println((i+1)+ ". " + myCurrentJobs.get(i).getTitle()+ 
			                    " At: " +
			    			myCurrentJobs.get(i).getLocation() +" " +
			                myCurrentJobs.get(i).getStartDate() + " To " +
			                myCurrentJobs.get(i).getEndDate() + " Description: " +
			                myCurrentJobs.get(i).getDescription());
			} 
			System.out.println();
//			for (int i = 0; i < myJobs.getSize(); i++) {
//				
//			    System.out.println((i+1)+ ". " + myJobs.getIndex(i).getTitle()+ 
//			                    " At: " +
//			    			myJobs.getIndex(i).getLocation() +" " +
//			                myJobs.getIndex(i).getStartDate() + " To " +
//			                myJobs.getIndex(i).getEndDate() + " Description: " +
//			                myJobs.getIndex(i).getDescription());
//			} 
//			System.out.println();
			showParkManagerMenu(theManager, myUsers, myJobs, myCurrentJobs,  myCurrentCancellations);
		} else if (choice.equals("2")) {
			//add all of this to the collection. 
			if(Job.isJobsAmountLegal(myJobs)) {
				newParkJob(theManager, myUsers, myJobs, myCurrentJobs, myCurrentCancellations);
			}
			else {
				System.out.println("Sorry, we are currently filled with the max"
						+ " amount of jobs, please check back in tomorrow.");
			}
			
		} else if (choice.equals("3")) {
			signIn(myUsers, myJobs);
		} else if (choice.equals("4")){
			
			for (int i = 0; i < theManager.getJobs().size(); i++) {
		        System.out.println((i+1)+ ". " +
		        		theManager.getJobs().get(i).getTitle() + " At: " +
		        		theManager.getJobs().get(i).getLocation() +" " +
		        		theManager.getJobs().get(i).getStartDate() + " To " +
		        		theManager.getJobs().get(i).getEndDate() +
                            " Description: " +
                            theManager.getJobs().get(i).getDescription());
		    }
			showParkManagerMenu(theManager, myUsers, myJobs, myCurrentJobs,  myCurrentCancellations);
		} else if(choice.equals("5")) {
			
			for (int i = 0; i < theManager.getJobs().size(); i++) {
				System.out.println("000");
		        System.out.println((i+1)+ ". " +
		        		theManager.getJobs().get(i).getTitle() + " At: " +
		        		theManager.getJobs().get(i).getLocation() +" " +
		        		theManager.getJobs().get(i).getStartDate() + " To " +
		        		theManager.getJobs().get(i).getEndDate() +
                            " Description: " +
                            theManager.getJobs().get(i).getDescription());
		    }
			
			System.out.println("Select job that you want to delete");
			choice = user.next();
			if(theManager.getJobs().size()>0){
				theManager.removeJob(theManager.getJobs().get(Integer.parseInt(choice)));

			}
			showParkManagerMenu(theManager, myUsers, myJobs, myCurrentJobs,  myCurrentCancellations);
			
		}
		else {
			System.out.println("You did not input a valid answer so the menu "
					+ "will be displayed again.");
			showParkManagerMenu(theManager, myUsers, myJobs, myCurrentJobs,  myCurrentCancellations);
		}
	}


	/**
	 * Allows Volunteer to sign up for a job.
	 * 
	 * @param theVolunteer the Volunteer that has signed in.
	 * @param theUsers the Users that are in the System.
	 * @param theJobs the Jobs that are in the System.
	 * @param myCurrentJobs 
	 */
	public static void volunteerSignUpForJob(Volunteer theVolunteer, 
			UserCollection theUsers, JobCollection theJobs, ArrayList<Job> myCurrentJobs) {
		System.out.println("\nHere are all of the jobs that are available. "
				+ "Please choose which job you want by typing a number.\n");
		for (int i = 0; i < myCurrentJobs.size(); i++) {
			
		    System.out.println((i+1)+ ". " + myCurrentJobs.get(i).getTitle()+ 
		                    " At: " +
		    			myCurrentJobs.get(i).getLocation() +" " +
		                myCurrentJobs.get(i).getStartDate() + " To " +
		                myCurrentJobs.get(i).getEndDate() + " Description: " +
		                myCurrentJobs.get(i).getDescription());
		} 

		System.out.println("\n-Which job would you like to sign up for? "
		                   + "0 to exit to main menu.");
		int value = user.nextInt() - 1;
		if (value == -1)
		    showVolunteerMenu(theVolunteer, theUsers, theJobs, myCurrentJobs);
		else {
    		try {
    		    theVolunteer.addJob(theJobs.getIndex(value));
    		    System.out.println("-You have successfully "
    		                       + "signed up for this job-");
    		} catch (AlreadySignedUpException ex) {
    		    System.out.println("Sorry, you have already" +
    		                       " signed up for that job");
    		    volunteerSignUpForJob(theVolunteer, theUsers, theJobs, myCurrentJobs);
    		} catch (MinimumDaysException ec) {
    		    System.out.println("Sorry, that job is too close. We ask " + 
    		                      "That jobs are signed up for no sooner than "+ 
    		                      Volunteer.MINIMUM_NUMBER_OF_DAYS_TO_SIGN_UP +
    		                      " Days out");
    		    volunteerSignUpForJob(theVolunteer, theUsers, theJobs, myCurrentJobs);
    		} catch (ScheduleConflictException ed) {
    		    System.out.println("Sorry, looks like that jobs' "
    		                       + "dates conflict " +
    		                       "with one of your current ones.");
    		    volunteerSignUpForJob(theVolunteer, theUsers, theJobs, myCurrentJobs);
    		}
    
    		showVolunteerMenu(theVolunteer, theUsers, theJobs, myCurrentJobs);
		}
	}
	
	
	/**
	 * Asks for information for a new job. Checks to see if the job
	 * length is max days or under. Checks to see if the job is not
	 * too far away, and checks to see how many jobs there are.
	 * 
	 * @param theManager the Park Manager that has signed in.
	 * @param myUsers the Users that are in the system.
	 * @param myJobs the Jobs that are in the System.
	 */
	public static void newParkJob(ParkManager theManager, 
			UserCollection myUsers, JobCollection myJobs, ArrayList<Job> myCurrentJobs, ArrayList<Job> myCurrentCancellation) {
		
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
		
		while(!theManager.isJobNotTooFar(start)
				|| ChronoUnit.DAYS.between(LocalDate.now(), start)< 0) { 
			
			//while this is false. ask for a new input
			System.out.println("This date is too far or is in the past. Please input a date that "
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
		myJobs.addNewJob(newJob);
		theManager.addJob(newJob);
		myCurrentJobs.add(newJob);
		showParkManagerMenu(theManager, myUsers, myJobs, myCurrentJobs,  myCurrentCancellation);
	}
	
	
	
}