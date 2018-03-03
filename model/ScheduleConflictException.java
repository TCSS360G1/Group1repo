package model;

/**
 * This exception is thrown when a job is signed for that would conflict
 * with the schedule of a current job.
 * 
 * @author Kai Stansfield
 * @version February 11, 2018
 */
public class ScheduleConflictException extends Exception {
    private static final long serialVersionUID = -3063427133183512410L;

    public ScheduleConflictException() {
        super();
    }

}
