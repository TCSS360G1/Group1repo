package user_interface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.ArrayList;

import model.User;
import model.Job;

/**
 * The Main Class for the program, which handles console input and output.
 * Corresponds with an existing Users in the System.
 * 
 * @author Jenzel Villanueva, Kai Stansfield, Deepjot Kaur, Luke Manca
 * @version February 11, 2018
 */
public class Main implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static ArrayList<User> myUsers = new ArrayList<User>();
	private static ArrayList<Job> myJobs = new ArrayList<Job>();
	private static Driver myDriver = new Driver();
	
	/**
	 * The main method in which the program runs within.
	 * 
	 * @param args command line arguments, not used in this program.
	 */
	public static void main(String[] args) {
		fillCollections();
		
		myDriver.signIn(myUsers, myJobs);
		serializeUserCollection();
		serializeJobCollection();
		myUsers.clear();
		myJobs.clear();

	}

	/**
	 * De-serializes both Jobs and Users .ser files.  
	 */
	private static void fillCollections() {
	    readInUserCollection();
        readInJobCollection();
	}

	/**
	 * Serializes the Users ArrayList to store all Users.
	 */
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

	/**
	 * Serializes the Jobs ArrayList to store all Jobs.
	 */
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

	/**
	 * De-serializes Users .ser file to Users Arraylist.
	 */
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

	/**
	 * De-serializes Jobs .ser file to Jobs Arraylist.
	 */
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
