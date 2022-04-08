package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    //tables
    private static HashMap<String, Integer> lockedListWeb = new HashMap<>();
    private static HashMap<String, Integer> lockedListAndroid = new HashMap<>();
    private static HashMap<String, String> userList = new HashMap<>();
    private static HashMap<String, Boolean> blackList = new HashMap<>();

    //messages errors
    private final String LOGIN_INCORECT = "User or password are incorrect.";
    private final String ERROR_LOCKED = "Multiple erroneous credentials, your account is locked.";
    private final String BLACK_LIST = "Your account is blacklisted, contact the CRC to resolve the problem.";

    //attempt of user
    private int attempt = 0;

    public String login(String username, String password) {
        lockedListWeb.put(username,attempt);
        if (userList.containsKey(username) && userList.get(username) == password && lockedListWeb.get(username) < 3) {
            attempt = 0;
            return "Welcome " + username + "!";
        } else if(userList.containsKey(username) && userList.get(username) != password && lockedListWeb.get(username) < 2){
            attempt++;
            lockedListWeb.put(username, attempt);
            return LOGIN_INCORECT;
        }else {
            return ERROR_LOCKED;
        }
    }

    public void addUser(String username, String password) {
        if (!userList.containsKey(username) && password.length() > 2) {
            userList.put(username, password);
        }
    }

    public String loginWithAndroid(String username, String password) {
        attempt = 0;
        lockedListAndroid.put(username,attempt);
        if (userList.containsKey(username) && userList.get(username) == password && lockedListAndroid.get(username) < 3) {
            attempt = 0;
            return "Welcome " + username + "!";
        } else if(userList.containsKey(username) && userList.get(username) != password && lockedListAndroid.get(username) < 2){
            attempt++;
            lockedListAndroid.put(username, attempt);
            return LOGIN_INCORECT;
        }else {
            return ERROR_LOCKED;
        }
    }

    public void blacklist(String sqli) {
        if (userList.containsKey(sqli)) {
            blackList.put(sqli,true);
        }
    }
}
