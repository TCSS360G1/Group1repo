package user_interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.JobCollection;
import model.UrbanParksEmployee;

public class ParkEmployeeDisplayJobs extends JPanel {
	JPanel currentJobs;
	UrbanParksEmployee myEmployee;
	JobCollection myJobs;
	
	public ParkEmployeeDisplayJobs(JobCollection theJobs) {
		myJobs = theJobs;
		this.setBorder(BorderFactory
				.createTitledBorder("All UrbanParks Jobs:"));
		setLayout(new BorderLayout());
		displayCurrentJobs(theJobs);
	}

	/**
	 * precondition: theJobs != null.
	 * 
	 * postcondition: Display all of the Jobs.
	 */
	private void displayCurrentJobs(JobCollection theJobs) {
		currentJobs = new JPanel();
		currentJobs.setLayout(new GridLayout(theJobs.getSize(), 1));
		//System.out.println("--"+theJobs.getSize());
		
		//create a new label for each job and add
	
		for (int i = 0; i<theJobs.getSize(); i++){
			//System.out.println(i);
			JLabel myJobLabels = new JLabel();
			myJobLabels.setText(theJobs.getIndex(i).toString());
			currentJobs.add(myJobLabels);
		}
		add(currentJobs, BorderLayout.CENTER);
	}
}
