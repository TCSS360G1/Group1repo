/*
 *TCSS 305
 *Winter a.6 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Rotation;
import model.TetrisPiece;

/**
 * The panel that creates the next piece.
 * @author deepjot kaur
 * @version 2.28.17
 */
public class TetrisNextPiece extends JPanel implements Observer {
    /**
     * generated serial id.
     */
    private static final long serialVersionUID = 8296335972620407608L;
    /**
     * The size of the panel.
     */
    private static final Dimension PANEL = new Dimension(100, 300);
    
    /**
     * move the piece over.
     */
    private static final int X_PIXELS = 75;
    
    /**
     * move the piece over.
     */
    private static final int Y_PIXELS = 100;
    /**
     * the pieces size.
     */
    private static final int SIZE = 25;
    /**
     * The next Tetris piece.
     */
    private TetrisPiece myTetrisPiece;
 
    
    /**
     * COnstructor to create the next piece panel.
     */
    public TetrisNextPiece() {
        super();
        this.setPreferredSize(PANEL);
        this.setBackground(Color.WHITE);
//        this.setBorder(BorderFactory.createTitledBorder("NEXT PIECE"));
    }
    @Override
    public void paintComponent(final Graphics theGraphic) {
        super.paintComponent(theGraphic);
        final Graphics2D g = (Graphics2D) theGraphic;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.translate(0, PANEL.getHeight());
        g.scale(1, -1);
        
        
        final int[][] rotationPoints = myTetrisPiece.getPointsByRotation(Rotation.NONE);

        for (int row = 0; row < rotationPoints.length; row++) {

            final int pX = rotationPoints[row][0];
            final int pY = rotationPoints[row][1];
            g.drawRect(pX * SIZE + X_PIXELS, pY * SIZE + Y_PIXELS, SIZE, SIZE);
        }
        
      //NO ROTATION
//      for (final Point p : myTetrisPiece.getPoints()) {
//          g.drawRect((p.x()) * SIZE, (p.y()) * SIZE,
//                     SIZE, SIZE);
//      }
        
        
        
    }
    @Override
    public void update(final Observable theObvserver, final Object theObject) {
        if (theObject instanceof TetrisPiece) {
            myTetrisPiece = (TetrisPiece) theObject;
//            System.out.println(myTetrisPiece);
           
        }  
        repaint();
        
    }

    
    
    
}
