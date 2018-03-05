package user_interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	LocalDate myStartInput;
	LocalDate myEndInput;

	public ParkEmployeeDisplayJobs(JobCollection theJobs) {
		myJobs = theJobs;
		this.setBorder(
				BorderFactory.createTitledBorder("All UrbanParks Jobs:"));
		setLayout(new BorderLayout());
		displayCurrentJobs(theJobs);
	}

	/** Display all of the Jobs by looping through the list of jobs. 
	 * @preCondition: pass in a non null job collection
	 */
	private void displayCurrentJobs(JobCollection theJobs) {
		currentJobs = new JPanel();
		currentJobs.setLayout(new GridLayout(theJobs.getSize(), 1));
		// System.out.println("--"+theJobs.getSize());

		// create a new label for each job and add

		for (int i = 0; i < theJobs.getSize(); i++) {
			// System.out.println(i);
			JLabel myJobLabels = new JLabel();
			myJobLabels.setText(theJobs.getIndex(i).toString());
			currentJobs.add(myJobLabels);
		}
		add(currentJobs, BorderLayout.CENTER);
	}
	
	
	protected void displayDateSearch(){
		String StartMSearch = JOptionPane
				.showInputDialog("Search Start Month:");
		String StartDSearch = JOptionPane
				.showInputDialog("Search Start Day:");
		String StartYSearch = JOptionPane
				.showInputDialog("Search Start Year:");
		myStartInput = LocalDate.of(Integer.parseInt(StartYSearch),
				Integer.parseInt(StartMSearch),Integer.parseInt(StartDSearch));
		
		String EndMSearch = JOptionPane
				.showInputDialog("Search End Month:");
		String EndDSearch = JOptionPane
				.showInputDialog("Search End Day:");
		String EndYSearch = JOptionPane
				.showInputDialog("Search End Year:");
		myEndInput = LocalDate.of(Integer.parseInt(EndYSearch),
				Integer.parseInt(EndMSearch),Integer.parseInt(EndDSearch));
		
	}
	
	/** Display all of the Jobs by looping through the list of jobs. 
	 * @preCondition: pass in a non null job collection
	 */
	protected void displaySearchJobs(JobCollection theJobs) {
		currentJobs = new JPanel();
		currentJobs.setLayout(new GridLayout(theJobs.getSize(), 1));
		// System.out.println("--"+theJobs.getSize());

		// create a new label for each job and add

		for (int i = 0; i < theJobs.getSize(); i++) {
			// System.out.println(i);
			if(theJobs.getIndex(i).isInbetween(myStartInput, theJobs.getIndex(i).getStartDate(), myEndInput
					, theJobs.getIndex(i).getEndDate()));
			JLabel myJobLabels = new JLabel();
			myJobLabels.setText(theJobs.getIndex(i).toString());
			currentJobs.add(myJobLabels);
		}
		add(currentJobs);
		repaint();
	}
}