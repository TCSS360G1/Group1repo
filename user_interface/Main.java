package user_interface;

import java.io.IOException;

/**
 * Main Class.
 * 
 * @author Jenzel Villanueva
 * @version February 9, 2018
 */

public class Main {
    public static void main(String[] args) throws IOException {
    	// TODO: Testing print of Driver's contents.
    	// TODO: Refactor any methods/names/etc. if needed
    	Driver.signIn();
    	Driver.showVolunteerMenu();
    	Driver.volunteerSignUpForJob();
    	Driver.showParkManagerMenu();
    	Driver.newParkJob();
    }
}
