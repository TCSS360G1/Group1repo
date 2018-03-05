package user_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Job;
import model.JobCollection;
import model.ParkManager;
import model.UrbanParksEmployee;
import model.Volunteer;

public class VolunteerCurrentJobsPanel extends JPanel {
    JPanel currentJobs;
    Volunteer myVolunteer;
    
    public VolunteerCurrentJobsPanel(Volunteer theVolunteer) {
        myVolunteer = theVolunteer;
        setPreferredSize(new Dimension(900,900));
        displayCurrentJobs(myVolunteer);
        
    }

    /*Display all of the managers current Jobs. */
    private void displayCurrentJobs(Volunteer theVolunteer) {
        currentJobs = new JPanel();
        currentJobs.setLayout(new GridLayout(theVolunteer.getJobs().size(), 1));
        this.setBorder(BorderFactory.createTitledBorder("Your Jobs:"));
        //create a new label for each job and add
        for (int i = 0; i < theVolunteer.getJobs().size(); i++){
            JLabel myJobLabels = new JLabel();
            myJobLabels.setText(theVolunteer.getJobs().get(i).toString());
            currentJobs.add(myJobLabels);
        }
        add(currentJobs, BorderLayout.CENTER);
    }
}