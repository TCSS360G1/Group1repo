package user_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import model.Job;
import model.JobCollection;
import model.Volunteer;

//This class basically acts as a second frame for the volunteer.
//Everything should be setup up here, it might need look added here
//to have other things work.
public class VolunteerPanel extends JPanel implements Observer {
    private static final long serialVersionUID = 1L;

    private static final Dimension DEFAULT_SIZE = new Dimension(500, 250);
	
	private Volunteer myVolunteer;
	private VolunteerMenuBar myMenuBar;
	private VolunteerCurrentJobsPanel myCurrentJobsPanel;
	private VolunteerAvailableJobsPanel myAvailableJobsPanel;
	private VolunteerUnvolunteerPanel myUnvolunteerPanel;
	
	
    public VolunteerPanel(Volunteer theVolunteer, JobCollection theJobs) {
        super();
        myVolunteer = theVolunteer;
        myCurrentJobsPanel = new VolunteerCurrentJobsPanel(myVolunteer);
        myAvailableJobsPanel = new VolunteerAvailableJobsPanel(myVolunteer, 
        		Job.filterForVolunteerAvailableJobs(myVolunteer,
        				theJobs.filterPast()));
        myUnvolunteerPanel = new VolunteerUnvolunteerPanel(myVolunteer);
        myMenuBar = new VolunteerMenuBar(getComponents());
        System.out.println(getComponents().toString());
        setUpPanel();
    }
    
    /**
     * precondition: myCurrentJobsPanel != null.
     * 
     * postcondition: Sets up the sign in panel.
     */
    private void setUpPanel() {
    	setLayout(new BorderLayout());
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.ORANGE);
        add(myMenuBar);
        
        add(myCurrentJobsPanel, BorderLayout.CENTER);
        //add(myAvailableJobsPanel);
        //add(myUnvolunteerPanel);
        myCurrentJobsPanel.setVisible(true);
        setVisible(true);
    }


	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	

	
}