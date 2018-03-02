package user_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import model.Job;
import model.ParkManager;

public class ParkManagerMenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu SignOut;
	private JMenu Updates;
	private JMenu NewJob;
	private JMenu ViewCurrent;
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
		ViewCurrent = new JMenu("View Current Jobs");
		ViewCurrent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				new ParkManagerDisplayCurrentJobs(myManager);
			}
		});
		
	}
	private void newJob() {
		// TODO Auto-generated method stub
		NewJob = new JMenu("Create a new Job");
		NewJob.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				new ParkManagerNewJobPanel(myManager);
			}
		});
	}
	
	private void updates() {
		// TODO Auto-generated method stub
		Updates = new JMenu("Update Jobs");
		Updates.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				new ParkManagerCancelJobsPanel(Job.filterForCancellation(myManager.getJobs()));
			}
		});

		
	}
	private void signOut() {
		// TODO Auto-generated method stub
		SignOut = new JMenu("Sign Out");
		SignOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
								
			}
		});
		
	}
}
