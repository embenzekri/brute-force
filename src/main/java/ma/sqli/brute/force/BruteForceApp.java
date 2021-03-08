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
	ErrorsPresenter errorsPresenter = new ErrorsPresenter();
	List<BruteForce> listBruteChecks = new ArrayList<BruteForce>();
	
    public String login(String admin, String password) {
    	
    	for(int i = 0; i < listBruteChecks.size();i++) {
    		if(listBruteChecks.get(i).getLogin() == admin ) {
    			if(listBruteChecks.get(i).isIslocked()) {
    				return errorsPresenter.BruteForceError();
    			}
    			if(listBruteChecks.get(i).getPassWord() == password) {
    				listBruteChecks.get(i).setIslocked(false);
    				listBruteChecks.get(i).setTries(0);
        			return "Welcome "+ admin +"!";
        		}
    			listBruteChecks.get(i).setTries(listBruteChecks.get(i).getTries()+1);
    			if(listBruteChecks.get(i).getTries() >= 3) {
    				listBruteChecks.get(i).setIslocked(true);
    				return errorsPresenter.BruteForceError();
    			}
    		}
    		
    	}
        return errorsPresenter.loginFalseError();
    }

    public void addUser(String admin, String s) {
    	listBruteChecks.add(new BruteForce(admin,s));
    }
}
