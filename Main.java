package user_interface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import model.ParkManager;
import model.User;
import model.Volunteer;
import model.Job;

public class Main implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static ArrayList<User> myUsers = new ArrayList<User>();
	private static ArrayList<Job> myJobs = new ArrayList<Job>();
	private static Driver myDriver = new Driver();
	
	public static void main(String[] args) {
		fillCollections();
		System.out.println(myUsers.toString());
		System.out.println(myJobs.toString());
		
		myDriver.signIn(myUsers, myJobs);
		System.out.println(myUsers.toString()); /////////////////////////////
		serializeUserCollection();
		serializeJobCollection();
		System.out.println(myUsers.toString()); ///////////////////////////////
		myUsers.clear();
		myJobs.clear();
		
		readInUserCollection();
		readInJobCollection();
		System.out.println(myJobs.toString());//////////////////////////
		System.out.println(myUsers.toString()); ////////////////////
	}

	private static void fillCollections() {
		ParkManager tempManager1 = new ParkManager("Jenzel", "Villanueva");
		myUsers.add(tempManager1);
		ParkManager tempManager2 = new ParkManager("Deepjot", "Kaur");
		myUsers.add(tempManager2);
		Volunteer tempVol1 = new Volunteer("Luke", "Manca");
		myUsers.add(tempVol1);
		Volunteer tempVol2 = new Volunteer("Kai", "Stansfield");
		myUsers.add(tempVol2);

		Job job1 = new Job("Gas Works Park", "Pick up trash", "Seattle",
				LocalDate.of(2018, 3, 4), LocalDate.of(2018, 3, 4));
		myJobs.add(job1);
		Job job2 = new Job("Alki Beach", "Picking up litter", "Seattle",
				LocalDate.of(2018, 3, 19), LocalDate.of(2018, 3, 20));
		myJobs.add(job2);
		Job job3 = new Job("Seahurst Beach", "Cleaning trails", "Burien",
				LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 20));
		myJobs.add(job3);
		Job job4 = new Job("Lake Meridian", "Trimming Trees and shrubs, "
				+ "mowing the grass", "Kent", LocalDate.of(2018, 2, 22),
				LocalDate.of(2018, 2, 24));
		myJobs.add(job4);
		Job job5 = new Job("Wapto Park", "Setting up for events", "Tacoma",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		myJobs.add(job5);
		Job job6 = new Job("Point Defiance Park", "Cleaning trails", "Tacoma",
				LocalDate.of(2018, 2, 12), LocalDate.of(2018, 2, 12));
		myJobs.add(job6);
		Job job7 = new Job("Jefferson Park", "Set up for events", "Tacoma",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		myJobs.add(job7);
		Job job8 = new Job("Discovery Park", "Clean up beaches", "Seattle",
				LocalDate.of(2018, 2, 13), LocalDate.of(2018, 2, 13));
		myJobs.add(job8);
	}

	private static void serializeUserCollection() {
		try {
			FileOutputStream fileOut =
					new FileOutputStream("userFile.ser");
			
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(myUsers);

			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	private static void serializeJobCollection() {
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

	private static void readInUserCollection() {
		// De-serialization
		try
		{
			// Reading the object from a file
			FileInputStream byteToUsers = new FileInputStream("userFile.ser");
			ObjectInputStream in = new ObjectInputStream(byteToUsers);

			// Method for de-serialization of object
			// Renew users arraylist to a casted serialized object.
			myUsers = (ArrayList<User>) in.readObject();

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

	private static void readInJobCollection() {
		// De-serialization
		try
		{
			FileInputStream byteToUsers = new FileInputStream("jobFile.ser");
			ObjectInputStream in = new ObjectInputStream(byteToUsers);

			// Method for de-serialization of object
			// REnew users arraylist to a casted serialized object.
			myJobs = (ArrayList<Job>) in.readObject();

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
}