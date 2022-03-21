package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private final String USER_NAME_ADMIN = "admin";
    private final String PASSWORD_ADMIN = "123";
    private final String USER_NAME_SQLI = "sqli";
    private final String PASSWORD_SQlI = "0000";
    HashMap<String, Integer> lockedList = new HashMap<String, Integer>();
    HashMap<String, String> userList = new HashMap<String, String>();

    public String login(String username, String password) {

        if (userList.containsKey(username) && userList.get(username) == password) {
            return "Welcome " + username + "!";
        } else {
            return "User or password are incorrect.";
        }
    }

    public void addUser(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (!userList.containsKey(username) && password.length() > 2) {
                userList.put(username, password);
            }
        }
    }

    public String loginWithAndroid(String username, String password) {
        if (USER_NAME_SQLI == username && PASSWORD_SQlI == password ||
            USER_NAME_SQLI == username && PASSWORD_SQlI == password) {
            return "Welcome " + username + "!";
        } else {
            return "User or password are incorrect.";
        }
    }

    public void blacklist(String sqli) {

    }
}
