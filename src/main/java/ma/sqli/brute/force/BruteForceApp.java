package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    ArrayList<String> blackList = new ArrayList<String>();
    Map<String, String> users = new HashMap<String, String>();
    Map<String, Integer> attempt = new HashMap<String, Integer>();
/*
    public String safeLogin(String username,String password){
        if(users.containsKey(username)){
            if(password==users.get(username)){
                    return "Welcome "+username+"!";
            }
        }
        return "";


    }

 */
    public String login(String username, String password) {
        attemptCalculator(username);

        if(attempt.get(username)>=2)
            return "Multiple erroneous credentials, your account is locked.";

        if (blackList.contains(username))
           return "Your account is blacklisted, contact the CRC to resolve the problem.";

        if(users.containsKey(username) && password==users.get(username)) {
            if (password=="1")

                return "Your password is too weak, please update it by going to your my account.";
            else {
                resetAttempt();
                return "Welcome " + username + "!";
            }
        }

        else return "User or password are incorrect.";
    }
    public void resetAttempt(){
        attempt.clear();
    }
    public int attemptCalculator(String username){
        if(attempt.containsKey(username)) {
            int i=attempt.get(username)+1;
            attempt.put(username,i);
        }
        else attempt.put(username,0);

        return attempt.get(username);
    }
    public void addUser(String username, String password) {
            users.put(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        if(users.containsKey(username) && password==users.get(username)) {

                resetAttempt();
                return "Welcome " + username + "!";
            }
        else return "User or password are incorrect.";
    }

    public void blacklist(String sqli) {
        blackList.add(sqli);
    }
}
