/**
 * 
 */
package user_interface;

import java.awt.BorderLayout;
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
	public ParkManagerNewJobPanel(ParkManager theManager) {
		myManager = theManager;
		this.setBorder(BorderFactory.createTitledBorder("New Job:"));
		setLayout(new BorderLayout());
		newJobPanel(myManager);
	}

	// create a new panel that has fields for input.
	private void newJobPanel(ParkManager theManager) {
		myNewJob = new JPanel();
		myNewJob.setLayout(new GridLayout(5, 2));
		// add all inputs.
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
		while (tIn.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a valid title");
			lIn.setEnabled(false);
			sIn.setEnabled(false);
			eIn.setEnabled(false);
			dIn.setEnabled(false);
		}

		lIn.setEnabled(true);
		while (lIn.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Please enter a valid location");
			sIn.setEnabled(false);
			eIn.setEnabled(false);
			dIn.setEnabled(false);
		}

		sIn.setEnabled(true);
		while (sIn.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Please enter a valid start date");

			eIn.setEnabled(false);
			dIn.setEnabled(false);
		}

		String[] startDateArray = sIn.getText().split("/");
		startDate = LocalDate.of(Integer.parseInt(startDateArray[2]),
				Integer.parseInt(startDateArray[0]),
				Integer.parseInt(startDateArray[1]));
		///////// CHECK BUSINESS RULES
		while (!theManager.isJobNotTooFar(startDate)///////////////////////////////////////////////////////////////////// CHECK
													///////////////////////////////////////////////////////////////////// THIS.
				|| ChronoUnit.DAYS.between(LocalDate.now(), startDate) < 0
				|| Job.isJobTooFar(startDate)) {
			JOptionPane.showMessageDialog(null,
					"Please enter a valid start date, "
							+ "this date is too far or is in the past");
			sIn.setText("");// empty out the field.
			startDateArray = sIn.getText().split("/");
			startDate = LocalDate.of(Integer.parseInt(startDateArray[2]),
					Integer.parseInt(startDateArray[0]),
					Integer.parseInt(startDateArray[1]));

			eIn.setEnabled(false);
			dIn.setEnabled(false);
		}

		eIn.setEnabled(true);
		while (eIn.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Please enter a valid end date");

			eIn.setEnabled(false);
			dIn.setEnabled(false);
		}
		String[] endDateArray = eIn.getText().split("/");
		endDate = LocalDate.of(Integer.parseInt(endDateArray[2]),
				Integer.parseInt(endDateArray[0]),
				Integer.parseInt(endDateArray[1]));
		while (!theManager.isMaxDaysUnder(startDate, endDate)
				|| Job.isJobTooFar(endDate)) {
			System.out.println("Please limit your job to " + Job.MAX_LENGTH
					+ " days or under.");
			eIn.setText(""); // empty out the text field
			endDateArray = eIn.getText().split("/");
			endDate = LocalDate.of(Integer.parseInt(endDateArray[2]),
					Integer.parseInt(endDateArray[0]),
					Integer.parseInt(endDateArray[1]));

			dIn.setEnabled(false);
		}

		dIn.setEnabled(true);
		while (dIn.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Please enter a valid description");
		}

		// add job to list.
		JButton done = new JButton("Done");
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				Job newJob = new Job(tIn.getText(), dIn.getText(), lIn.getText(),
						startDate, endDate);
				theManager.addJob(newJob);
			}
				
		});
		
		add(myNewJob, BorderLayout.CENTER);
	}
}
