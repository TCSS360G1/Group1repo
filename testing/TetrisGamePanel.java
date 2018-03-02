/*
 *TCSS 305
 * winter Assignment 6 
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Block;
import model.MovableTetrisPiece;
import model.Point;
import model.Rotation;

/**
 * This class is for the panel to play the game on.
 * @author deepjot
 * @version 2.24.19
 
 */
public class TetrisGamePanel extends JPanel implements Observer, PropertyChangeListener {
    
    /**
     * panel translation. 
     */
    private static final int TRANSL = 540;
    /**
     * Generated serial id.
     */
    private static final long serialVersionUID = 6793672164028037355L;
    
    /**
     * Size of block.
     */
    private static final int SIZE = 25;
    
    /**
     * size of the panel.
     */
    private static final Dimension PANEL_DIMENSION = new Dimension(250, 250);
    
    /**
     * INSTANCE of the current tetris piece.
     */
    private MovableTetrisPiece myTetrisPiece;
    
    /**
     * The rotation of the tetris piece.
     */
    private Rotation myRotation;
    /**
     * rotation point x.
     */
    private int myPX;
    /**
     * rotation point y.
     */
    private int myPY;
    /**
     * list of points of the frozen block at the bottom.
     */
    private final List<Point> myPoints;
    /**
     * is the grid check box selected?
     */
    private boolean myGrid;
    
    /**
     * Array of colors.
     */
    private final List<Color> myColorArray;
    /**
     * did the user check the grid?
     */
    private boolean myChange;
    /**
     * Tetris game panel constructor.
     */
    public TetrisGamePanel() {
        super();
        this.setPreferredSize(PANEL_DIMENSION);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        myPoints = new ArrayList<>();
        myColorArray = new ArrayList<>();
        addColors();
        myChange = false;
    }
    /**
     * color array for party mode.
     */
    private void addColors() {
        myColorArray.add(Color.BLUE);
        myColorArray.add(Color.PINK);
        myColorArray.add(Color.MAGENTA);
        myColorArray.add(Color.YELLOW);
        myColorArray.add(Color.GREEN);
        myColorArray.add(Color.ORANGE);
        myColorArray.add(Color.RED);
        myColorArray.add(Color.CYAN);
    }
    /**
     * Is the check box checked? setter
     * @param theGrid ; boolean.
     */
    public void isGridChecked(final boolean theGrid) {
        myGrid = theGrid;
    }
    /**
     * Getter for the boolean.
     * @return boolean
     */
    public boolean grid() {
        return myGrid;
    }
    
    /**
     * @param theChange ; boolean.
     */
    public void isPartyModeChecked(final boolean theChange) {
        myChange = theChange;
        
    }
    
    /**
     * @return boolean.
     */
    public boolean party() {
        return myChange;
    }
    @Override
    public void paintComponent(final Graphics theGraphic) {
        super.paintComponent(theGraphic);
        final Graphics2D g = (Graphics2D) theGraphic;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.translate(0, TRANSL);
        g.scale(1, -1);
        
        if (myGrid) {
            g.setColor(Color.GRAY);
            g.setStroke(new BasicStroke(1));
            for (int x = 0; x < TRANSL; x += SIZE) {
                g.drawLine(0, x, (int) PANEL_DIMENSION.getWidth(), x);
            }
            for (int y = 0; y < TRANSL; y += SIZE) {
                g.drawLine(y, 0, y, TRANSL);
            }
        }
        if (myChange) {
            final int c = new Random().nextInt(myColorArray.size());
            final Color color = myColorArray.get(c);
            g.setColor(color);
        } 
        if (!myChange) {
            g.setColor(Color.magenta);
        }
        
        if (myTetrisPiece != null) {
            final Point point = myTetrisPiece.getPosition();
            myRotation  = myTetrisPiece.getRotation();
            

            final int[][] rotationPoints = myTetrisPiece.getTetrisPiece().
                            getPointsByRotation(myRotation);

            for (int row = 0; row < rotationPoints.length; row++) {
                
                myPX = rotationPoints[row][0];
                myPY = rotationPoints[row][1];
//                g.setColor(Color.BLACK);
                g.drawRect((myPX + point.x()) * SIZE, (myPY + point.y()) * SIZE, SIZE, SIZE);
//                g.setColor(Color.CYAN);
                g.fillRect((myPX + point.x()) * SIZE, (myPY + point.y()) * SIZE, SIZE, SIZE);
            }
            
            for (final Point p: myPoints) {
                g.drawRect(p.x() * SIZE, p.y() * SIZE, SIZE, SIZE);
                g.fillRect(p.x() * SIZE, p.y() * SIZE, SIZE, SIZE);
            }
        }
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theE) {
//        System.out.println("received");
        if (theE.getPropertyName().equals("NewGame")) {
            repaint();
            myPoints.clear();
//            System.out.println(myPoints);
            repaint();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void update(final Observable theObservable, final Object theObject) {
        
        if (theObject instanceof MovableTetrisPiece) {
            repaint();
            myTetrisPiece = (MovableTetrisPiece) theObject;
            repaint();
        } else if (theObject instanceof List<?>) {
            repaint();
            //list of frozen blocks.
            int y = 0;
            int x = 0;
            for (final Block[] row : (List<Block[]>) theObject) {
                for (final Block b: row) {
                    if (b != null) {
                        //store
                        myPoints.add(new Point(x, y));
                    } 
                    x++;
                }
                x = 0;
                y++;                
            }
            repaint();
        } else if (theObject instanceof Integer[]) {
            
            myPoints.clear();
            repaint();
        }
//        repaint();
        
    }
    
}
