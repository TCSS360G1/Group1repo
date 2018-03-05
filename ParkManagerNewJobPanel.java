package user_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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

	ArrayList<JTextField> l;
	JLabel title;
	JButton done;
	JTextField tIn;
	JButton tDone;
	JLabel location;
	JTextField lIn;
	JButton lDone;
	JLabel startm;
	JFormattedTextField smIn;
	JLabel startd;
	JTextField sdIn;
	JLabel starty;
	JTextField syIn;
	JLabel endm;
	JTextField emIn;
	JLabel endd;
	JTextField edIn;
	JButton syDone;
	JLabel endy;
	JTextField eyIn;
	JButton eyDone;
	JLabel discription;
	JTextField dIn;
	JButton dDone;

	public ParkManagerNewJobPanel(ParkManager theManager) {
		myManager = theManager;
		// System.out.println("xxx");
		this.setBorder(BorderFactory.createTitledBorder("New Job:"));
		setLayout(new BorderLayout());
		newJobPanel(myManager);

		setVisible(true);

	}

	/**
	 * precondition: theManager != null.
	 * 
	 * postcondition: Create a new panel that has fields for input.
	 */
	private void newJobPanel(ParkManager theManager) {
		l = new ArrayList<>();
		myNewJob = new JPanel();
		myNewJob.setLayout(new GridLayout(24, 1));
		// add all inputs.
		done = new JButton("Submit");
		done.setEnabled(false);
		title = new JLabel("Job Title: ");
		tIn = new JTextField();
		tDone = new JButton("Done");
		l.add(tIn);
		myNewJob.add(title);
		myNewJob.add(tIn);
		myNewJob.add(tDone);

		location = new JLabel("Job Location: ");
		lIn = new JTextField();
		lDone = new JButton("Done");
		myNewJob.add(location);
		myNewJob.add(lIn);
		myNewJob.add(lDone);
		l.add(lIn);
		startm = new JLabel("Start date MONTH: ");
		smIn = new JFormattedTextField();
		// JButton smDone = new JButton("Done");
		myNewJob.add(startm);
		myNewJob.add(smIn);
		// myNewJob.add(smDone);
		l.add(smIn);
		startd = new JLabel("Start date DAY: ");
		sdIn = new JTextField();
		// JButton sdDone = new JButton("Done");
		myNewJob.add(startd);
		myNewJob.add(sdIn);
		// myNewJob.add(sdDone);
		l.add(sdIn);

		starty = new JLabel("Start date YEAR: ");
		syIn = new JTextField();
		syDone = new JButton("Done");
		myNewJob.add(starty);
		myNewJob.add(syIn);
		myNewJob.add(syDone);

		l.add(syIn);
		endm = new JLabel("End date MONTH: ");
		emIn = new JTextField();
		// JButton emDone = new JButton("Done");
		myNewJob.add(endm);
		myNewJob.add(emIn);
		// myNewJob.add(emDone);
		l.add(emIn);
		endd = new JLabel("End date DAY: ");
		edIn = new JTextField();
		// JButton edDone = new JButton("Done");
		myNewJob.add(endd);
		myNewJob.add(edIn);
		// myNewJob.add(edDone);

		l.add(edIn);
		endy = new JLabel("End date YEAR: ");
		eyIn = new JTextField();
		eyDone = new JButton("Done");
		myNewJob.add(endy);
		myNewJob.add(eyIn);
		myNewJob.add(eyDone);
		l.add(eyIn);
		discription = new JLabel("Description: ");
		dIn = new JTextField();
		dIn.setPreferredSize(new Dimension(60, 10));
		dDone = new JButton("Done");
		myNewJob.add(discription);
		myNewJob.add(dIn);
		myNewJob.add(dDone);
		myNewJob.add(done);
		add(myNewJob, BorderLayout.CENTER);
		l.add(dIn);
		clearSlate(theManager);

	}

	/**
	 * precondition: theManager != null.
	 * 
	 * postcondition: Clears the current view slate. And adds new listeners.
	 */
	private void clearSlate(ParkManager theManager) {
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
						syIn.getText().isEmpty() || smIn.getText().equals("0")
						|| sdIn.getText().equals("0") ||
						syIn.getText().equals("0")) {

					JOptionPane.showMessageDialog(null,
							"Please input a valid date");

				} else {
					try {
						Integer.parseInt(sdIn.getText());
						Integer.parseInt(syIn.getText());
						Integer.parseInt(smIn.getText());
						startDate = LocalDate.of(
								Integer.parseInt(syIn.getText()),
								Integer.parseInt(smIn.getText()),
								Integer.parseInt(sdIn.getText()));
						if (Job.isDateTooFar(startDate)
								|| startDate.isBefore(LocalDate.now())) {

							JOptionPane.showMessageDialog(null,
									"Please Enter a start date, "
											+ "that is either under"
											+ Job.MAX_DISTANCE
											+ "days, or is not in the past.");
							// clear the fields
						} else {
							startDate = LocalDate.of(
									Integer.parseInt(syIn.getText()),
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
					} catch (NumberFormatException e) {

					}

				}
			}
		});

		eyDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (emIn.getText().isEmpty() || eyIn.getText().isEmpty()
						|| edIn.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Please enter a valid date");
				} else {
					try {
						Integer.parseInt(edIn.getText());
						Integer.parseInt(eyIn.getText());
						Integer.parseInt(emIn.getText());
						endDate = LocalDate.of(Integer.parseInt(eyIn.getText()),
								Integer.parseInt(emIn.getText()),
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
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
								"Please input a number");
					}
				}
			}

		});

		dDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				if (dIn.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Please Enter a description");
				} else {
					done.setEnabled(true);
					// theManager.addJob(new Job(tIn.getText(), lIn.getText(),
					// dIn.getText(), endDate, startDate));
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
				// theManager.addJob(newJob);
				//System.out.println(newJob.toString());

				firePropertyChange("Manager add", myManager, newJob);

				done.setEnabled(false);
				// myNewJob.setVisible(false);
				// add(myCurrentJobsPanel, BorderLayout.CENTER);
				// myCurrentJobsPanel.setVisible(true);
				for (int i = 0; i < l.size(); i++) {
					l.get(i).setText("");
				}
				
				firePropertyChange("Change made", "new job", true);
			}

		});
	}

}
