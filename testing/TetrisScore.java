/*
 * TCSS 305 Winter
 * Assignment 6 
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Block;
import model.Point;

/**
 * This panel has the score and the keys. 
 * @author deepjot
 * @version 2.26.17
 */
public class TetrisScore extends JPanel implements Observer, PropertyChangeListener {
    
    /**
     * level label text.
     */
    private static final String LEVEL = "LEVEL: ";
    /**
     * lines label.
     */
    private static final String LINES_CLEARED = "LINES CLEARED: ";
    /**
     * SCORE LABEL.
     */
    private static final String SCORE = "SCORE: ";
    /**
     * NEXT LEVEL IN LABEL.
     */
    private static final String NEXT = "NEXT LEVEL IN: ";
    /**
     * grid layout. 
     */
    private static final int GRID = 5;
    /**
     * grid layout for keys.
     */
    private static final int KEY = 7;
    
    /**
     * serial version id.
     */
    private static final long serialVersionUID = -6039551150501154646L;
    
    /**
     * score when one line is cleared.
     */
    private static final int ONE_LINE_SCORE = 40;
    
    /**
     * score when TWO line is cleared.
     */
    private static final int TWO_LINE_SCORE = 100;
    
    /**
     * score when THREE line is cleared.
     */
    private static final int THREE_LINE_SCORE = 300;
    
    /**
     * score when FOUR line is cleared.
     */
    private static final int FOUR_LINE_SCORE = 1200;
    
    /**
     * LEVEL 3.
     */
    private static final int LEVEL_THREE = 3;
    /**
     * level 4.
     */
    private static final int LEVEL_FOUR = 4;
    
    /**
     * LINES UNTIL NEXT LEVEL.
     */
    private static final int LINES_UNTIL_NEXT_LEVEL = 5;
    /**
     * score per block.
     */
    private static final int SCORE_BLOCK = 4;
    /**
     * The score panel.
     */
    private JPanel myScores;
    
    /**
     * the key display.
     */
    private JPanel myKeys;
    /**
     * the lines that have been cleared.
     */
    private int myLines;
    /**
     * score. 
     */
    private int myScore;
    /**
     * the level. 
     */
    private int myLevel;
    /**
     * the lines left until the next level.
     */
    private int myLinesTillLevel;
    /**
     * The score label.
     */
    private JLabel myScoreL;
    /**
     * the lines label.
     */
    private JLabel myLinesL;
    /**
     * the next level label.
     */
    private JLabel myNextLevelL;
    /**
     * the current level label.
     */
    private JLabel myLevelL;
    /**
     * points array for the frozen blocks.
     */
    private final List<Point> myPoints;
    
    /**
     * constructor to create the serial version id.
     * 
     */
    public TetrisScore() {
        super();
        this.setBorder(BorderFactory.createTitledBorder("SCORE AND KEYS"));
        setLayout(new BorderLayout());
        myPoints = new ArrayList<>();        
        scoreDisplay();
        keyDisplay();
        add(myKeys, BorderLayout.SOUTH);
        add(myScores, BorderLayout.NORTH);
    }
    /**
     * original scores.
     */
    private void newScore() {
        myScore = 0;
        myLines = 0;
        myLevel = 1;
        myLinesTillLevel = LINES_UNTIL_NEXT_LEVEL;
        myScoreL.setText(SCORE + myScore);
        myLinesL.setText(LINES_CLEARED + myLines);
        myLevelL.setText(LEVEL + myLevel);
        myNextLevelL.setText(NEXT + myLinesTillLevel);
        
        
    }
   
    
    
    
    /**
     * Create the score Panel.
     */
    private void scoreDisplay() {
        myScores = new JPanel();
        myScores.setLayout(new GridLayout(GRID, 1));
//        final List<String> labels = new ArrayList<String>();
//        labels.add("SCORE: " + getScore());
//        labels.add("LINES CLEARED: " + myLines);
//        labels.add("LEVEL: " + myLevel);
//        labels.add("NEXT LEVEL IN: " + myLinesTillLevel);
//        labels.add("                     ");
//        
//        for (final String l : labels) {
//            final JLabel scores = new JLabel(l);
//            myScores.add(scores);
//            
//        }
        
        
//        final JLabel score = new JLabel();
//        score.setText("SCORE: " + getScore());
//        myScores.add(score);
        myScoreL = new JLabel();
        myScores.add(myScoreL);
        
        myLinesL = new JLabel();
        myScores.add(myLinesL);
        
        myLevelL = new JLabel();
        myScores.add(myLevelL);
        
        myNextLevelL = new JLabel();
        myScores.add(myNextLevelL);
        
        newScore();
        
        myLinesL.setText(LINES_CLEARED + myLines);
        myLevelL.setText(LEVEL + myLevel);
        myNextLevelL.setText(NEXT + myLinesTillLevel);
        myScoreL.setText(SCORE + myScore);
    }
    
    /**
     * Create the Keys Panel.
     */
    private void keyDisplay() {
        myKeys = new JPanel();
        myKeys.setLayout(new GridLayout(KEY, 1));
        final List<String> keys = new ArrayList<String>();
        keys.add("DROP: ENTER  \n");
        keys.add("DOWN: ARROW KEY DOWN  \n");
        keys.add("LEFT: ARROW KEY LEFT  \n");
        keys.add("RIGHT: ARROW KEY RIGHT  \n");
        keys.add("ROTATE CLOCKWISE: ARROW KEY UP  \n");
        keys.add("ROTATE COUNTERCLOCKWISE: SHIFT  \n");
        keys.add("PAUSE: SPACE  \n");
        
        for (final String s : keys) {
            final JLabel k = new JLabel(s);
            myKeys.add(k);
        }
        add(myKeys);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void update(final Observable theObservable, final Object theObject) {
        //integers. 
        

        
        if (theObject instanceof List<?>) {
            //add 4 point per block.
            
            int y = 0;
            int x = 0;
            for (final Block[] row : (List<Block[]>) theObject) {
                for (final Block b: row) {
                    if (b != null) {
                        //store
                        myPoints.add(new Point(x, y));
//                        System.out.println(myPoints);
                    } 
                    x++;
                }
                x = 0;
                y++;                
            } 
//            myScore = myPoints.size();
            myScore += SCORE_BLOCK;
            
//            System.out.println(myScore - 4); //addS 4 initially so i need to subtract 4.
            myScoreL.setText(SCORE + (myScore - SCORE_BLOCK));
        }
        if (theObject instanceof Integer[]) {
            myLines += ((Integer[]) theObject).length;
            myLinesL.setText(LINES_CLEARED + myLines);
            
            calculateScore(((Integer[]) theObject).length);
//            System.out.println(myScore);
            
//            System.out.println(myLines);
            if (myLines % LINES_UNTIL_NEXT_LEVEL == 0) {
                myLevel++;
                //FIRE A PROPERTY CHANGE LISTENER: RECEIVE IT IN GAME PANEL
                //DECREASE THE TIME.
                firePropertyChange("new delay", false, true);
                myLevelL.setText(LEVEL + myLevel);
                //then increase the level count by one.
                //set the lines cleared back to 5.
                myLinesTillLevel = LINES_UNTIL_NEXT_LEVEL;
                //decrease time delay.
//                myFrame.setDelay(theDelay);
                myNextLevelL.setText(NEXT + myLinesTillLevel);
//                myLinesTillLevel--;
                myLinesTillLevel = Math.abs(myLines - (LINES_UNTIL_NEXT_LEVEL * myLevel));

                
            } else {
                //subtract lines left by lines cleared.
//                myLinesTillLevel--;
                myLinesTillLevel = Math.abs(myLines - (LINES_UNTIL_NEXT_LEVEL * myLevel));
                myNextLevelL.setText(NEXT + myLinesTillLevel);
            }
            
            
            
            
            //if the lines are equal to 5 or are divisible by 5 with 0 remainder then
            // decrease delay
            
            //if the lines left is equal to 0 then increase the 
            //level and set the lines left back to 5.
        }
        
//        scoringPanel(myLines, myLinesTillLevel, myLevel, myScore);
        
        
    }
//    private void scoringPanel(int myLines2, int myLinesTillLevel2, int myLevel2,
//                              int myScore2) {
//        final score = new JLabel();
//        
//        
//        
//    }
    /**
     * method to calculate score when a line clears.
     * @param theLength ; the length of the array which is how many lines were
     *  cleared.
     */
    private void calculateScore(final int theLength) {
        if (theLength == 1) {
            myScore += myLevel * ONE_LINE_SCORE;
        } else if (theLength == 2) {
            myScore += myLevel *  TWO_LINE_SCORE;
        } else if (theLength == LEVEL_THREE) {
            myScore += myLevel * THREE_LINE_SCORE;
        } else if (theLength == LEVEL_FOUR) {
            myScore += myLevel * FOUR_LINE_SCORE;
        }
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theE) {
//        System.out.println("new");
        if (theE.getPropertyName().equals("new scores")) {
            newScore();
        }

    }






    
    
    //SCORING.
    /**
     * LINES:
     * 5 lines until the next level
//     * use Integer array for the frozen lines.
     * LINES LEFT: 
     * 5 - levels.
//     * SCORE:
//     * add 4 points for every piece that freezes.
//     * if one line is cleared then score is 40*level
//     * if 2 lines are cleared then score is 100*level
//     * if 3 lines are cleared then score is 300*level
//     * if 4 lines are cleared then score is 1200*level
     * DIFFICULTY: 
     * decrease time delay in every level.
     */
    
}
