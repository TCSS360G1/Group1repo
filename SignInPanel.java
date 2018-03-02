package user_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A JPanel used for drawing in PowerPaint.
 * 
 * @author Jenzel Villanueva
 * @version February 28, 2018
 */

public class SignInPanel extends JPanel implements Observer {
	/**
	 * The default size for this JPanel.
	 */
	private static final Dimension DEFAULT_SIZE = new Dimension(300, 150);

	/**
     * The width of the text field in the GUI.
     */
    private static final int TEXT_FIELD_WIDTH = 30;
	
    /**
     * 
     */
    private final JLabel myUsernameLabel;
    
	/**
     * The text field used to display the total amount owed by the customer.
     */
    private final JTextField myUsernameText;
    
    /**
    * The Sign In button used to log the user into the system.
    */
    private final JButton mySignInButton;
	
	/**
	 * 
	 */
	public SignInPanel() {
        super();
        
        // set up text field for username
        myUsernameLabel = new JLabel("Username:");
        myUsernameText = new JTextField("", TEXT_FIELD_WIDTH);
        mySignInButton = new JButton("Sign In");
        
        setUpPanel();
	}
	
	/**
     * Sets up the sign in panel.
     */
    private void setUpPanel() {
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.ORANGE);
        
        this.add(myUsernameLabel, BorderLayout.CENTER);
        
        myUsernameText.setEditable(true);
        myUsernameText.setEnabled(true);
        
        this.add(myUsernameText, BorderLayout.CENTER);
        
        mySignInButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        mySignInButton.setHorizontalTextPosition(AbstractButton.CENTER);
        
        this.add(mySignInButton);
        
        
    }
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
