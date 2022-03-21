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

    public String login(String username, String password) {

        if (username == "admin" && password == "123") {
            return "Welcome admin!";
        } else if (blackList.contains(username)) {
            return "Your account is blacklisted, contact the CRC to resolve the problem.";
        } else if (username == "sqli" && password == "0000") {
            return "Welcome sqli!";
        } else {
            return "User or password are incorrect.";
        }
    }

    public void addUser(String username, String password) {
    }

    public String loginWithAndroid(String username, String password) {
        return "";
    }

    public void blacklist(String sqli) {
        blackList.add(sqli);
    }
}