/*
 * tcss 305
 * winter assignment 6
 */
package view;

import java.awt.EventQueue;

/**
 * This class runs the gui.
 * @author deepjot
 * @version 2.26.19
 *
 */
public final class TetrisMain {
    /**
     * the constructor.
     */
    private TetrisMain() {
        throw new IllegalStateException();
    }
    /**
     * The main method, invokes the tetris GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TetrisFrame().start();
            }
        });
    }
}
