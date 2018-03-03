package user_interface;

import javax.swing.JPanel;

import model.Volunteer;

public class VolunteerUnvolunteerPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private Volunteer myVolunteer;
    
    public VolunteerUnvolunteerPanel(Volunteer theVolunteer) {
        System.out.println("Unvolunteer");
        myVolunteer = theVolunteer;
        
        setupPanel();
    }

    private void setupPanel() {
        //TODO: needs a filtered list for jobs that can be unvolunteered. This and
        //VolunteersAvailable will be practically the same.
    }
}
