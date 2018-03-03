package user_interface;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;

//This class should theoreticlaly be good to go, but hard to know until we have
//a concrete way to talk to the model, and a uniform look for the UI.
public class VolunteerMenuBar extends JMenuBar {
    private static final long serialVersionUID = 1L;
    
    private JButton myCurrentJobsButton;
    private JButton myAvailableJobsButton;
    private JButton myUnvolunteerButton;
    private JButton mySignOutButton;
    private Component[] myVolunteerPanels;
    
    public VolunteerMenuBar(Component[] theComponents) {
        
        super();
        myVolunteerPanels = theComponents;
        currentJobsButton();
        availableJobsButton();
        unVolunteerButton();
        signOutButton();
        
    }
    

    private void currentJobsButton() {
        myCurrentJobsButton = new JButton("Current Jobs");
        myCurrentJobsButton.setEnabled(false);
        add(myCurrentJobsButton);
        myCurrentJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentJobsButton.setEnabled(false);
                myAvailableJobsButton.setEnabled(true);
                myUnvolunteerButton.setEnabled(true);
                myVolunteerPanels[0].setVisible(true);
                myVolunteerPanels[1].setVisible(false);
                myVolunteerPanels[2].setVisible(false);
            }
        });
    }

    private void availableJobsButton() {
        myAvailableJobsButton = new JButton("Volunteer!");
        myAvailableJobsButton.setEnabled(false);
        add(myAvailableJobsButton);
        myAvailableJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentJobsButton.setEnabled(true);
                myAvailableJobsButton.setEnabled(false);
                myUnvolunteerButton.setEnabled(true);
                myVolunteerPanels[0].setVisible(false);
                myVolunteerPanels[1].setVisible(true);
                myVolunteerPanels[2].setVisible(false);
            }
        });
    }

    private void unVolunteerButton() {
        myUnvolunteerButton = new JButton("Unvolunteer");
        add(myUnvolunteerButton);
        myUnvolunteerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentJobsButton.setEnabled(true);
                myAvailableJobsButton.setEnabled(true);
                myUnvolunteerButton.setEnabled(false);
                myVolunteerPanels[0].setVisible(false);
                myVolunteerPanels[1].setVisible(false);
                myVolunteerPanels[2].setVisible(true);
            }
        });
    }   
    
    private void signOutButton() {
        mySignOutButton = new JButton("Sign Out");
        add(mySignOutButton);
        mySignOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myVolunteerPanels[0].setVisible(false);
                myVolunteerPanels[1].setVisible(false);
                myVolunteerPanels[2].setVisible(false);
            }
        });
    }
}
