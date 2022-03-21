package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private static HashMap<String, Integer> lockedList = new HashMap<>();
    private static HashMap<String, String> userList = new HashMap<>();

    public String login(String username, String password) {
        if (userList.containsKey(username) && userList.get(username) == password) {
            return "Welcome " + username + "!";
        } else {
            return "User or password are incorrect.";
        }
    }

    public void addUser(String username, String password) {
        if (!userList.containsKey(username) && password.length() > 2) {
            userList.put(username, password);
        }
    }

    public String loginWithAndroid(String username, String password) {
        return "";
    }

    public void blacklist(String sqli) {

    }
}
