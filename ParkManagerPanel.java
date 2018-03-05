package user_interface;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Observable;

import model.Job;
import model.JobCollection;
import model.ParkManager;

public class ParkManagerPanel extends JPanel implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel myCancellations;
	private JPanel myNewJobs;

	private ParkManager myManager;

	private JMenuBar myJMenuBar;
	private JPanel myCurrentJobsPanel;
	private ArrayList<Job> mySystemJobs;

	public ParkManagerPanel(ParkManager theManager, ArrayList<Job> theJobs) {
		System.out.println("size:" + theJobs.size());
		System.out.println("managers job: " + theManager.getJobs());
		mySystemJobs = theJobs;
		myManager = theManager;
		// System.out.println(Job.filterForCancellation(myManager.getJobs()).size());
		// Job j = new Job("");
		// myManager.addJob(j);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 600));
		myJMenuBar = new MenuBar();
		add(myJMenuBar, BorderLayout.NORTH);
///////////////////////////////////////////////////////////////////ADDED LISTENERS HERE!!!
		myCurrentJobsPanel = new ParkManagerDisplayCurrentJobs(theManager);
		myNewJobs = new ParkManagerNewJobPanel(myManager);
		myNewJobs.addPropertyChangeListener(this);
		myCurrentJobsPanel = new ParkManagerDisplayCurrentJobs(myManager);
		myCancellations = new ParkManagerCancelJobsPanel(myManager,
				Job.filterForCancellation(myManager.getJobs()));
		myCancellations.addPropertyChangeListener(this);

		add(myCurrentJobsPanel, BorderLayout.CENTER);
		// displayCurrentJobs(myManager);

		setVisible(true);
	}

	private void addNewJobPanel() {
		add(myNewJobs, BorderLayout.CENTER);
	}

	private void addCurrentJobPanel() {
		add(myCurrentJobsPanel, BorderLayout.CENTER);
	}

	private void addCancellationsJobPanel() {
		add(myCancellations, BorderLayout.CENTER);
	}

	public class MenuBar extends JMenuBar {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JButton mySignOut;
		private JButton myUpdates;
		private JButton myNewJob;
		private JButton myViewCurrent;

		public MenuBar() {
			super();

			current();
			updates();
			newJob();
			signOut();

		}

		private void current() {
			myViewCurrent = new JButton("View Current Jobs");
			myViewCurrent.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {
					// currentJobs.setVisible(false);
					myNewJobs.setVisible(false);
					myCancellations.setVisible(false);
					myCurrentJobsPanel = new ParkManagerDisplayCurrentJobs(myManager);
					myCurrentJobsPanel.setVisible(true);
					addCurrentJobPanel();

				}
			});
			add(myViewCurrent);
		}

		private void newJob() {			
			myNewJob = new JButton("Create a new Job");
			myNewJob.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {

					if (mySystemJobs.size() == Job.getLegalJobAmount()) {
						JOptionPane.showMessageDialog(null,
								"We are sorry, at this time we are not accepting"
										+ " any jobs please check bck in another time");
					} else {
						myCurrentJobsPanel.setVisible(false);
						myCancellations.setVisible(false);
						myNewJobs = new ParkManagerNewJobPanel(myManager);
						myNewJobs.setVisible(true);
						addNewJobPanel();
					}

					// JOptionPane.showMessageDialog(null, "Clicked the new
					// job");
				}
			});
			add(myNewJob);
		}

		private void updates() {
			
			myUpdates = new JButton("Update Jobs");
			myUpdates.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {

					// System.out.println(Job.filterForCancellation(myManager.getJobs())).size());

					if ((Job.filterForCancellation(myManager.getJobs()))
							.size() == 0) {
						myCancellations.setVisible(false);
						JOptionPane.showMessageDialog(null,
								"Sorry, you currently do not have any jobs.");
					} else {
						myNewJobs.setVisible(false);
						myCurrentJobsPanel.setVisible(false);
						myCancellations = new ParkManagerCancelJobsPanel(myManager, Job.filterForCancellation(myManager.getJobs()));
						myCancellations.setVisible(true);
						addCancellationsJobPanel();
					}

				}
			}); 
			add(myUpdates);
		}

		private void signOut() {
			mySignOut = new JButton("Sign Out");
			mySignOut.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {

				}
			});
			add(mySignOut);
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// get the add event and then fire a listener to the sign in panel.
		if (evt.getPropertyName().equals("Manager add")) {
			ParkManager manager = (ParkManager) evt.getOldValue();
			System.out.println("change recieved in pmp");
			firePropertyChange("Manager add", manager, evt.getNewValue());
		} else if (evt.getPropertyName().equals("Manager remove")) {
			ParkManager manager = (ParkManager) evt.getOldValue();
			firePropertyChange("Manager remove", manager, evt.getNewValue());
		}

	}

}
