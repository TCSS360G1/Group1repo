package user_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VolunteerPanel extends JPanel implements Observer {
	
	private static final Dimension DEFAULT_SIZE = new Dimension(500, 250);
	
    public VolunteerPanel() {
        super();
        
        setUpPanel();
    }
    
    /**
     * Sets up the sign in panel.
     */
    private void setUpPanel() {
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.ORANGE);
        
        JButton aButton = new JButton("Did it work?!!!");
        this.add(aButton);
        
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
