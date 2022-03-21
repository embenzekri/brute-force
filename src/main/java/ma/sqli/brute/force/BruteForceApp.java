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

    private Map<String, String> mapWeb;
    private List<String> blackList;
    private Map<String, String> mapAndroid;
     BruteForceApp() {
        mapWeb = new HashMap<String, String>();
        mapAndroid = new HashMap<String, String>();
        blackList = new ArrayList<String>();
    }

    public String login(String username, String password) {
            if (blackList.contains(username)) {
                return "Your account is blacklisted, contact the CRC to resolve the problem.";
            }
            if (password.length() == 1) {
                return "Your password is too weak, please update it by going to your my account.";
            }
            if (mapWeb.get(username).equals(password)) {
                Attempt.setZero();
                return "Welcome " + username + "!";
            }
            if (!mapWeb.get(username).equals(password) && Attempt.getValue() < 2) {
                Attempt.incrementValue();
                return "User or password are incorrect.";
            } else if (Attempt.getValue() >= 2) {
                return "Multiple erroneous credentials, your account is locked.";
            }
            return "";
    }

    public void addUser(String username, String password) {
        mapWeb.put(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        if (mapWeb.get(username).equals(password)) {
            mapAndroid.put(username,password);
            return "Welcome " + username + "!";
        } else
            return "User or password are incorrect.";
    }

    public void blacklist(String username)
    {
        blackList.add(username);
    }
}
