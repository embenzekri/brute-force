package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

	/*
	 * admin_password contains accounts authentications!
	 */
	private Map<String,String> admin_password = new HashMap();  

	/*
	 * this Map contains the number of attempts to login of a user!
	 */
	private Map<String,Integer> attemptsNumberOfUser = new HashMap();





	public String login(String admin, String password) {

		if(this.admin_password.containsKey(admin)) {

			int numberOfAttempts = this.attemptsNumberOfUser.get(admin) ;

			/*
			 * if the attempts'number >3 his account will be locked !
			 */
			if(numberOfAttempts >= 3) {

				return "Multiple erroneous credentials, your account is locked." ;
			}
			else {

				if( this.admin_password.get(admin) == password) {

					this.attemptsNumberOfUser.put(admin, 0);


					 return "Welcome " + admin +"!";

				}else {


					this.attemptsNumberOfUser.put(admin, numberOfAttempts + 1);

					return numberOfAttempts + 1 >= 3? "Multiple erroneous credentials, your account is locked." : "User or password are incorrect.";

				}

			}





		}

       //else
		return "User or password are incorrect.";
    }

    public void addUser(String admin, String s) {

    	this.admin_password.put(admin, s);

    	// there is a 0 attempts for this user to login when he is just added !
    	this.attemptsNumberOfUser.put(admin, 0);

    }
}