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
		
		myDriver.signIn(myUsers, myJobs);
		serializeUserCollection();
		serializeJobCollection();
		myUsers.clear();
		myJobs.clear();

	}

	private static void fillCollections() {
	    readInUserCollection();
        readInJobCollection();
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