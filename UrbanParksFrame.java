package user_interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

/**
 * The Graphical User Interface for this program.
 * 
 * @author Jenzel Villanueva
 * @version February 27, 2018
 */
public class UrbanParksFrame extends JFrame implements Observer, PropertyChangeListener, ActionListener {

	/**
     * The default space between components.
     */
    private static final int PADDING = 30;
    
    /**
     * The top level Window for this GUI;
     * the main JFrame window for the program.
     */
    private final JFrame myFrame;
    
    /**
     * The SignIn Panel.
     */
    private final SignInPanel mySignInPanel;
    
    /**
     * Construct the GUI.
     */
    public UrbanParksFrame() {
        myFrame = new JFrame("TCSS 360 - Urban Parks");
        
        mySignInPanel = new SignInPanel();
        
        /* TODO: Panels
        ParkManagerPanel = new ParkManagerPanel();
        UrbanParksPanel = new UrbanParksPanel();
        
        */
        
        setupFrame();
    }
    
    /**
     * Sets up the elements of the GUI.
     */
    private void setupFrame() {
    	myFrame.setLayout(new BorderLayout());
    	// myFrame.setIconImage(new ImageIcon("./images/parks-icon.png").getImage());
    	
    	setupSignInPanel();
    	/* TODO: setUp Panels
    	 * setupUrbanParksPanel();
         * setupParkManagerPanel();
         */
        
    	myFrame.add(mySignInPanel, BorderLayout.CENTER);
    	
        /*
        final UrbanParksMenuBar menuBar =
                        new UrbanParksMenuBar(myFrame);
                                          
        myFrame.setJMenuBar(menuBar);
        */
        
        /**
         * A ToolKit used for the purpose of attempting to center the frame on a screen.
         */
        final Toolkit kit = Toolkit.getDefaultToolkit();
        
        myFrame.setLocation(
            (int) (kit.getScreenSize().getWidth() / 2 - myFrame.getWidth() / 2),
            (int) (kit.getScreenSize().getHeight() / 2 - myFrame.getHeight() / 2));
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }
	/**
	 * 
	 */
	private void setupSignInPanel() {
		mySignInPanel.setLayout(new GridLayout(5, 1));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
