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
import java.util.Observable;

import model.Job;
import model.ParkManager;

public class ParkManagerPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel cancellations;
	private JPanel myNewJobs;
	
	private ParkManager myManager;

	private JMenuBar x;
	private JPanel currentJobs;
	

	public ParkManagerPanel(ParkManager theManager) {
		System.out.println(theManager.getFirstName());
		
		myManager = theManager;
		System.out.println(Job.filterForCancellation(myManager.getJobs()).size());
		//Job j = new Job("");
		//myManager.addJob(j);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600,600));
		x = new MenuBar();
		add(x, BorderLayout.NORTH);
		
		currentJobs = new ParkManagerDisplayCurrentJobs(theManager);
		add(currentJobs, BorderLayout.CENTER);
		//displayCurrentJobs(myManager);
		
		
		setVisible(true);
	}
	
	private void addNewJobPanel() {
		add(myNewJobs, BorderLayout.SOUTH);
	}
	
	private void addCurrentJobPanel() {
		add(currentJobs, BorderLayout.SOUTH);
	}

	private void addCancellationsJobPanel() {
		add(cancellations, BorderLayout.SOUTH);		
	}
	public class MenuBar extends JMenuBar {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JMenuItem SignOut;
		private JMenuItem Updates;
		private JMenuItem NewJob;
		private JMenuItem ViewCurrent;
		
		public MenuBar() {
			super();
			myNewJobs = new ParkManagerNewJobPanel(myManager);
			currentJobs = new ParkManagerDisplayCurrentJobs(myManager);
			cancellations = new ParkManagerCancelJobsPanel(Job.filterForCancellation(myManager.getJobs()));
			current();
			updates();
			newJob();
			signOut();
			
		}

		private void current() {
			// TODO Auto-generated method stub
			JMenu current = new JMenu("Jobs");
			add(current);
			ViewCurrent = new JMenuItem("View Current Jobs");
			ViewCurrent.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {
					//currentJobs.setVisible(false);
					myNewJobs.setVisible(false);
					cancellations.setVisible(false);
					currentJobs.setVisible(true);
					addCurrentJobPanel();
					
				}
			});
			current.add(ViewCurrent);
		}

		private void newJob() {
			// TODO Auto-generated method stub
			JMenu newJob = new JMenu("NEW");
			add(newJob);
			NewJob = new JMenuItem("Create a new Job");
			NewJob.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {
					
					
					currentJobs.setVisible(false);
					
					cancellations.setVisible(false);
					myNewJobs.setVisible(true);
					addNewJobPanel();
					//JOptionPane.showMessageDialog(null, "Clicked the new job");
				}
			});
			newJob.add(NewJob);
		}

		private void updates() {
			// TODO Auto-generated method stub
			JMenu cancel = new JMenu("Cancel");
			add(cancel);
			Updates = new JMenuItem("Update Jobs");
			Updates.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {
					//updatesPanel(myManager); //this is passing in entire job class. we want to only pass in jobs that are available to be cancelled.
					
					
					if((Job.filterForCancellation(myManager.getJobs())).size() == 0) {
						cancellations.setVisible(false);
						JOptionPane.showMessageDialog(null, "Sorry, you currently do not have any jobs.");
					} else {
						myNewJobs.setVisible(false);
						currentJobs.setVisible(false);
						cancellations.setVisible(true);
						addCancellationsJobPanel();
					}
					
				}
			});
			cancel.add(Updates);
		}

		private void signOut() {
			// TODO Auto-generated method stub
			JMenu out = new JMenu("SignOut");
			add(out);
			SignOut = new JMenuItem("Sign Out");
			SignOut.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {
					
				}
			});
			out.add(SignOut);
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
