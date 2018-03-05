package user_interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.JobCollection;
import model.UrbanParksEmployee;

/**
 * A panel that displays the current jobs the park manager has in their list of
 * jobs.
 */
public class ParkEmployeeDisplayJobs extends JPanel {
	JPanel currentJobs;
	UrbanParksEmployee myEmployee;
	JobCollection myJobs;

	public ParkEmployeeDisplayJobs(String theEmployeeName, JobCollection theJobs) {
		myJobs = theJobs;
		this.setBorder(
				BorderFactory.createTitledBorder("Welcome, " + theEmployeeName 
						+ ". All Urban Parks Jobs:"));
		setLayout(new BorderLayout());
		displayCurrentJobs(theJobs);
	}

	/**
	 * precondition: theJobs != null.
	 * 
	 * postcondition: Display all of the Jobs by looping through the list of jobs.
	 */
	private void displayCurrentJobs(JobCollection theJobs) {
		currentJobs = new JPanel();
		currentJobs.setLayout(new GridLayout(theJobs.getSize(), 1));

		// create a new label for each job and add
		for (int i = 0; i < theJobs.getSize(); i++) {
			JLabel myJobLabels = new JLabel();
			myJobLabels.setText(theJobs.getIndex(i).toString());
			currentJobs.add(myJobLabels);
		}
		add(currentJobs, BorderLayout.CENTER);
	}
}
