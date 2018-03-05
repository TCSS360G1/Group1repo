package user_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Job;
import model.JobCollection;
import model.Volunteer;

//This class basically acts as a second frame for the volunteer.
//Everything should be setup up here, it might need look added here to have other
//things work.
public class VolunteerPanel extends JPanel implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
	
    private JPanel myCurrentJobs;
    private JPanel myViewJobs;
    private JPanel myUnvolunteer;
    private JPanel mySignIn;
	private Volunteer myVolunteer;
	private JMenuBar myMenuBar;
	private ArrayList<Job> mySystemJobs;
	
    public VolunteerPanel(Volunteer theVolunteer, ArrayList<Job> theJobs) {
        super();
        System.out.println("--"+ theJobs.size());
        myVolunteer = theVolunteer;
        mySystemJobs = theJobs;
        System.out.println("size in VolPanel:" + mySystemJobs.size());
        System.out.println("Volunteer jobs: " + theVolunteer.getJobs());
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        myMenuBar = new MenuBar();
        add(myMenuBar, BorderLayout.NORTH);
        
        myCurrentJobs = new VolunteerCurrentJobsPanel(myVolunteer);
        myViewJobs = new VolunteerAvailableJobsPanel(myVolunteer,
                        Job.filterForVolunteerAvailableJobs(theVolunteer,
                        theJobs));
        System.out.println("size of filtered "+Job.filterForVolunteerAvailableJobs(theVolunteer,
                        theJobs).size());
        System.out.println(myVolunteer.getJobs());
        System.out.println("FILT" + Job.filterForCancellation(myVolunteer.getJobs()));
        myUnvolunteer = new VolunteerUnvolunteerPanel(myVolunteer,
                        Job.filterForCancellation(myVolunteer.getJobs()));
        
        myViewJobs.addPropertyChangeListener(this);
        myUnvolunteer.addPropertyChangeListener(this);
        add(myCurrentJobs, BorderLayout.CENTER);
        setVisible(true);
    }
    
    private void addPanels(JPanel theP) {

        add(theP, BorderLayout.CENTER);

    }

    private void addListener(JPanel theP) {
        theP.addPropertyChangeListener(this);
    }
    
    public class MenuBar extends JMenuBar {
        private static final long serialVersionUID = 1L;

        private JButton mySignOut;
        private JButton myUnvolunteerButton;
        private JButton myNewJob;
        private JButton myViewCurrent;

        public MenuBar() {
            super();
            System.out.println("MENU BAR CALLED");
            current();
            newJob();
            unvolunteer();
            signOut();
        }
        
        private void current() {
        	
            myViewCurrent = new JButton("View Current Jobs");
            myViewCurrent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    myViewJobs.setVisible(false);
                    myUnvolunteer.setVisible(false);
                    myCurrentJobs = new VolunteerCurrentJobsPanel(myVolunteer);
                    addListener(myCurrentJobs);
                    myCurrentJobs.setVisible(true);
                    addPanels(myCurrentJobs);
                }
            });
            add(myViewCurrent);
        }
        private void newJob() {         
            myNewJob = new JButton("Volunteer!");
            myNewJob.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                        myCurrentJobs.setVisible(false);
                        myUnvolunteer.setVisible(false);
                        myViewJobs = new VolunteerAvailableJobsPanel(myVolunteer,
                        		Job.filterForVolunteerAvailableJobs(myVolunteer,
                                        mySystemJobs));
                        addListener(myViewJobs);
                        myNewJob.setVisible(true);
                        addPanels(myViewJobs);
                }
            });
            add(myNewJob);
        }
        private void unvolunteer() {
            myUnvolunteerButton = new JButton("Unvolunteer");
            myUnvolunteerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    // System.out.println(Job.filterForCancellation(myManager.getJobs())).size());
                    if (Job.filterForCancellation(myVolunteer.getJobs()).size() == 0) {
                        myUnvolunteer.setVisible(false);
                        JOptionPane.showMessageDialog(null,
                                "Sorry, you currently do not have any jobs"
                                        + " That you can cancel.");
                    } else {
                        myNewJob.setVisible(false);
                        myCurrentJobs.setVisible(false);
                        myUnvolunteer = new VolunteerUnvolunteerPanel(
                                        myVolunteer,
                                        Job.filterForCancellation(
                                            myVolunteer.getJobs()));
                        addListener(myUnvolunteer);
                        myUnvolunteer.setVisible(true);
                        addPanels(myUnvolunteer);
                    }
                }
            }); 
            add(myUnvolunteerButton);
        }
        private void signOut() {
            mySignOut = new JButton("Sign Out");
            mySignOut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    mySignIn = new SignInPanel();
                    myNewJob.setVisible(false);
                    myCurrentJobs.setVisible(false);
                    myUnvolunteer.setVisible(false);
                    mySignIn.setVisible(true);
                    addPanels(mySignIn);
                }
            });
            add(mySignOut);
        }
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        // get the add event and then fire a listener to the sign in panel.
        if (evt.getPropertyName().equals("Volunteer add")) {
            Volunteer volunteer = (Volunteer) evt.getOldValue();
            System.out.println("change recieved in vol");
            firePropertyChange("Volunteer add", volunteer, evt.getNewValue());
        } else if (evt.getPropertyName().equals("Volunteer remove")) {
            Volunteer volunteer = (Volunteer) evt.getOldValue();
            firePropertyChange("Volunteer remove", volunteer, evt.getNewValue());
        }
    }
}