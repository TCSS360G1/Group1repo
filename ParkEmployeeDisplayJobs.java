package user_interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.UrbanParksEmployee;

public class ParkEmployeeDisplayJobs extends JPanel {
	JPanel currentJobs;
	UrbanParksEmployee myEmployee;
	
	public ParkEmployeeDisplayJobs(UrbanParksEmployee theEmployee){
		myEmployee = theEmployee;
		this.setBorder(BorderFactory.createTitledBorder("All UrbanParks Jobs:"));
		setLayout(new BorderLayout());
		displayCurrentJobs(myEmployee);
	}

	/*Display all of the Jobs. */
	private void displayCurrentJobs(UrbanParksEmployee theEmployee) {
		currentJobs = new JPanel();
		currentJobs.setLayout(new GridLayout(theEmployee.getJobs().size(), 1));
		JLabel myJobLabels = new JLabel();
		//create a new label for each job and add
		for (int i = 0; i<theEmployee.getJobs().size(); i++){
			myJobLabels.setText(theEmployee.getJobs().get(i).toString());
			currentJobs.add(myJobLabels);
		}
		add(currentJobs, BorderLayout.CENTER);
	}
}
