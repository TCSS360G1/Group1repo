package user_interface;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Volunteer;

public class VolunteerPanel extends JPanel implements Observer {

    Volunteer myVolunteer;
    
    public VolunteerPanel(Volunteer theVolunteer) { 
        this.myVolunteer = theVolunteer;
        setBorder(BorderFactory.createTitledBorder("Main Menu:"));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize);
        JButton viewCurrentJobs = new JButton("View Current Jobs");
        JButton viewAvailableJobs = new JButton("View Available Jobs");
        JButton signOut = new JButton("Sign out");
        
        add(viewCurrentJobs);
        add(viewAvailableJobs);
        add(signOut);
        setVisible(true);
    }
    
    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        
    }

}
