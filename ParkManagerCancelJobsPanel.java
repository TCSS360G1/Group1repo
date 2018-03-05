package user_interface;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.Job;
import model.JobCollection;
import model.ParkManager;

/**
 * Panel that displays the jobs that are available to be canceled, and allows
 * user to only select one.
 */
public class ParkManagerCancelJobsPanel extends JPanel {
	JPanel myUpdatePanel;

	public ParkManagerCancelJobsPanel(ParkManager theManager,
			ArrayList<Job> theList) {

		this.setBorder(BorderFactory.createTitledBorder("Cancel Job:"));
		setLayout(new BorderLayout());

		updatesPanel(theManager, theList);

	}
	/**
	 * Panel that */
	private void updatesPanel(ParkManager theManager,
			ArrayList<Job> listOfCancellationsJobs) {
		myUpdatePanel = new JPanel();
		JButton cancel = new JButton("Cancel");
		ButtonGroup myJobsGroup = new ButtonGroup();
		cancel.setEnabled(false);
 
		if (listOfCancellationsJobs.size() != 0) {
			System.out.println("size is greater than 0");
			cancel.setEnabled(true);
			for (int i = 0; i < listOfCancellationsJobs.size(); i++) {
				JRadioButton j = new JRadioButton();
				j.setText(listOfCancellationsJobs.get(i).toString());
				myJobsGroup.add(j);
				myUpdatePanel.add(j);
			}
		} else {
			JLabel noneAvail = new JLabel("There are no Jobs to Cancel");
			add(noneAvail);
		}
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				// find the button and then find the corresponding job text and
				// remove.
				String job = "";
				for (Enumeration<AbstractButton> item = myJobsGroup
						.getElements(); item.hasMoreElements();) {
					AbstractButton b = item.nextElement();
					if (b.isSelected()) {
						job = b.getText();
					}
				}

				// ///////////////////////////////////**********
				JOptionPane.showMessageDialog(null,
						job + "     was removed from "
								+ "jobs.");
				firePropertyChange("Manager remove", theManager, job);
				firePropertyChange("Change made", "cancelled", null);

			}
		});

		myUpdatePanel.add(cancel, BorderLayout.SOUTH);
		add(myUpdatePanel, BorderLayout.CENTER);

	}

}
