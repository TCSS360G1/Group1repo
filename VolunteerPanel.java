package user_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Volunteer;

//This class basically acts as a second frame for the volunteer.
//Everything should be setup up here, it might need look added here to have other
//things work.
public class VolunteerPanel extends JPanel implements Observer {
    private static final long serialVersionUID = 1L;

    private static final Dimension DEFAULT_SIZE = new Dimension(500, 250);
	
	private Volunteer myVolunteer;
	private VolunteerMenuBar myMenuBar;
	private VolunteerCurrentJobsPanel myCurrentJobsPanel;
	private VolunteerAvailableJobsPanel myAvailableJobsPanel;
	private VolunteerUnvolunteerPanel myUnvolunteerPanel;
	
	
    public VolunteerPanel(Volunteer theVolunteer) {
        super();
        myVolunteer = theVolunteer;
        myCurrentJobsPanel = new VolunteerCurrentJobsPanel(myVolunteer);
        myAvailableJobsPanel = new VolunteerAvailableJobsPanel(myVolunteer);
        myUnvolunteerPanel = new VolunteerUnvolunteerPanel(myVolunteer);
        myMenuBar = new VolunteerMenuBar(getComponents());
        setUpPanel();
    }
    
    /**
     * Sets up the sign in panel.
     */
    private void setUpPanel() {
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.ORANGE);
        add(myMenuBar, BorderLayout.NORTH);
        add(myCurrentJobsPanel);
        add(myAvailableJobsPanel);
        add(myUnvolunteerPanel);
        myCurrentJobsPanel.setVisible(true);
        setVisible(true);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
