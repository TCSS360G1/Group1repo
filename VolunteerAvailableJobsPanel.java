package user_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.AlreadySignedUpException;
import model.Job;
import model.JobCollection;
import model.MinimumDaysException;
import model.ScheduleConflictException;
import model.Volunteer;

public class VolunteerAvailableJobsPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Volunteer myVolunteer;
	private ArrayList<Job> myJobs;
	private JPanel myAvailableJobs;

	public VolunteerAvailableJobsPanel(Volunteer theVolunteer,
			ArrayList<Job> theJobs) {
		System.out.println("Available");
		myVolunteer = theVolunteer;
		myJobs = theJobs;
		setupPanel();
	}

	private void setupPanel() {
		this.setBorder(BorderFactory
				.createTitledBorder("All jobs that are available"));
		myAvailableJobs = new JPanel();
		setLayout(new BorderLayout());
		displayAvailableJobs(myJobs);
	}

	private void displayAvailableJobs(ArrayList<Job> theJobs) {
		System.out.println(theJobs.size());
		JButton add = new JButton("Signup");
		ButtonGroup BG = new ButtonGroup();
		for (int i = 0; i < theJobs.size(); i++) {
			JRadioButton j = new JRadioButton();
			j.setText((i + 1) + ". " + theJobs.get(i).toString());
			BG.add(j);
			myAvailableJobs.add(j);
		}
		add(add, BorderLayout.SOUTH);

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String selected = BG.getSelection().toString();
				String[] split = selected.split(".");
				int index = Integer.parseInt(split[0]);

				// myVolunteer.addJob(myJobs.get(index));
				firePropertyChange("Volunteer add", myVolunteer,
						myJobs.get(index));

			}

		});
		add(myAvailableJobs, BorderLayout.CENTER);

	}
}