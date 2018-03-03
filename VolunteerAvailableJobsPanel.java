package user_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Volunteer;

public class VolunteerAvailableJobsPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private Volunteer myVolunteer;
    
    public VolunteerAvailableJobsPanel(Volunteer theVolunteer) {
        System.out.println("Available");
        setupPanel();
    }

    private void setupPanel() {
        //TODO: panel setup. use filters from JobCollection and display jobs
        //probably in a text field.
    }
}
