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
    String result;
    Map User = new HashMap<>();
    private Compte compte;

    public String login(String username, String password) {

        String wrong = WrongCredentials(username, password);
        result = blacklist(username);
        if (password.length() < 2) {
            result = "Your password is too weak, please update it by going to your my account.";
        }

        return result;
    }

    public void addUser(String username, String password) {
        compte = new Compte(username, password);
        User.put(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        return "";
    }

    public String blacklist(String username) {
        String result = "Welcome " + username + "!";
        if (username == "sqli") {
            result = "Your account is blacklisted, contact the CRC to resolve the problem.";
        }
        return result;
    }

    public String WrongCredentials(String username, String password) {
        String result = "Welcome " + username + "!";
        if (User.containsValue(username) == true && User.get(username) == password) {
            result = "User or password are incorrect.";
        }
        return result;
    }
}
