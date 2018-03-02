package user_interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.Job;

public class ParkManagerCancelJobsPanel extends JPanel {
	JPanel myUpdatePanel;
	public ParkManagerCancelJobsPanel(ArrayList<Job> theList) {
		this.setBorder(BorderFactory.createTitledBorder("Cancel Job:"));
		setLayout(new BorderLayout());
		updatesPanel(theList);
	}
	
	private void updatesPanel(ArrayList<Job> listOfCancellationsJobs) {
		myUpdatePanel = new JPanel();
		JButton cancel = new JButton();
		ButtonGroup myJobsGroup = new ButtonGroup();
		for (int i = 0; i < listOfCancellationsJobs.size(); i++) {
			JRadioButton j = new JRadioButton();
			j.setText(listOfCancellationsJobs.get(i).toString());
			myJobsGroup.add(j);
		}
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				// find the button and then find the corresponding job and
				// remove.
				String item = myJobsGroup.getSelection().toString();
				 int index = cancelJob(item, listOfCancellationsJobs);
				 listOfCancellationsJobs.remove(listOfCancellationsJobs.get(index));
				// ///////////////////////////////////**********
				 JOptionPane.showMessageDialog(null, item + "was removed from "
				 		+ "jobs.");
				/////////////////////////////////// REMOVE FROM ALL JOBS

			}
		});
		myUpdatePanel.add(cancel, BorderLayout.SOUTH);
		add(myUpdatePanel, BorderLayout.CENTER);

	}

	private int cancelJob(String item, ArrayList<Job> listOfCancellationsJobs) {
		for (int i = 0; i < listOfCancellationsJobs.size(); i++) {
			if (item.equals(listOfCancellationsJobs.get(i))) {
				return i;
			}
		}
		return 0;

	}
	

}