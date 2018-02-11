package model;

/**
 * This exception is thrown when a job is signed for that has already been
 * signed up for.
 * @author Kai Stansfield
 * @version February 10, 2018
 */
public class AlreadySignedUpException extends Exception{
    private static final long serialVersionUID = -4455098834454409224L;

    public AlreadySignedUpException() {
        super();
    }

}
