package user_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.Job;
import model.JobCollection;
import model.ParkManager;
import model.UserCollection;

/**
 * The Graphical User Interface for this program.
 * 
 * @author Jenzel Villanueva
 * @version February 27, 2018
 */
public class UrbanParksFrame extends JFrame implements PropertyChangeListener{

    private static final int PADDING = 30;
    private final JFrame myFrame;
    private final SignInPanel mySignInPanel;
    private static JobCollection JOBS;
    private static UserCollection USERS;
    /**
     * Construct the GUI.
     */
    public UrbanParksFrame() {
        myFrame = new JFrame("TCSS 360 - Urban Parks");
//        System.out.println(theUsers.getSize());
//        System.out.println(theJobs.getSize());
        USERS = new UserCollection();
		JOBS = new JobCollection();
		fillCollections();
        
        
        
        mySignInPanel = new SignInPanel(myFrame, USERS, JOBS);
        mySignInPanel.addPropertyChangeListener(this);
        
        
        
        setupFrame();
        USERS.serializeUserCollection();

		
    }
	/**
	 * De-serializes both Jobs and Users .ser files.
	 */
	private static void fillCollections() {
		USERS.readInUserCollection();
		JOBS.readInJobCollection();
	} 

	/**
	 * Serializes the Users ArrayList to store all Users.
	 */
	private static void serializeUserCollection() {
		try {
			FileOutputStream fileOut = new FileOutputStream("userFile.ser");

			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(USERS);

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
			FileOutputStream fileOut = new FileOutputStream("jobFile.ser");

			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(JOBS);

			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
    /**
     * Sets up the elements of the GUI.
     */
    private void setupFrame() {
    	myFrame.setLayout(new BorderLayout());
    	// myFrame.setIconImage(new ImageIcon("./images/parks-icon.png").getImage());
    	
    	setupSignInPanel();
    	myFrame.getContentPane().add(mySignInPanel, BorderLayout.CENTER);
    	
        /**
         * A ToolKit used for the purpose of attempting to center the frame on a screen.
         */
        final Toolkit kit = Toolkit.getDefaultToolkit();
        
        myFrame.setLocation(
            (int) (kit.getScreenSize().getWidth() / 2 - myFrame.getWidth() / 2),
            (int) (kit.getScreenSize().getHeight() / 2 - myFrame.getHeight() / 2));
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //myFrame.pack();
        //myFrame.setMinimumSize(new Dimension(1000,1000));
        myFrame.pack();
        myFrame.setResizable(true);
        myFrame.setVisible(true);
    }
	/**
	 * 
	 */
	private void setupSignInPanel() {
		mySignInPanel.setLayout(new GridLayout(5, 1));
	}

	

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("Manager add")) {
			ParkManager manager = (ParkManager) evt.getOldValue();
			System.out.println(
					JOBS.getSize() + "  " + manager.getJobs().size());
			// manager has a new job to add.
			JOBS.addNewJob((Job) evt.getNewValue());

			manager.addJob((Job) evt.getNewValue());
			System.out.println(
					JOBS.getSize() + "  " + manager.getJobs().size());
			
			//JOBS.serializeJobCollection();
			
		} else if (evt.getPropertyName().equals("Manager remove")) {
			System.out.println(
					"ORIGINAL BEFORE REMOVING SIZE " + JOBS.getSize());
			ParkManager manager = (ParkManager) evt.getOldValue();
			// delete the job
			JobCollection.removeJob(evt.getNewValue().toString(), manager);
			System.out.println("AFTER REMOVING SIZE " + JOBS.getSize());
			for (int i = 0; i < JOBS.getSize(); i++) {
				System.out.println(JOBS.getIndex(i));
			}
		}
		JOBS.serializeJobCollection();

	}

	

}