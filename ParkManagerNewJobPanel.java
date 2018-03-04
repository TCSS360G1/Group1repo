/**
 * 
 */
package user_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Job;
import model.JobCollection;
import model.ParkManager;

/**
 * @author deepjot
 *
 */
public class ParkManagerNewJobPanel extends JPanel  {
	private JPanel myNewJob;
	private ParkManager myManager;
	private LocalDate startDate;
	private LocalDate endDate;
	private String[] startDateArray;

	public ParkManagerNewJobPanel(ParkManager theManager) {
		myManager = theManager;
		//System.out.println("xxx");
		this.setBorder(BorderFactory.createTitledBorder("New Job:"));
		setLayout(new BorderLayout());
		newJobPanel(myManager);
		
		setVisible(true);

	}

	// create a new panel that has fields for input.
	private void newJobPanel(ParkManager theManager) {
		myNewJob = new JPanel();
		myNewJob.setLayout(new GridLayout(24, 1));
		// add all inputs.
		JButton done = new JButton("Submit");
		done.setEnabled(false);
		JLabel title = new JLabel("Job Title: ");
		JTextField tIn = new JTextField();
		JButton tDone = new JButton("Done");

		myNewJob.add(title);
		myNewJob.add(tIn);
		myNewJob.add(tDone);

		JLabel location = new JLabel("Job Location: ");
		JTextField lIn = new JTextField();
		JButton lDone = new JButton("Done");
		myNewJob.add(location);
		myNewJob.add(lIn);
		myNewJob.add(lDone);

		JLabel startm = new JLabel("Start date MONTH: ");
		JTextField smIn = new JTextField();
		// JButton smDone = new JButton("Done");
		myNewJob.add(startm);
		myNewJob.add(smIn);
		// myNewJob.add(smDone);

		JLabel startd = new JLabel("Start date DAY: ");
		JTextField sdIn = new JTextField();
		// JButton sdDone = new JButton("Done");
		myNewJob.add(startd);
		myNewJob.add(sdIn);
		// myNewJob.add(sdDone);

		JLabel starty = new JLabel("Start date YEAR: ");
		JTextField syIn = new JTextField();
		JButton syDone = new JButton("Done");
		myNewJob.add(starty);
		myNewJob.add(syIn);
		myNewJob.add(syDone);

		JLabel endm = new JLabel("End date MONTH: ");
		JTextField emIn = new JTextField();
		// JButton emDone = new JButton("Done");
		myNewJob.add(endm);
		myNewJob.add(emIn);
		// myNewJob.add(emDone);

		JLabel endd = new JLabel("End date DAY: ");
		JTextField edIn = new JTextField();
		// JButton edDone = new JButton("Done");
		myNewJob.add(endd);
		myNewJob.add(edIn);
		// myNewJob.add(edDone);

		JLabel endy = new JLabel("End date YEAR: ");
		JTextField eyIn = new JTextField();
		JButton eyDone = new JButton("Done");
		myNewJob.add(endy);
		myNewJob.add(eyIn);
		myNewJob.add(eyDone);

		JLabel discription = new JLabel("Discription: ");
		JTextField dIn = new JTextField();
		dIn.setPreferredSize(new Dimension(60,10));
		JButton dDone = new JButton("Done");
		myNewJob.add(discription);
		myNewJob.add(dIn);
		myNewJob.add(dDone);
		myNewJob.add(done);
		add(myNewJob, BorderLayout.CENTER);
		
		tIn.setEnabled(true);
		tDone.setEnabled(true);
		lIn.setEnabled(false);
		lDone.setEnabled(false);
		smIn.setEnabled(false); // smDone.setEnabled(false);
		sdIn.setEnabled(false); // sdDone.setEnabled(false);
		syIn.setEnabled(false);
		syDone.setEnabled(false);

		emIn.setEnabled(false); // emDone.setEnabled(false);
		edIn.setEnabled(false); // edDone.setEnabled(false);
		eyIn.setEnabled(false);
		eyDone.setEnabled(false);

		dIn.setEnabled(false);
		dDone.setEnabled(false);

		tDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (tIn.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter a title");
				} else {
					lIn.setEnabled(true);
					lDone.setEnabled(true);
					tIn.setEnabled(false);
					tDone.setEnabled(false);
				}
			}

		});

		lDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (lIn.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Please Enter a Location");
				} else {
					smIn.setEnabled(true);
					syDone.setEnabled(true);
					sdIn.setEnabled(true);
					syIn.setEnabled(true);
					lIn.setEnabled(false);
					lDone.setEnabled(false);
					tIn.setEnabled(false);
					tDone.setEnabled(false);

				}
			}

		});

		// System.out.println("--");
		if (!smIn.getText().isEmpty() || !sdIn.getText().isEmpty() ||
				!syIn.getText().isEmpty()) {

			startDate = LocalDate.of(Integer.parseInt(syIn.getText()),
					Integer.parseInt(smIn.getText()),
					Integer.parseInt(sdIn.getText()));
		}
		syDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (smIn.getText().isEmpty() || sdIn.getText().isEmpty() ||
						syIn.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please input a valid date");
				} else {
					startDate = LocalDate.of(Integer.parseInt(syIn.getText()),
							Integer.parseInt(smIn.getText()),
							Integer.parseInt(sdIn.getText()));
					if (Job.isDateTooFar(startDate) || startDate.isBefore(LocalDate.now())) {

						JOptionPane.showMessageDialog(null,
								"Please Enter a start date, "
										+ "that is either under"
										+ Job.MAX_DISTANCE
										+ "days, or is not in the past.");
						// clear the fields
					}
					else {
						startDate = LocalDate.of(Integer.parseInt(syIn.getText()),
							Integer.parseInt(smIn.getText()),
							Integer.parseInt(sdIn.getText()));
						emIn.setEnabled(true);
						eyDone.setEnabled(true);
						eyIn.setEnabled(true);
						edIn.setEnabled(true);
						smIn.setEnabled(false);
						syDone.setEnabled(false);
						sdIn.setEnabled(false);
						syIn.setEnabled(false);
						lIn.setEnabled(false);
						lDone.setEnabled(false);
						tIn.setEnabled(false);
						tDone.setEnabled(false);
					}
				}
			}
		});

		eyDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (emIn.getText().isEmpty() || eyIn.getText().isEmpty() || edIn.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter a valid date");
				} else {
					endDate = LocalDate.of(Integer.parseInt(eyIn.getText()), Integer.parseInt(emIn.getText()), 
							Integer.parseInt(edIn.getText()));
					if (!Job.isJobNotTooLong(startDate, endDate)
							|| endDate.isBefore(LocalDate.now())
							|| Job.isDateTooFar(endDate)) {
						JOptionPane.showMessageDialog(null,
						"Please Enter a end date, "
								+ "that is either under "
								+ Job.MAX_DISTANCE
								+ " days, or is not in the past, or is not more than max length of days");
					} else {
					
						dDone.setEnabled(true);
						dIn.setEnabled(true);
						emIn.setEnabled(false);
						eyDone.setEnabled(false);
						eyIn.setEnabled(false);
						edIn.setEnabled(false);
						smIn.setEnabled(false);
						syDone.setEnabled(false);
						sdIn.setEnabled(false);
						syIn.setEnabled(false);
						lIn.setEnabled(false);
						lDone.setEnabled(false);
						tIn.setEnabled(false);
						tDone.setEnabled(false);
					}
				}
			}

		});

		dDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (dIn.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter a description");
				} else {
					done.setEnabled(true);
					//theManager.addJob(new Job(tIn.getText(), lIn.getText(), dIn.getText(), endDate, startDate));
					dDone.setEnabled(false);
					dIn.setEnabled(false);
					emIn.setEnabled(false);
					eyDone.setEnabled(false);
					eyIn.setEnabled(false);
					edIn.setEnabled(false);
					smIn.setEnabled(false);
					syDone.setEnabled(false);
					sdIn.setEnabled(false);
					syIn.setEnabled(false);
					lIn.setEnabled(false);
					lDone.setEnabled(false);
					tIn.setEnabled(false);
					tDone.setEnabled(false);
				}
			}

		});

		

		// add job to list.
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				Job newJob = new Job(tIn.getText(), dIn.getText(),
						lIn.getText(),
						startDate, endDate);
				theManager.addJob(newJob);
				System.out.println(newJob.toString());
				
				
				firePropertyChange("Manager add", myManager, newJob);
				
				done.setEnabled(false);
				//myNewJob.setVisible(false);
				//add(myCurrentJobsPanel, BorderLayout.CENTER);
				//myCurrentJobsPanel.setVisible(true);
			}

		});
		

	}

	
}
