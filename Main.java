import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main Class for Signing In and checking if Username input
 * corresponds with an existing User Object in the System.
 * 
 * @author Jenzel Villanueva
 * @version February 4, 2018
 */

public class Main {
    public static void main(String[] args) throws IOException {
    	SignIn users = new SignIn();
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("-Sign in-\nUsername: ");
        String s = br.readLine();
        
        User you = users.checkUserExists(s);
        if (you != null) {
        	System.out.println(users.checkType(you));
        } else {
        	System.out.println("-You are not registered-");
        }
    }
}
