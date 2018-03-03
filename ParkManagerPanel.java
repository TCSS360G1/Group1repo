package user_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Observable;

import model.Job;
import model.JobCollection;
import model.ParkManager;

public class ParkManagerPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel myCancellations;
	private JPanel myNewJobs;
	
	private ParkManager myManager;

	private JMenuBar myJMenuBar;
	private JPanel myCurrentJobsPanel;
	private ArrayList mySystemJobs;
	

	public ParkManagerPanel(ParkManager theManager, ArrayList<Job> theJobs) {
		System.out.println(theManager.getFirstName());
		mySystemJobs = theJobs;
		myManager = theManager;
		System.out.println(Job.filterForCancellation(myManager.getJobs()).size());
		//Job j = new Job("");
		//myManager.addJob(j);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600,600));
		myJMenuBar = new MenuBar();
		add(myJMenuBar, BorderLayout.NORTH);
		
		myCurrentJobsPanel = new ParkManagerDisplayCurrentJobs(theManager);
		add(myCurrentJobsPanel, BorderLayout.CENTER);
		//displayCurrentJobs(myManager);
		
		
		setVisible(true);
	}
	
	private void addNewJobPanel() {
		add(myNewJobs, BorderLayout.SOUTH);
	}
	
	private void addCurrentJobPanel() {
		add(myCurrentJobsPanel, BorderLayout.SOUTH);
	}

	private void addCancellationsJobPanel() {
		add(myCancellations, BorderLayout.SOUTH);		
	}
	public class MenuBar extends JMenuBar {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JMenuItem mySignOut;
		private JMenuItem myUpdates;
		private JMenuItem myNewJob;
		private JMenuItem myViewCurrent;
		
		public MenuBar() {
			super();
			myNewJobs = new ParkManagerNewJobPanel(myManager);
			myCurrentJobsPanel = new ParkManagerDisplayCurrentJobs(myManager);
			myCancellations = new ParkManagerCancelJobsPanel(Job.filterForCancellation(myManager.getJobs()));
			current();
			updates();
			newJob();
			signOut();
			
		}

		private void current() {
			// TODO Auto-generated method stub
			JMenu current = new JMenu("Jobs");
			add(current);
			myViewCurrent = new JMenuItem("View Current Jobs");
			myViewCurrent.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) { 
					//currentJobs.setVisible(false);
					myNewJobs.setVisible(false);
					myCancellations.setVisible(false);
					myCurrentJobsPanel.setVisible(true);
					addCurrentJobPanel();
					
				}
			});
			current.add(myViewCurrent);
		}

		private void newJob() {
			// TODO Auto-generated method stub
			JMenu newJob = new JMenu("NEW");
			add(newJob);
			myNewJob = new JMenuItem("Create a new Job");
			myNewJob.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {
					
					
					
					if(mySystemJobs.size()==Job.getLegalJobAmount()) {
						JOptionPane.showMessageDialog(null, 
								"We are sorry, at this time we are not accepting"
								+ " any jobs please check bck in another time");
					} else {
						myCurrentJobsPanel.setVisible(false);
						myCancellations.setVisible(false);
						myNewJobs.setVisible(true);
						addNewJobPanel();
					}
					
					//JOptionPane.showMessageDialog(null, "Clicked the new job");
				}
			});
			newJob.add(myNewJob);
		}

		private void updates() {
			// TODO Auto-generated method stub
			JMenu cancel = new JMenu("Cancel");
			add(cancel);
			myUpdates = new JMenuItem("Update Jobs");
			myUpdates.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {
					
					
					
					if((Job.filterForCancellation(myManager.getJobs())).size() == 0) {
						myCancellations.setVisible(false);
						JOptionPane.showMessageDialog(null, "Sorry, you currently do not have any jobs.");
					} else {
						myNewJobs.setVisible(false);
						myCurrentJobsPanel.setVisible(false);
						myCancellations.setVisible(true);
						addCancellationsJobPanel();
					}
					
				}
			});
			cancel.add(myUpdates);
		}

		private void signOut() {
			// TODO Auto-generated method stub
			JMenu out = new JMenu("SignOut");
			add(out);
			mySignOut = new JMenuItem("Sign Out");
			mySignOut.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {
					
				}
			});
			out.add(mySignOut);
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
