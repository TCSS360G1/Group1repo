/*
 *TCSS 305 Winter
 *Assignment 6 
 */
package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * This class is to create the side panel.
 * This panel wil have the score and the keys on display.
 * @author deepjot
 * @version 2.26.17
 */
public class TetrisSidePanel extends JPanel {
    /**
     * generated serial version id.
     */
    private static final long serialVersionUID = -5389123914381638437L;
    
    
    

    /**
     * Constructor to create the side panel.
     * This panel will have 2 interior panels- one will have the next
     * piece and the other the scores and the key
     * @param theNext ; The side panel.
     * @param theScore ; the score panel.
     */
    public TetrisSidePanel(final JPanel theNext, final JPanel theScore) {
        super();
        setLayout(new BorderLayout());
        
        add(theScore, BorderLayout.SOUTH);
        add(theNext, BorderLayout.NORTH);
    }
    
    
}
