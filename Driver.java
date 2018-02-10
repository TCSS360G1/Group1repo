package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Driver implements Serializable{
	
	private static ArrayList<User> Users = new ArrayList<User>();

	public static void main(String[] args) {

		ArrayList<User> Users = new ArrayList<User>();
		ParkManager tempManager = new ParkManager();
		tempManager.setName("Luke Manca");
		System.out.println(tempManager.getName());
		Users.add(tempManager);
		System.out.println(Users.toString());
		
		serializeUserCollection();
		
		Users.clear();
		
		readInUserCollection();
		
		System.out.println(Users.toString());
		
}
	

private static void serializeUserCollection(){
	
	
	try {
        FileOutputStream fileOut =
        new FileOutputStream("userFile.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(Users);
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved!");
     } catch (IOException i) {
        i.printStackTrace();
    }
}


private static void readInUserCollection(){
	 // De-serialization
    try
    {   
        // Reading the object from a file
        FileInputStream byteToUsers = new FileInputStream("userFile.ser");
        ObjectInputStream in = new ObjectInputStream(byteToUsers);
         
        // Method for de-serialization of object
        //REnew users arraylist to a casted serialized object.
        Users = (ArrayList<User>)in.readObject();
         
        in.close();
        byteToUsers.close();
         
        System.out.println("Object has been deserialized");
    }
     
    catch(IOException ex)
    {
        System.out.println("IOException is caught: De-Serialize");
    }
     
    catch(ClassNotFoundException ex)
    {
        System.out.println("ClassNotFoundException is caught");
    }
}
}

//	public void readUserFile(){
//			//Delimiters used in the CSV file
//			 String COMMA_DELIMITER = ",";
//
//				try {
//					Scanner scanner = new Scanner(new File("Users.csv"));
//					//Use Delimiter as COMMA
//					scanner.useDelimiter(COMMA_DELIMITER);
//					while(scanner.hasNext())
//					{
//							System.out.print(scanner.next()+"   ");
//					}
//				} 
//				catch (FileNotFoundException fe) 
//				{
//					fe.printStackTrace();
//				}
//				finally
//				{
//					scanner.close();
//				}
//		}
//	
//	public void readJobsFile(){
//		//Delimiters used in the CSV file
//		 String COMMA_DELIMITER = ",";
//
//			try {
//				Scanner scanner = new Scanner(new File("Jobs.csv"));
//				//Use Delimiter as COMMA
//				scanner.useDelimiter(COMMA_DELIMITER);
//				while(scanner.hasNext())
//				{
//						System.out.print(scanner.next()+"   ");
//				}
//			} 
//			catch (FileNotFoundException fe) 
//			{
//				fe.printStackTrace();
//			}
//			finally
//			{
//				scanner.close();
//			}
//	}

//}
