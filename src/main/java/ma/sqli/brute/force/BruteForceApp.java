package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private List<String> blacklist = new ArrayList<>();
    private Map<String,String> usersList = new HashMap<>();
    private List<String> login = new ArrayList<>();
    private String message;
    private Map<String,Integer> numberOfAttempt = new HashMap<>();
    private Map<String,Integer> numberOfAttemptAndroid = new HashMap<>();



    public String login(String username, String password) {
        if(blacklist.contains(username)) message = "Your account is blacklisted, contact the CRC to resolve the problem.";
        else if(password.length()<=1) {
            login.add(username);
            message = "Your password is too weak, please update it by going to your my account.";
            if(Collections.frequency(login, username) > 1) message += " - We detected that your account is logged in multiple devices";
        } else if(usersList.get(username).equals(password)){
            login.add(username);
            message = "Welcome sqli!";
            if(username.equals("admin")) {
                message = "Welcome admin!";
            }
            numberOfAttempt.put(username,0);
        }else if(!usersList.get(username).equals("password")) {
            if(numberOfAttempt.get(username)==null) numberOfAttempt.put(username, 0);
            numberOfAttempt.put(username, numberOfAttempt.get(username) + 1);
            message = "User or password are incorrect.";
            if(numberOfAttempt.get(username) >= 3) message = "Multiple erroneous credentials, your account is locked.";
            if(login.contains(username)) login.remove(username);
        }
        if(Collections.frequency(login, username) > 1 && password.length() > 1) message = "We detected that your account is logged in multiple devices";

        return message;
    }

    public void addUser(String username, String password) {
        usersList.put(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        if(usersList.get(username).equals(password)){
            login.add(username);
            message = "Welcome sqli!";
            if(username.equals("admin")) {
                message = "Welcome admin!";
                return message;
            }
            numberOfAttemptAndroid.put(username,0);
        }else if(!usersList.get(username).equals("password")) {
            if(numberOfAttemptAndroid.get(username)==null) numberOfAttemptAndroid.put(username, 0);
            numberOfAttemptAndroid.put(username, numberOfAttemptAndroid.get(username) + 1);
            message = "User or password are incorrect.";
            if(numberOfAttemptAndroid.get(username) >= 3) message = "Multiple erroneous credentials, your account is locked.";
        }
        return message;
    }

    public void blacklist(String sqli) {
        blacklist.add(sqli);
    }
}
