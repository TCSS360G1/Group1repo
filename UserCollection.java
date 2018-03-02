package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserCollection {
	
	private static ArrayList<User> myUsers = new ArrayList<User>();

	

	/**
	 * Serializes the Users ArrayList to store all Users.
	 */
	public static void serializeUserCollection() { 
		//myUsers.add(new Volunteer("Kai", "Stansfield"));
		//myUsers.add(new UrbanParksEmployee("Deepjot", "K"));
		//myUsers.add(new ParkManager("Jenzel", "Villanueva"));
		//System.out.println(myUsers);
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
	 * De-serializes Users .ser file to Users Arraylist.
	 */
	public static void readInUserCollection() {
		// De-serialization
		myUsers.clear();
		try
		{
			// Reading the object from a file
			FileInputStream byteToUsers = new FileInputStream("userFile.ser");
			ObjectInputStream in = new ObjectInputStream(byteToUsers);

			// Method for de-serialization of object
			// Renew users arraylist to a casted serialized object.
			myUsers = (ArrayList<User>) in.readObject();
			//System.out.println("In collection" + myUsers);
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
	public void clearUsers() {
		myUsers.clear();
		// TODO Auto-generated method stub
		
	}
	public int getSize() {
		return myUsers.size();
	}
	public User getIndex(int i) {
		return myUsers.get(i);
		
	}
	
	public ArrayList<User> getUsers() {
		return myUsers;
	}

}
