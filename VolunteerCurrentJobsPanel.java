package user_interface;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Volunteer;

public class VolunteerCurrentJobsPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private Volunteer myVolunteer;
    
    public VolunteerCurrentJobsPanel(Volunteer theVolunteer) {
        System.out.println("Current");
        this.myVolunteer = theVolunteer;
        
        setupPanel();
    }
    
    private void setupPanel() {
        //TODO: Needs to have whatever method for getting information form model
        //look and feel will be decided after everything else works.
        //needs listeners for selection once the talking to model is established
        //the menubar will turn off and on the different panels.
    }
}
