package user_interface;



import java.awt.BorderLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.util.Enumeration;



import javax.swing.AbstractButton;

import javax.swing.BorderFactory;

import javax.swing.ButtonGroup;

import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JRadioButton;



import model.Job;

import model.ParkManager;

import model.Volunteer;



public class VolunteerUnvolunteerPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    JPanel myUpdatePanel;

	public VolunteerUnvolunteerPanel(Volunteer theVolunteer, 
	                ArrayList<Job> theList) {
		this.setBorder(BorderFactory.createTitledBorder("Unvolunteer from Job:"));
		setLayout(new BorderLayout());
		updatesPanel(theVolunteer, theList);
	}
	
    private void updatesPanel(Volunteer theVolunteer, 
                    ArrayList<Job> listOfCancellationsJobs) {
		myUpdatePanel = new JPanel();
		JButton cancel = new JButton("Unvolunteer");
		ButtonGroup myJobsGroup = new ButtonGroup();
		cancel.setEnabled(false);

		if(listOfCancellationsJobs.size()!=0){
			cancel.setEnabled(true);
			for (int i = 0; i < listOfCancellationsJobs.size(); i++) {
				JRadioButton j = new JRadioButton();
				j.setText(listOfCancellationsJobs.get(i).toString());
				myJobsGroup.add(j);
				myUpdatePanel.add(j);
			} 

		} else {
			JLabel noneAvail = new JLabel("There are no Jobs to Select");
			add(noneAvail);
		}
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				// find the button and then find the corresponding job text and
				// remove.
				String job = "";
				for(Enumeration<AbstractButton> item = myJobsGroup.getElements(); item.hasMoreElements();) {
					AbstractButton b = item.nextElement();
					if(b.isSelected()) {
						job = b.getText();
					}
				}
				 JOptionPane.showMessageDialog(null, job + " was removed from volunteered jobs.");

				 firePropertyChange("Volunteer remove", theVolunteer, job);
			}
		});
		myUpdatePanel.add(cancel, BorderLayout.SOUTH);
		add(myUpdatePanel, BorderLayout.CENTER);
	}
}