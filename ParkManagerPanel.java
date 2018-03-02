package user_interface;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.util.Observable;

import model.Job;
import model.ParkManager;

public class ParkManagerPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel myUpdatePanel;
	private ParkManager myManager;

	public ParkManagerPanel(ParkManager theManager) {

		myManager = theManager;
		this.setBorder(BorderFactory.createTitledBorder("Your Jobs:"));
		setLayout(new BorderLayout());
		add(new MenuBar(), BorderLayout.NORTH);
		new ParkManagerDisplayCurrentJobs(theManager);
	}

	

	public class MenuBar extends JMenuBar {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JMenu SignOut;
		private JMenu Updates;
		private JMenu NewJob;
		private JMenu ViewCurrent;

		public MenuBar() {
			super();
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
					//updatesPanel(myManager); //this is passing in entire job class. we want to only pass in jobs that are available to be cancelled.
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
