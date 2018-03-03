package user_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ParkManager;

public class ParkManagerDisplayCurrentJobs extends JPanel {
	JPanel currentJobs;
	ParkManager myManager;
	public ParkManagerDisplayCurrentJobs(ParkManager theManager){
		myManager = theManager;
		setPreferredSize(new Dimension(600,600));
		displayCurrentJobs(myManager);
		
	}

	/*Display all of the managers current Jobs. */
	private void displayCurrentJobs(ParkManager theManager) {
		currentJobs = new JPanel();
		currentJobs.setLayout(new GridLayout(theManager.getJobs().size(), 1));
		this.setBorder(BorderFactory.createTitledBorder("Your Jobs:"));
		JLabel myJobLabels = new JLabel();
		//create a new label for each job and add
		for (int i = 0; i<theManager.getJobs().size(); i++){
			myJobLabels.setText(theManager.getJobs().get(i).toString());
			currentJobs.add(myJobLabels);
		}
		add(currentJobs, BorderLayout.CENTER);
	}
}
