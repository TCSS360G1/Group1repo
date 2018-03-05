package user_interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.Job;
import model.ParkManager;

public class ParkManagerMenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	
	private JMenuItem SignOut;
	private JMenuItem Updates;
	private JMenuItem NewJob;
	private JMenuItem ViewCurrent;
	private ParkManager myManager;
	
	public ParkManagerMenuBar(ParkManager theManager) {
		
		super();
		myManager = theManager;
		signOut();
		updates();
		newJob();
		current();
	}
	
       /**
        * precondition: This ParkManagerMenuBar != null.
        * 
        * postcondition: Creates the "View Current Jobs" item within the
        * "Jobs" Menu in this Menu Bar.
        */
	private void current() {
		JMenu current = new JMenu("Jobs");
		add(current);
		ViewCurrent = new JMenuItem("View Current Jobs");
		ViewCurrent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				new ParkManagerDisplayCurrentJobs(myManager);
				add(new ParkManagerDisplayCurrentJobs(myManager), BorderLayout.CENTER);
			}
		});
		current.add(ViewCurrent);
	}

	/**
	 * precondition: This ParkManagerMenuBar != null.
	 * 
	 * postcondition: Creates the "Create a New Job" item within the
	 * "NEW" menu in this Menu Bar.
	 */
	private void newJob() {
		JMenu newJob = new JMenu("NEW");
		add(newJob);
		NewJob = new JMenuItem("Create a new Job");
		NewJob.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				new ParkManagerNewJobPanel(myManager);
				//JOptionPane.showMessageDialog(null, "Clicked the new job");
				add(new ParkManagerNewJobPanel(myManager), BorderLayout.CENTER);
				
			}
		});
		newJob.add(NewJob);
	}

	/**
	 * precondition: This ParkManagerMenuBar != null.
	 * 
	 * postcondition: Creates the "Update Jobs" item within the
	 * "Cancel" menu in this Menu Bar.
	 */
	private void updates() {
		JMenu cancel = new JMenu("Cancel");
		add(cancel);
		Updates = new JMenuItem("Update Jobs");
		Updates.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				//updatesPanel(myManager); //this is passing in entire job class. we want to only pass in jobs that are available to be cancelled.
				new ParkManagerCancelJobsPanel(Job.filterForCancellation(myManager.getJobs()));
				add(new ParkManagerCancelJobsPanel(Job.filterForCancellation(myManager.getJobs())), BorderLayout.CENTER);
			}
		});
		cancel.add(Updates);
	}

	/**
	 * precondition: This ParkManagerMenuBar != null.
	 * 
	 * postcondition: Creates a Sign Out button.
	 */
	private void signOut() {
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
