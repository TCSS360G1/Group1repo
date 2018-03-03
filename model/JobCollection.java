package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class JobCollection implements Serializable {

	private static final long serialVersionUID = 1L;
	//all jobs past and present 
	private static ArrayList<Job> mySystemsJobs = new ArrayList<Job>();
	//all current jobs. 
	private static ArrayList<Job> myJobs = new ArrayList<Job>();
	//without the schedule conflicts. 
	private static ArrayList<Job> myFilteredJobs = new ArrayList<Job>();
	
	/**
	 * precondition: 
	 * 
	 * postcondition: Serializes the Jobs ArrayList to store all Jobs.
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
	 * precondition: 
	 * 
	 * postcondition: De-serializes Jobs .ser file to Jobs Arraylist.
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
	
	public void clearJobs() {
		myJobs.clear();
		
	}
	
	public int getSize() {
		return myJobs.size();
	}
	
	public Job getIndex(int i) {
		return myJobs.get(i);
		
	}
	
	/**
	 * precondition: 
	 * 
	 * postcondition: add a job in all current Jobs list.
	 */
	public void addNewJob(Job newJob) {
		myJobs.add(newJob);
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * precondition: 
	 * 
	 * postcondition: filter out all past jobs.
	 */
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
	/**
	 * precondition: ALWAYS PASS IN users current jobs list.
	 * 
	 * postcondition: will not allow user to cancel a job if it is too far.
	 */
	public static ArrayList<Job>
	                filterForCancellation(ArrayList<Job> theJobList) {
		ArrayList<Job> myCancellationJobs = new ArrayList<Job>();
		for(int i = 0; i<theJobList.size(); i++) {
			if(!theJobList.get(i).isTooClose()) {
				myCancellationJobs.add(theJobList.get(i));
			}
		}
		return myCancellationJobs;
		
	}
	
	/**
	 * precondition: always pass in current Jobs list. 
	 *
	 * postcondition: returns list that gives list of jobs that are available
	 * to be cancelled from.
	 */ 
	public static ArrayList<Job>
	                filterNewJobsVolunteer(ArrayList<Job> theJobList) {
		ArrayList<Job> myNewJobsFilters = new ArrayList<Job>();
		for(int i = 0; i<theJobList.size(); i++) {
			if(theJobList.get(i).isMoreThanMinimumDaysVol()) {
				myNewJobsFilters.add(theJobList.get(i));
			}
		}
		return myNewJobsFilters;
	}
	
	


}
