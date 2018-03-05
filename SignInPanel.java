package user_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Job;
import model.JobCollection;
import model.ParkManager;
import model.UrbanParksEmployee;
import model.UserCollection;
import model.Volunteer;

/**
 * A JPanel used for drawing in PowerPaint.
 * 
 * @author Jenzel Villanueva
 * @version February 28, 2018
 */

public class SignInPanel extends JPanel implements PropertyChangeListener {

	private static final Dimension DEFAULT_SIZE = new Dimension(300, 150);
	private static final int TEXT_FIELD_WIDTH = 30;
	private static JTextField myUsernameText;
	private static JFrame myFrame;
	private final JLabel myUsernameLabel;
	private final JButton mySignInButton;
	private static UserCollection myUsers;
	private static JobCollection myJobs;

	/**
	 * 
	 * 
	 * @param theUsers
	 * @param theJobs
	 */
	public SignInPanel(JFrame theFrame, UserCollection theUsers,
			JobCollection theJobs) {
		super();

		// set up text field for username
		myFrame = theFrame;
		myUsernameLabel = new JLabel("Enter your name (ie: John Smith):");
		myUsernameText = new JTextField("", TEXT_FIELD_WIDTH);
		mySignInButton = new JButton("Sign In");

		myUsers = theUsers;
		myJobs = theJobs;

		setUpPanel();
	}

	public SignInPanel() {
		super();
		myUsernameLabel = new JLabel("Enter your name (ie: John Smith):");
		myUsernameText = new JTextField("", TEXT_FIELD_WIDTH);
		mySignInButton = new JButton("Sign In");
		setUpPanel();
	}

	/**
	 * Sets up the sign in panel.
	 */
	private void setUpPanel() {
		setPreferredSize(DEFAULT_SIZE);
		setBackground(Color.ORANGE);

		this.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Sign In"));

		this.add(myUsernameLabel, BorderLayout.CENTER);

		myUsernameText.setEditable(true);
		myUsernameText.setEnabled(true);

		this.add(myUsernameText, BorderLayout.CENTER);

		mySignInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Sign In Action
				signIn(myUsers, myJobs);
			}
		});

		mySignInButton.setVerticalTextPosition(AbstractButton.BOTTOM);
		mySignInButton.setHorizontalTextPosition(AbstractButton.CENTER);

		this.add(mySignInButton);

	}

	public void signIn(UserCollection theUsers,
			JobCollection theJobs) {
		// for(int i = 0; i<theJobs.getSize(); i++) {
		// System.out.println(theJobs.getIndex(i).toString());
		// }

		String name = myUsernameText.getText();

		boolean userFound = false;
		if (name.equals("exit")) {
			// Dummy branch
		} else {

			for (int i = 0; i < theUsers.getSize(); i++) {
				System.out.println("-Made it to for loop-");
				if (theUsers.getIndex(i).getName().toLowerCase()
						.equals(name.toLowerCase())) {
					ArrayList<Job> currentJobs = theJobs.filterPast();
					userFound = true;
					System.out.println("-Found a User-");
					if (theUsers.getIndex(i).getType().equals("Manager")) {
						// TODO: Go to Park Manager
						this.setVisible(false);

						ParkManager manager = (ParkManager) theUsers
								.getIndex(i);

						ParkManagerPanel managerPanel = new ParkManagerPanel(
								manager, currentJobs);
						managerPanel.addPropertyChangeListener(this);
						myFrame.getContentPane().add(managerPanel,
								BorderLayout.CENTER);
						myFrame.setResizable(true);
						myFrame.pack();

					} else if (myUsers.getIndex(i).getType()
							.equals("Volunteer")) {
						// TODO: Go to Volunteer
						this.setVisible(false);

						Volunteer volunteer = (Volunteer) (myUsers.getIndex(i));
						VolunteerPanel volunteerPanel = new VolunteerPanel(
								volunteer, theJobs);
						// myFrame.getContentPane().add(volPanel,
						// BorderLayout.CENTER);
						myFrame.setResizable(true);
						myFrame.pack();

					} else if (myUsers.getIndex(i).getType()
							.equals("Urban Parks Employee")) {
						// TODO: Go to Employee
						this.setVisible(false);

						UrbanParksEmployee employee = (UrbanParksEmployee) (myUsers
								.getIndex(i));
						UrbanParksPanel employeePanel = new UrbanParksPanel(
								theJobs);

						myFrame.getContentPane().add(employeePanel,
								BorderLayout.CENTER);
						myFrame.setResizable(true);
						myFrame.pack();
					}
				}
			}
		}

		if (userFound == false) {
			JOptionPane.showMessageDialog(myFrame,
					"Invalid user. Please check the spelling!",
					"Cannot Sign In",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("Manager add")) {
			// ParkManager manager = (ParkManager) evt.getOldValue();
			// System.out.println(
			// myJobs.getSize() + " " + manager.getJobs().size());
			// // manager has a new job to add.
			// myJobs.addNewJob((Job) evt.getNewValue());
			//
			// manager.addJob((Job) evt.getNewValue());
			// System.out.println(
			// myJobs.getSize() + " " + manager.getJobs().size());
			firePropertyChange("Manager add", evt.getOldValue(),
					evt.getNewValue());
		} else if (evt.getPropertyName().equals("Manager remove")) {
			// System.out.println(
			// "ORIGINAL BEFORE REMOVING SIZE " + myJobs.getSize());
			// ParkManager manager = (ParkManager) evt.getOldValue();
			// // delete the job
			// JobCollection.removeJob(evt.getNewValue().toString(), manager);
			// System.out.println("AFTER REMOVING SIZE " + myJobs.getSize());
			// for (int i = 0; i < myJobs.getSize(); i++) {
			// System.out.println(myJobs.getIndex(i));
			firePropertyChange("Manager remove", evt.getOldValue(),
					evt.getNewValue());
		}
	}

}