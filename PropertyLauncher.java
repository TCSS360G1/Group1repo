package examples;

import javax.swing.JPanel;
import java.beans.PropertyChangeEvent;
import java.time.LocalDate;

public class PropertyLauncher extends JPanel {
    private static final long serialVersionUID = 1L;

    public PropertyLauncher() {
        System.out.println("This work?");
    }
    public void fireChange() {
        firePropertyChange("Volunteer add job", new Volunteer("Kai", "Stansfield"),
                        new Job("Clean Sidewalks", "sweeping and picking up trash",
                                    "Park park", LocalDate.now(), LocalDate.now()));
    }
}
