package user_interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Job;
import model.JobCollection;
import model.ParkManager;

public class ParkManagerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel currentJobs;
	private JPanel myNewJob;
	private JPanel myUpdatePanel;
	
	public ParkManagerPanel(ParkManager theManager, JobCollection theJobs) {
		
		this.setBorder(BorderFactory.createTitledBorder("Your Jobs:"));
		setLayout(new BorderLayout());
		displayCurrentJobs(theManager, theJobs);
		add(currentJobs, BorderLayout.CENTER);
		add(new MenuBar(), BorderLayout.NORTH);
	}
	/*Display all of the managers current Jobs. */
	private void displayCurrentJobs(ParkManager theManager, JobCollection theJobs) {
		currentJobs = new JPanel();
		currentJobs.setLayout(new GridLayout(theJobs.getSize(), 1));
		JLabel myJobLabels = new JLabel();
		//create a new label for each job and add
		for (int i = 0; i<theJobs.getSize(); i++){
			myJobLabels.setText(theManager.getJobs().get(i).toString());
			currentJobs.add(myJobLabels);
		}
	}
	//create a new panel that has fields for input.
	private void newJobPanel(ParkManager theManager, JobCollection theJobs) {
		myNewJob = new JPanel();
		myNewJob.setLayout(new GridLayout(5,2));
		//add all inputs.
		JLabel title = new JLabel("Job Title: ");
		JTextField tIn = new JTextField();
		myNewJob.add(title);
		myNewJob.add(tIn);
		
		JLabel location = new JLabel("Job Location: ");
		JTextField lIn = new JTextField();
		myNewJob.add(location);
		myNewJob.add(lIn);
		
		JLabel start = new JLabel("Start date MM/DD/YYYY: ");
		JTextField sIn = new JTextField();
		myNewJob.add(start);
		myNewJob.add(sIn);
		
		JLabel end = new JLabel("End date MM/DD/YYYY: ");
		JTextField eIn = new JTextField();
		myNewJob.add(end);
		myNewJob.add(eIn);
		
		JLabel discription = new JLabel("Discription: ");
		JTextField dIn = new JTextField();		
		myNewJob.add(discription);
		myNewJob.add(dIn);
		
		tIn.setEnabled(true);
		lIn.setEnabled(false);
		sIn.setEnabled(false);
		eIn.setEnabled(false);
		dIn.setEnabled(false);
		while(tIn.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a valid title");
			lIn.setEnabled(false);
			sIn.setEnabled(false);
			eIn.setEnabled(false);
			dIn.setEnabled(false);
		}
		
		lIn.setEnabled(true);
		while(lIn.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a valid location");
			sIn.setEnabled(false);
			eIn.setEnabled(false);
			dIn.setEnabled(false);
		}
		
		sIn.setEnabled(true);
		while(sIn.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a valid start date");
			
			eIn.setEnabled(false);
			dIn.setEnabled(false);
		}
		
		String[] startDateArray = sIn.getText().split("/");
		LocalDate startDate = LocalDate.of(Integer.parseInt(startDateArray[2]),
				Integer.parseInt(startDateArray[0]), Integer.parseInt(startDateArray[1]));
		/////////CHECK BUSINESS RULES
		while(!theManager.isJobNotTooFar(startDate)/////////////////////////////////////////////////////////////////////CHECK THIS.
				|| ChronoUnit.DAYS.between(LocalDate.now(), startDate)< 0  || Job.isJobTooFar(startDate)) {
			JOptionPane.showMessageDialog(null, "Please enter a valid start date, "
					+ "this date is too far or is in the past");
			sIn.setText("");//empty out the field.
			startDateArray = sIn.getText().split("/");
			startDate = LocalDate.of(Integer.parseInt(startDateArray[2]),
					Integer.parseInt(startDateArray[0]), Integer.parseInt(startDateArray[1]));
			
			eIn.setEnabled(false);
			dIn.setEnabled(false);
		}
		
		
		eIn.setEnabled(true);
		while(eIn.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a valid end date");
			
			eIn.setEnabled(false);
			dIn.setEnabled(false);
		}
		String[] endDateArray = eIn.getText().split("/");
		LocalDate endDate = LocalDate.of(Integer.parseInt(endDateArray[2]),
				Integer.parseInt(endDateArray[0]), Integer.parseInt(endDateArray[1]));
		while(!theManager.isMaxDaysUnder(startDate, endDate) || Job.isJobTooFar(endDate)) {
			System.out.println("Please limit your job to "+Job.MAX_LENGTH+" days or under.");
			eIn.setText(""); //empty out the text field
			endDateArray = eIn.getText().split("/");
			endDate = LocalDate.of(Integer.parseInt(endDateArray[2]),
					Integer.parseInt(endDateArray[0]), Integer.parseInt(endDateArray[1]));
			
			dIn.setEnabled(false);
		}
		
		
		dIn.setEnabled(true);
		while(dIn.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a valid description");
		}
		
		//add job to list.
		
		
		Job newJob = new Job(tIn.getText(), dIn.getText(), lIn.getText(), startDate, endDate);
		theJobs.addNewJob(newJob);
		theManager.addJob(newJob);
		add(myNewJob, BorderLayout.CENTER);
	}
	
	private void updatesPanel(ParkManager theManager) {
		myUpdatePanel = new JPanel();
		JButton cancel = new JButton();
		ButtonGroup myJobsGroup = new ButtonGroup();
		for(int i = 0; i<theManager.getJobs().size(); i++){ ////////////////////////////////getJobs gets unfiltered.
			JRadioButton j = new JRadioButton();
			j.setText(theManager.getJobs().get(i).toString());
			myJobsGroup.add(j);
		}
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				//find the button and then find the corresponding job and remove. 
				for(int i = 0; i<myJobsGroup.getButtonCount(); i++) {
					
				}
			}

			
		});
		myUpdatePanel.add(cancel, BorderLayout.SOUTH);
		add(myUpdatePanel, BorderLayout.CENTER);
		
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
					displayCurrentJobs(null, null);
				}
			});
			
		}
		private void newJob() {
			// TODO Auto-generated method stub
			NewJob = new JMenu("Create a new Job");
			NewJob.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {
					newJobPanel(null, null);
				}
			});
		}
		
		private void updates() {
			// TODO Auto-generated method stub
			Updates = new JMenu("Update Jobs");
			Updates.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent theEvent) {
					updatesPanel(null);
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
}

