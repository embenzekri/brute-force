package ma.sqli.brute.force;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private Accounts users = new Accounts();
    private int wrongCount = 0;
    private Set<String> blacklist = new HashSet<>();
    private boolean logged = false;

    public String login(String username, String password) {
        LoginOutput result = new LoginOutput();
        if (!blacklist.contains(username)) {
            if (users.login(username, password)) {
                wrongCount = 0;
                if (!logged) {
                    logged = true;
                    result = result.plus(password.length() >= 3 ? "Welcome " + username + "!" : "Your password is too weak, please update it by going to your" +
                        " my account.");
                } else {
                    result = result.plus("We detected that your account is logged in multiple devices");
                }
            } else if (wrongCount < 2) {
                wrongCount++;
                result = result.plus("User or password are incorrect.");
            } else {
                result.plus("Multiple erroneous credentials, your account is locked.");
            }
        } else {
            result.plus("Your account is blacklisted, contact the CRC to resolve the problem.");
        }
        return result.toString();
    }

    public void addUser(String username, String password) {
        users.add(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        wrongCount = 0;
        return login(username, password);
    }

    public void blacklist(String username) {
        blacklist.add(username);
    }
}
