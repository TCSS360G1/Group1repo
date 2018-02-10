package model;

/**
 * This exception is thrown when a job is signed for that is too close to the
 * current day, according to Volunteer.MINIMUM_NUmBER_OF_DAYS_TO_SIGN_UP
 * @author Kai Stansfield
 * @version February 10, 2018
 */
public class MinimumDaysException extends Exception {
    private static final long serialVersionUID = 3785387344814998707L;

    public MinimumDaysException() {
        super();
    }

}
