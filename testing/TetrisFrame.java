/*
 * TCSS 305 Winter
 * Assignment 6
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.Board;

/**
 * This class creates the frame of the game.
 * @author deepjot
 * @version 2.23.17
 */
public class TetrisFrame extends JFrame implements Observer, 
        PropertyChangeListener, ActionListener {
    /**
     * this is the string that will be displaying in a j option pane.
     */
    private static final String SCORING_DISPLAY = 
                    "This game uses the orgininal NES scoring algorithim.\n"
                    + "Each time a piece freezes at the bottom, "
                    + "4 points will be added to your score.\n"
                    + "Clear one line you score will be: your levels "
                    + "multiplied by 40 in addition to your original score.\n"
                    + "Clear two lines you score will be: your levels "
                    + "multiplied by 100 in addition to your original score.\n"
                    + "Clear three lines you score will be: your levels "
                    + "multiplied by 300 in addition to your original score.\n"
                    + "Clear four lines you score will be: your levels "
                    + "multiplied by 1200 in addition to your original score."
                    + "\n";
    
    /**
     * String for the information and tips.
     */
    private static final String INFO = 
                    "You must start a New Game once opening the Interface.\n"
                    + "To access different difficulty levels -  "
                    + "you need to start the game \n"
                    + "and then you will be able to view the "
                    + "different levels.\n"
                    + "Party mode will start once the "
                    + "game start. Feel free to \n"
                    + "change back and forth between the colors\n"
                    + "this will not affect your game play and your scores.\n"
                    + "Changing your grid preferences will also not "
                    + "change your \ngame play or scores."
                    + "\nStarting a new game, ending a game, "
                    + "and changing difficulties "
                    + "\nwill generate new scores."
                    + "\n HAVE FUN! -Deepjot.";
    /**
     * new game to fire property change listener.
     */
    private static final String NEW_GAME = "NewGame";
                    
    /**
     * generated Serial version id.
     */
    private static final long serialVersionUID = -8379154414050682418L;
    /**
     * string to create a new game.
     */
    private static final String NEW = "new scores";
    /**
     * Expert delay. 
     */
    private static final int NORMAL = 900;
    /**
     * Expert delay. 
     */
    private static final int BEGINNER = 1000;
    /**
     * Expert delay. 
     */
    private static final int EXPERT = 200;
    
    /**
     * Size of the frame.
     */
    private static final Dimension DIMENSION = new Dimension(500, 600);
    /**
     * The delay. 
     */
    private int myDelay;
   
    /**
     * instance of board.
     */
    private Board myBoard;
    /**
     * the timer to make the board step.
     */
    private Timer myTimer;
    
    
    /**
     * Tetris game panel. 
     */
    private TetrisGamePanel myGamePanel;
    /**
     * The Score panel.
     */
    private TetrisScore myScore;
   
    /**
     * creates the frame in the main method.
     */
    public void start() {
        setSize(DIMENSION);
        setTitle("Deepjots Tetris");
        myDelay = NORMAL;
        
        myGamePanel = new TetrisGamePanel();
        add(myGamePanel, BorderLayout.WEST);
        final TetrisNextPiece next = new TetrisNextPiece();
        myScore = new TetrisScore();
        final TetrisSidePanel sidePanel = new TetrisSidePanel(next, myScore);
        add(sidePanel, BorderLayout.EAST);
        setJMenuBar(new MenuBar());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        myBoard = new Board();
        myBoard.addObserver(next);
        myBoard.addObserver(myGamePanel);
        myBoard.addObserver(this);
        myBoard.addObserver(myScore);
        this.addPropertyChangeListener(myGamePanel);
        myScore.addPropertyChangeListener(this);
        
//        JOptionPane.showConfirmDialog(null, "Would you like to start a new game?");
        
        myBoard.newGame();
        myTimer = new Timer(getDelay(), this);
        
//        myTimer = new Timer(getDelay(), new ActionListener() {
//            public void actionPerformed(final ActionEvent theE) {
//                myBoard.step();
////                System.out.println(myBoard.toString());
//            }
//        });
        addKeyListener(new Keys());

        
        
        setVisible(true);
       
    }
    
    /**
     * get the delay. 
     * @return the delay. 
     */
    public int getDelay() {
        return myDelay;
    }
    /**
     * set the delay. 
     * @param theDelay = original delay is 1000, but can be set to different paces.
     */
    public void setDelay(final int theDelay) {
        myDelay = theDelay;
    }
    
    @Override
    public void update(final Observable theObserver, final Object theObject) {
        if (theObject instanceof Boolean) {
            myTimer.stop();
            JOptionPane.showMessageDialog(null, "GAME OVER");
        } 
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent theE) {
        if (theE.getPropertyName().equals("new delay")) {
            final int d = getDelay() - 100;
            myTimer.setDelay(d);
//            System.out.println(getDelay());
        } 
       
    }
    @Override
    public void actionPerformed(final ActionEvent theE) {
        myBoard.step();
        
    }
    
    /**
     * key listener class.
     * @author deepjot
     * @version 2.27.17
     */
    public class Keys extends KeyAdapter {
        @Override
        public void keyPressed(final KeyEvent theE) {
            if (myTimer.isRunning()) {
                if (theE.getKeyCode() == KeyEvent.VK_ENTER) { //all the way to bottom
                    myBoard.drop();
//                    System.out.println("Drop");
                    myGamePanel.repaint();
                } 
                if (theE.getKeyCode() == KeyEvent.VK_DOWN) { //one line
                    myBoard.down();
//                    System.out.println("DOWN");
                } 
                if (theE.getKeyCode() == KeyEvent.VK_LEFT) { //move left
                    myBoard.left();
//                    System.out.println("LEFT");
                }
                if (theE.getKeyCode() == KeyEvent.VK_RIGHT) { //move right
                    myBoard.right();
//                    System.out.println("RIGHT");
                }
                if (theE.getKeyCode() == KeyEvent.VK_UP) { //rotate clockwise
                    myBoard.rotateCW();
//                    System.out.println("C");
                }
                if (theE.getKeyCode() == KeyEvent.VK_SHIFT) { //counterclockwise
                    myBoard.rotateCCW();
//                    System.out.println("CC");
                }
                if (theE.getKeyCode() == KeyEvent.VK_SPACE) {
                    myTimer.stop();
                    myGamePanel.repaint();
                }
            } else {
                if (theE.getKeyCode() == KeyEvent.VK_SPACE) {
                    myTimer.restart();
                }
            }
        }
    }
    
    
    
    /**
     * This is the menu bar.
     * @author deepjot Kaur
     * @version 3.2
     */
    public class MenuBar extends JMenuBar {

        /**
         * generated serial version id.
         */
        private static final long serialVersionUID = 5156649817489788048L;
        
       /**
        * file JMenu.
        */
        private JMenu myFile;
        /**
         * myInformation menu.
         */
        private JMenu myInfo;
        
        /**
         * new game.
         */
        private JMenuItem myNewGame;
        /**
         * end game.
         */
        private JMenuItem myEndGame;
        /**
         * difficulty menu item.
         */
        private JMenuItem myDifficulty;
        /**
         * Constructor.
         */
        public MenuBar() {
            super();
            file();
            info();
            this.addPropertyChangeListener(myGamePanel);
            this.addPropertyChangeListener(myScore);
        }
        /**
         * creates the info tab.
         */
        private void info() {
            myInfo = new JMenu("Information + Tips");
            add(myInfo);
            final JMenuItem tips = new JMenuItem("Tips");            
            tips.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent theE) {
                    JOptionPane.showMessageDialog(null, INFO);
                    
                }
                
            });
            myInfo.add(tips);
        }
        /**
         * Makes the file menu.
         */
        private void file() {
            myFile = new JMenu("File");
            add(myFile);
            myNewGame = new JMenuItem("New Game");
            
            myNewGame.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    myBoard.newGame();
                    //clear all the stuff off the board.
                    myTimer.start();
//                    addKeyListener(new Keys());
                    myNewGame.setEnabled(false);
                    firePropertyChange(NEW_GAME, false, true);
                    firePropertyChange(NEW, false, true);
                    myEndGame.setEnabled(true);
                    myDifficulty.setEnabled(true);
//                    System.out.println("Fired");
                }
            });
            myFile.add(myNewGame);
            myEndGame = new JMenuItem("End Game");
            myEndGame.setEnabled(false);
            myEndGame.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    myTimer.stop();
                    myNewGame.setEnabled(true);
                    myEndGame.setEnabled(false);
//                    firePropertyChange(NEW, false, true);
                }
            });
            myFile.add(myEndGame);
            myFile.addSeparator();
            final JMenuItem scoring = new JMenuItem("Scoring?");
            scoring.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    JOptionPane.showMessageDialog(null, SCORING_DISPLAY);
                }
            });
            myFile.add(scoring);
            myFile.addSeparator();
            
            
        
            final JCheckBoxMenuItem gridLines = new JCheckBoxMenuItem("Grid");
            gridLines.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    if (myGamePanel.grid()) {
                        myGamePanel.isGridChecked(false);
                    } else {
                        myGamePanel.isGridChecked(true);
                    }
                }
            });
            myFile.add(gridLines);
            myFile.addSeparator();

            
            fileHelper();
            
        }
        /**
         * Helper method for the file.
         */
        private void fileHelper() {
            myDifficulty = new JMenu("Difficulty?");
            myDifficulty.setEnabled(false);
            myFile.add(myDifficulty);
            final JMenuItem faster = new JMenuItem("Expert?");
            faster.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    myTimer.setDelay(EXPERT);
                   
                    myBoard.newGame();
                    
                    firePropertyChange(NEW, false, true);
                    firePropertyChange(NEW_GAME, false, true);
                }
            });
            myDifficulty.add(faster);
            final JMenuItem normal = new JMenuItem("Normal?");
            normal.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    myTimer.setDelay(NORMAL);
//                    System.out.println(getDelay());
                    
//                    delay = 900;
                    myBoard.newGame();
//                    myTimer.start();
                    firePropertyChange(NEW, false, true);
                    firePropertyChange(NEW_GAME, false, true);
                }
            });
            myDifficulty.add(normal);
            final JMenuItem slow = new JMenuItem("Beginner?");
            slow.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    myTimer.setDelay(BEGINNER);
                    
                    myBoard.newGame();
//                    myTimer.start();
                    //clear all the stuff off the board.
                    
//                    myTimer.start();
                    
                    firePropertyChange(NEW, false, true);
                    firePropertyChange(NEW_GAME, false, true);                
                    }
                
            });
            myDifficulty.add(slow);
            myFile.addSeparator();
            final JCheckBoxMenuItem randomColors = new JCheckBoxMenuItem("Party Mode");
            randomColors.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    if (myGamePanel.party()) {
                        myGamePanel.isPartyModeChecked(false);
                    } else {
                        myGamePanel.isPartyModeChecked(true);
                    }

                }
            });
            myFile.add(randomColors);
        }
    }



    
    
    
    
}
