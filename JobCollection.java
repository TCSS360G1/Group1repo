package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class JobCollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//all current jobs. 
	private static ArrayList<Job> myJobs;
	//without the schedule conflicts. 
	private static ArrayList<Job> myFilteredJobs;
	
	public JobCollection() {
	    myJobs = new ArrayList<Job>();
	    myFilteredJobs = new ArrayList<Job>();
	}
	
	/**
	 * Serializes the Jobs ArrayList to store all Jobs.
	 */
	public static void serializeJobCollection() {
		try {
			FileOutputStream fileOut =
					new FileOutputStream("jobFile.ser");
			
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(myJobs);
			

			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	/**
	 * De-serializes Jobs .ser file to Jobs Arraylist.
	 */
	public static void readInJobCollection() {
		// De-serialization
		try
		{
			FileInputStream byteToUsers = new FileInputStream("jobFile.ser");
			ObjectInputStream in = new ObjectInputStream(byteToUsers);

			// Method for de-serialization of object
			// REnew users arraylist to a casted serialized object.
			// filter();
			myJobs = (ArrayList<Job>) in.readObject();
			// print jobs
			System.out.println(myJobs);

			in.close();
			byteToUsers.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	
	/*Clear jobs in serializable.*/
	public void clearJobs() {
		myJobs.clear();
		
	}
	
	/*get Size of ALL CURRENT JOBS.*/
	public int getSize() {
		return myJobs.size();
	}
	/*GET index of ALL CURRENT JOBS LIST*/
	public Job getIndex(int i) {
		return myJobs.get(i);
		
	}
	/*add a job in all current Jobs list. */
	public void addNewJob(Job newJob) {
		myJobs.add(newJob);
		// TODO Auto-generated method stub
		
	}
	/*filter out all past jobs.*/
	public static ArrayList<Job> filterPast() {
//		for(int i = 0; i<myJobs.size(); i++){
//			System.out.println(myJobs.get(i).toString());
//		}
		//System.out.println();
		for(int i = 0; i<myJobs.size(); i++) {
			if(myJobs.get(i).isInPast()) {
				//System.out.println(myJobs.get(i).toString());
				myFilteredJobs.add(myJobs.get(i));
				
			}
		}
		
		//System.out.println("\n\n filtered out jobs\n\n");
		//System.out.println(myFilteredJobs.size());
		
		return myFilteredJobs;
	}
	//ALWAYS PASS IN users current jobs list.
	//will not allow user to cancell a job if it is too far.
	public static ArrayList<Job> filterForCancellation(ArrayList<Job> theJobList) {
		ArrayList<Job> myCancellationJobs = new ArrayList<Job>();
		for(int i = 0; i<theJobList.size(); i++) {
			if(!theJobList.get(i).isMoreThanMinimumDaysUnvol()) {
				myCancellationJobs.add(theJobList.get(i));
			}
		}
		return myCancellationJobs;
		
	}
	
	//always pass in current Jobs list. 
	//returns list that gives list of jobs that are available to be cancelled from. 
	public static ArrayList<Job> filterNewJobsVolunteer(ArrayList<Job> theJobList) {
		ArrayList<Job> myNewJobsFilters = new ArrayList<Job>();
		for(int i = 0; i<theJobList.size(); i++) {
			if(theJobList.get(i).isMoreThanMinimumDaysUnvol()) {
				myNewJobsFilters.add(theJobList.get(i));
			}
		}
		return myNewJobsFilters;
	}
	
	


}