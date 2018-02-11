package user_interface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Job;
import model.ParkManager;
import model.User;
import model.Volunteer;

public class Main {

private static ArrayList<User> Users = new ArrayList<User>();
private static ArrayList<Job> Jobs = new ArrayList<Job>();
private static LocalDate date = LocalDate.now();  
	
	public static void main(String[] args) {
		//All UserList Testing
		ParkManager tempManager = new ParkManager("luke","manca");
		Volunteer tempVol = new Volunteer("Deepjot","..");
		Users.add(tempManager);
		Users.add(tempVol);
		System.out.println(Users.toString());
		serializeUserCollection();
		Users.clear();
		System.out.println(Users.toString());
		readInUserCollection();
		System.out.println(Users.toString());
		
		
		//All JobsList Testing
		Job tempJob = new Job("title","desc","Location",date,date);
		Jobs.add(tempJob);
		System.out.println(Jobs.toString());
		serializeJobsCollection();
		Jobs.clear();
		System.out.println(Jobs.toString());
		readInJobsCollection();
		System.out.println(Jobs.toString());
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
    try
    {   
        FileInputStream byteToUsers = new FileInputStream("userFile.ser");
        
        ObjectInputStream in = new ObjectInputStream(byteToUsers);

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



private static void serializeJobsCollection(){
	try {

        FileOutputStream fileOut =

        new FileOutputStream("JobsFile.ser");

        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(Jobs);

        out.close();

        fileOut.close();

        System.out.println("Serialized data is saved!");

		} catch (IOException i) {

			i.printStackTrace();
		}
}



private static void readInJobsCollection(){
try
{   
    FileInputStream byteToUsers = new FileInputStream("JobsFile.ser");
    
    ObjectInputStream in = new ObjectInputStream(byteToUsers);

    //REnew users arraylist to a casted serialized object.

    Jobs = (ArrayList<Job>)in.readObject();

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