package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
class Login{
	  String login;
	  String passWord;
	  int tries = 0;
	  boolean islocked=false;
	  Login(String login,String password){
		  this.login = login;
		  this.passWord = password;
	  }
	}
public class BruteForceApp {
	//int tries = 0;
	List<Login> users = new ArrayList<Login>();
    public String login(String admin, String password) {
    	
    	for(int i = 0; i < users.size();i++) {
    		if(users.get(i).login == admin ) {
    			if(users.get(i).islocked) {
    				return "Multiple erroneous credentials, your account is locked.";
    			}
    			if(users.get(i).passWord == password) {
    				users.get(i).islocked = false;
    				users.get(i).tries = 0;
        			return "Welcome "+ admin +"!";
        		}
    			users.get(i).tries++;
    			if(users.get(i).tries >= 3) {
    				users.get(i).islocked = true;
    				return "Multiple erroneous credentials, your account is locked.";
    			}
    		}
    		
    	}
        return "User or password are incorrect.";
    }

    public void addUser(String admin, String s) {
    	users.add(new Login(admin,s));
    }
}
