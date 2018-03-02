package user_interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.util.Observable;

import model.Job;
import model.ParkManager;

public class ParkManagerPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ParkManager myManager;

	private JMenuBar x;
	private JPanel currentJobs;

	public ParkManagerPanel(ParkManager theManager) {
		System.out.println(theManager.getFirstName());
		myManager = theManager;
		
		setLayout(new BorderLayout());
		x = new ParkManagerMenuBar(myManager);
		add(x, BorderLayout.NORTH);
		
		currentJobs = new ParkManagerDisplayCurrentJobs(theManager);
		add(currentJobs, BorderLayout.CENTER);
		//displayCurrentJobs(myManager);
		
		
		setVisible(true);
	}
	
	
	

	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
