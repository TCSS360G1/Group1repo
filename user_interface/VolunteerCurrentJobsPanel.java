package user_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    
    /**
     * precondition: myVolunteer != null.
     * 
     * postcondition: Sets up the VolunteerCurrentJobs panel.
     */
    private void setupPanel() {
    	setPreferredSize(new Dimension(900,900));
        setLayout(new GridLayout(myVolunteer.getJobs().size(),1));
        setBorder(BorderFactory.createTitledBorder("Your Jobs"));
        for(int i = 0; i<myVolunteer.getJobs().size(); i++) {
        	if(!myVolunteer.getJobs().get(i).isInPast()){
        		JLabel j = new JLabel(myVolunteer.getJobs().toString());
            	add(j);
        	}
        	
        }
    }
}