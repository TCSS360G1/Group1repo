package user_interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
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
		JButton cancel = new JButton("Cancel");
		ButtonGroup myJobsGroup = new ButtonGroup();
		cancel.setEnabled(false);
		
		if(listOfCancellationsJobs.size()!=0){
			System.out.println("size is greater than 0");
			cancel.setEnabled(true);
			for (int i = 0; i < listOfCancellationsJobs.size(); i++) {
				JRadioButton j = new JRadioButton();
				j.setText(listOfCancellationsJobs.get(i).toString());
				myJobsGroup.add(j);
				myUpdatePanel.add(j);
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
					 myUpdatePanel.setVisible(false);
					/////////////////////////////////// REMOVE FROM ALL JOBS

				}
			});
		} else {
			JLabel noneAvail = new JLabel("There are no Jobs to Cancel");
			add(noneAvail);
		}
 
		
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
