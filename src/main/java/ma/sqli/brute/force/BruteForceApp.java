package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private Map<String, String> usernameAndPasswords = new HashMap<>();

    private Map<Device, Map<String, Integer>> LoginErrorsByDevice = new HashMap<>();
    private Map<String, Integer> loginErrorsByUsername = new HashMap<>();
    private Map<String, Integer> loginErrorsByUsernameAndroid = new HashMap<>();

    public String login(String username, String password) {
        if (isValidCredentials(username, password)) {
            resetErrorsCount(username, loginErrorsByUsername);
            return String.format("Welcome %s!", username);
        } else if (loginErrorsByUsername.get(username) >= 2) {
            return "Multiple erroneous credentials, your account is locked.";
        } else {
            incrementErrorsCount(username, loginErrorsByUsername);
            return "User or password are incorrect.";
        }
    }

    public String loginWithAndroid(String username, String password) {
        if (isValidCredentials(username, password)) {
            resetErrorsCount(username, loginErrorsByUsernameAndroid);
            return String.format("Welcome %s!", username);
        } else if (loginErrorsByUsernameAndroid.get(username) >= 2) {
            return "Multiple erroneous credentials, your account is locked.";
        } else {
            incrementErrorsCount(username, loginErrorsByUsernameAndroid);
            return "User or password are incorrect.";
        }
    }

    private void resetErrorsCount(String username, Map<String, Integer> loginErrorsByUsername) {
        loginErrorsByUsername.put(username, 0);
    }

    private void incrementErrorsCount(String username, Map<String, Integer> loginErrorsByUsername) {
        loginErrorsByUsername.put(username, loginErrorsByUsername.get(username) + 1);
    }

    private boolean isValidCredentials(String username, String password) {
        return usernameAndPasswords.containsKey(username) &&
                usernameAndPasswords.get(username).equals(password);
    }

    public void addUser(String username, String password) {
        usernameAndPasswords.put(username, password);
        if (!loginErrorsByUsername.containsKey(username)) {
            resetErrorsCount(username, loginErrorsByUsername);
        }
        if (!loginErrorsByUsernameAndroid.containsKey(username)) {
            resetErrorsCount(username, loginErrorsByUsernameAndroid);
        }
    }

    public void blacklist(String sqli) {

    }
}
