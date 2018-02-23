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
	private static ArrayList<Job> myJobs = new ArrayList<Job>();
	
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
	public void clearJobs() {
		myJobs.clear();
		
	}


}
