package user_interface;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import model.User;
import model.UserCollection;
import model.Volunteer;
import model.Job;
import model.JobCollection;
import model.ParkManager;
import model.UrbanParksEmployee;

/**
 * The Main Class for the program, which handles console input and output.
 * Corresponds with an existing Users in the System.
 * 
 * @author Jenzel Villanueva, Kai Stansfield, Deepjot Kaur, Luke Manca
 * @version February 11, 2018
 */
public class Main implements Serializable {
	private static final long serialVersionUID = 7001992405582133870L;

	private static UserCollection myUsers;
	private static JobCollection myJobs;

	/**
	 * The main method in which the program runs within.
	 * 
	 * @param args command line arguments, not used in this program.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			@Override
			public void run() {
				new UrbanParksFrame();
			}
		});
	}
}
