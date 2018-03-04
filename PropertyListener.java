package examples;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PropertyListener implements PropertyChangeListener {

    public PropertyListener() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Event: " + evt.getPropertyName());
        if (evt.getPropertyName().equals("Volunteer add job")) {
            Volunteer myVolunteer = ((Volunteer) evt.getOldValue());
            myVolunteer.addJob(((Job) evt.getNewValue()));
            System.out.println("Success on finding name");
            System.out.println(myVolunteer.getJobs());
        }
        
    }

}
