package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Driver {

	public static void main(String[] args) {

		ParkManager tempManager = new ParkManager();
		tempManager.setName("Luke Manca");
		System.out.println(tempManager.getName());
	}
	
	
	public void readUserFile(){
			//Delimiters used in the CSV file
			 String COMMA_DELIMITER = ",";

				try {
					Scanner scanner = new Scanner(new File("Users.csv"));
					//Use Delimiter as COMMA
					scanner.useDelimiter(COMMA_DELIMITER);
					while(scanner.hasNext())
					{
							System.out.print(scanner.next()+"   ");
					}
				} 
				catch (FileNotFoundException fe) 
				{
					fe.printStackTrace();
				}
				finally
				{
					scanner.close();
				}
		}
	
	public void readJobsFile(){
		//Delimiters used in the CSV file
		 String COMMA_DELIMITER = ",";

			try {
				Scanner scanner = new Scanner(new File("Jobs.csv"));
				//Use Delimiter as COMMA
				scanner.useDelimiter(COMMA_DELIMITER);
				while(scanner.hasNext())
				{
						System.out.print(scanner.next()+"   ");
				}
			} 
			catch (FileNotFoundException fe) 
			{
				fe.printStackTrace();
			}
			finally
			{
				scanner.close();
			}
	}

}
