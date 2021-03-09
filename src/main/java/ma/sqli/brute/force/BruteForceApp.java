package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/

public class BruteForceApp {
	ErrorsPresenter errorsPresenter = new ErrorsPresenter();
	List<BruteForce> listBruteChecks = new ArrayList<BruteForce>();
	
    public String login(String admin, String password) {
    	
    	for(int i = 0; i < listBruteChecks.size();i++) {
    		BruteForce bruteForce = listBruteChecks.get(i);
    		
    		if(bruteForce.getLogin() == admin ) {
    			if(bruteForce.isBlackListed()) return errorsPresenter.blackListedError();
    			
    			if(bruteForce.isIslocked()) return errorsPresenter.BruteForceError();
    			
    			if(bruteForce.getPassWord() == password) {
    				listBruteChecks.get(i).setIslocked(false);
    				listBruteChecks.get(i).setTries(0);
    				if(isWeak(password)) {
    					if(bruteForce.isLoggedIn()) return errorsPresenter.passWordWeakError() + " - "+errorsPresenter.alreadyLoggedInError();
    					
    					listBruteChecks.get(i).setLoggedIn(true);
    					return errorsPresenter.passWordWeakError();
    				}
    				if(bruteForce.isLoggedIn()) return errorsPresenter.alreadyLoggedInError();
    				
    				listBruteChecks.get(i).setLoggedIn(true);
        			return "Welcome "+ admin +"!";
        		}
    			
    			listBruteChecks.get(i).setTries(listBruteChecks.get(i).getTries()+1);
    			if(listBruteChecks.get(i).getTries() >= 3) {
    				listBruteChecks.get(i).setIslocked(true);
    				return errorsPresenter.BruteForceError();
    			}
    		}
    		
    	}
    	logOut(admin);
        return errorsPresenter.loginFalseError();
    }

    public void addUser(String admin, String s) {
    	listBruteChecks.add(new BruteForce(admin,s));
    }

    public void blacklist(String admin) {
		for(int i = 0; i < listBruteChecks.size();i++) {
    		if(listBruteChecks.get(i).getLogin() == admin ) {
    			listBruteChecks.get(i).setBlackListed(true);
    			break;
    		}	
    	}	
	}
    public void logOut(String admin) {
		for(int i = 0; i < listBruteChecks.size();i++) {
			if(listBruteChecks.get(i).getLogin() == admin ) {
    			listBruteChecks.get(i).setLoggedIn(false);
    			break;
    		}	
    	}	
	}

	public String loginWithAndroid(String admin, String password) {
		for(int i = 0; i < listBruteChecks.size();i++) {
    		BruteForce bruteForce = listBruteChecks.get(i);
    		
    		if(bruteForce.getLogin() == admin ) {
    			if(bruteForce.isBlackListed()) return errorsPresenter.blackListedError();
    			
    			if(bruteForce.isLockedAndroid()) return errorsPresenter.BruteForceError();
    			
    			if(bruteForce.getPassWord() == password) {
    				listBruteChecks.get(i).setLockedAndroid(false);
    				listBruteChecks.get(i).setTries(0);
    				if(isWeak(password)) {
    					if(bruteForce.isLoggedIn()) return errorsPresenter.passWordWeakError() + " - "+errorsPresenter.alreadyLoggedInError();
    					
    					listBruteChecks.get(i).setLoggedIn(true);
    					return errorsPresenter.passWordWeakError();
    				}
    				if(bruteForce.isLoggedIn()) return errorsPresenter.alreadyLoggedInError();
    				
    				listBruteChecks.get(i).setLoggedIn(true);
        			return "Welcome "+ admin +"!";
        		}
    			
    			listBruteChecks.get(i).setTriesAndroid(listBruteChecks.get(i).getTriesAndroid()+1);
    			if(listBruteChecks.get(i).getTriesAndroid() >= 3) {
    				listBruteChecks.get(i).setLockedAndroid(true);
    				return errorsPresenter.BruteForceError();
    			}
    		}
    		
    	}
    	logOut(admin);
        return errorsPresenter.loginFalseError();
		
	}
	private boolean isWeak(String password) {
		if(password.length() < 3)
			return true;
		return false;
	}
}
