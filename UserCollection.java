package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserCollection {
	
	private static ArrayList<User> myUsers = new ArrayList<User>();

	public void clearUsers() {
		myUsers.clear();
		// TODO Auto-generated method stub
		
	}

	/**
	 * Serializes the Users ArrayList to store all Users.
	 */
	public static void serializeUserCollection() {
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
}
