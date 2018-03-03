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
	
	/**
	 * 
	 */
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
	

	private void current() {
		// TODO Auto-generated method stub
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

	private void newJob() {
		// TODO Auto-generated method stub
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

	private void updates() {
		// TODO Auto-generated method stub
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