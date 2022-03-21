package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    Map<String, String> AddedUsers = new HashMap<>();
    List<String> loggedInUsers = new ArrayList<>();
    String result = "";

    public String login(String username, String password) {

        if (AddedUsers.get(username).equals(password)) {
            result = "Welcome " + username + "!";
            //loggedInUsers.remove(username);
        } else if (loggedInUsers.contains(username)) {
            result = "Multiple erroneous credentials, your account is locked.";
        } else {
            result = "User or password are incorrect.";
        }

        loggedInUsers.add(username);

        return result;
    }

    public void addUser(String username, String password) {
        AddedUsers.put(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        return "";
    }

    public void blacklist(String sqli) {

    }
}
