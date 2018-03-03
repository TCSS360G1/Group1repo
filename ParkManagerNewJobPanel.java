/**
 * 
 */
package user_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ParkManagerNewJobPanel extends JPanel {
	private JPanel myNewJob;
	private ParkManager myManager;
	private LocalDate startDate;
	private LocalDate endDate;
	private String[] startDateArray;

	public ParkManagerNewJobPanel(ParkManager theManager) {
		myManager = theManager;
		System.out.println("xxx");
		this.setBorder(BorderFactory.createTitledBorder("New Job:"));
		setLayout(new BorderLayout());
		newJobPanel(myManager);
		
		setVisible(true);

	}

	// create a new panel that has fields for input.
	private void newJobPanel(ParkManager theManager) {
		myNewJob = new JPanel();
		myNewJob.setLayout(new GridLayout(23, 1));
		// add all inputs.
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

		JLabel endd = new JLabel("Start date DAY: ");
		JTextField edIn = new JTextField();
		// JButton edDone = new JButton("Done");
		myNewJob.add(endd);
		myNewJob.add(edIn);
		// myNewJob.add(edDone);

		JLabel endy = new JLabel("Start date YEAR: ");
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
					if (!Job.isDateTooFar(startDate) || 
							ChronoUnit.DAYS.between(LocalDate.now(), startDate) < 0) {

						JOptionPane.showMessageDialog(null,
								"Please Enter a start date, "
										+ "that is either under"
										+ Job.MAX_DISTANCE
										+ "days, or is not in the past.");
						// clear the fields
					}
				} else {

					startDate = LocalDate.of(Integer.parseInt(syIn.getText()),
							Integer.parseInt(smIn.getText()),
							Integer.parseInt(sdIn.getText()));
					emIn.setEnabled(true);
					eyDone.setEnabled(true);
					eyIn.setEnabled(true);
					edIn.setEnabled(true);
				}
			}

		});

		eyDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (emIn.getText().isEmpty()) {
					if (Job.isJobNotTooLong(startDate, endDate)
							|| ChronoUnit.DAYS.between(LocalDate.now(),
									endDate) < 0
							|| !Job.isDateTooFar(endDate)) {
						JOptionPane.showMessageDialog(null,
								"Please Enter a start date, "
										+ "that is either under"
										+ Job.MAX_DISTANCE
										+ "days, or is not in the past.");
					}
				} else {
					endDate = LocalDate.of(Integer.parseInt(eyIn.getText()), Integer.parseInt(emIn.getText()), 
							Integer.parseInt(edIn.getText()));
					dDone.setEnabled(true);
					dIn.setEnabled(true);
				}
			}

		});

		dDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (dIn.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter a description");
				} else {
					theManager.addJob(new Job(tIn.getText(), lIn.getText(), dIn.getText(), endDate, startDate));
				}
			}

		});

		// while (tIn.getText().isEmpty()) {
		// JOptionPane.showMessageDialog(null, "Please enter a valid title");
		// lIn.setEnabled(false);
		// sIn.setEnabled(false);
		// eIn.setEnabled(false);
		// dIn.setEnabled(false);
		// }
		//
		// lIn.setEnabled(true);
		// while (lIn.getText().equals("")) {
		// JOptionPane.showMessageDialog(null,
		// "Please enter a valid location");
		// sIn.setEnabled(false);
		// eIn.setEnabled(false);
		// dIn.setEnabled(false);
		// }
		//
		// sIn.setEnabled(true);
		// while (sIn.getText().equals("")) {
		// JOptionPane.showMessageDialog(null,
		// "Please enter a valid start date");
		//
		// eIn.setEnabled(false);
		// dIn.setEnabled(false);
		// }
		// if(!tIn.getText().isEmpty()) {
		// lIn.setEnabled(true);
		//
		// }
		// if(!sIn.getText().isEmpty()) {
		// String[] startDateArray = sIn.getText().split("/");
		// startDate = LocalDate.of(Integer.parseInt(startDateArray[2]),
		// Integer.parseInt(startDateArray[0]),
		// Integer.parseInt(startDateArray[1]));
		// ///////// CHECK BUSINESS RULES
		// while
		// (!theManager.isJobNotTooFar(startDate)/////////////////////////////////////////////////////////////////////
		// CHECK
		// /////////////////////////////////////////////////////////////////////
		// THIS.
		// || ChronoUnit.DAYS.between(LocalDate.now(), startDate) < 0
		// || Job.isDateTooFar(startDate)) {
		// JOptionPane.showMessageDialog(null,
		// "Please enter a valid start date, "
		// + "this date is too far or is in the past");
		// sIn.setText("");// empty out the field.
		// startDateArray = sIn.getText().split("/");
		// startDate = LocalDate.of(Integer.parseInt(startDateArray[2]),
		// Integer.parseInt(startDateArray[0]),
		// Integer.parseInt(startDateArray[1]));
		//
		// eIn.setEnabled(false);
		// dIn.setEnabled(false);
		// }
		//
		// eIn.setEnabled(true);
		// while (eIn.getText().equals("")) {
		// JOptionPane.showMessageDialog(null,
		// "Please enter a valid end date");
		//
		// eIn.setEnabled(false);
		// dIn.setEnabled(false);
		// }
		// String[] endDateArray = eIn.getText().split("/");
		// endDate = LocalDate.of(Integer.parseInt(endDateArray[2]),
		// Integer.parseInt(endDateArray[0]),
		// Integer.parseInt(endDateArray[1]));
		// while (!theManager.isMaxDaysUnder(startDate, endDate)
		// || Job.isDateTooFar(endDate)) {
		// System.out.println("Please limit your job to " + Job.MAX_LENGTH
		// + " days or under.");
		// eIn.setText(""); // empty out the text field
		// endDateArray = eIn.getText().split("/");
		// endDate = LocalDate.of(Integer.parseInt(endDateArray[2]),
		// Integer.parseInt(endDateArray[0]),
		// Integer.parseInt(endDateArray[1]));
		//
		// dIn.setEnabled(false);
		// }
		//
		// dIn.setEnabled(true);
		// while (dIn.getText().equals("")) {
		// JOptionPane.showMessageDialog(null,
		// "Please enter a valid description");
		// }
		// }

		// add job to list.
		JButton done = new JButton("Done");
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				Job newJob = new Job(tIn.getText(), dIn.getText(),
						lIn.getText(),
						startDate, endDate);
				theManager.addJob(newJob);
				System.out.println(newJob.toString());
			}

		});

	}
}
