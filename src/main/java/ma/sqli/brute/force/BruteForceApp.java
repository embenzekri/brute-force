package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private Map<String, String> users = new HashMap<>();
    private Map<String, Integer> connectedDevices = new HashMap<>();
    private Map<String, Integer> attempts = new HashMap<>();
    private List<String> blacklistUser = new ArrayList<>();


    public String login(String username, String password) {
        if (isAccountBlacklisted(username))
            return "Your account is blacklisted, contact the CRC to resolve the problem.";

        boolean areCredentialsValid = areCredentialsValid(username, password);
        if (areCredentialsValid) {
            return validateLogin(username, password);
        } else {
            return invalidateLogin(username);
        }
    }

    private String invalidateLogin(String username) {
        if (isAccountLocked(username))
            return "Multiple erroneous credentials, your account is locked.";

        lockAccount(username);
        return "User or password are incorrect.";
    }

    private String validateLogin(String username, String password) {
        attempts.put(username, 0);
        connectWithNewDevice(username);

        String warnings = checkWarning(username, password);
        if ( warnings.length() != 0) {
            return warnings;
        } else {
            return "Welcome " + username + "!";
        }
    }

    private String checkWarning(String username, String password) {
        List<String> warnings = new ArrayList<>();

        if (isPasswordWeak(password)) {
            warnings.add( "Your password is too weak, please update it by going to your my account.");
        }

        if (isLoggedInMultipleDevices(username)) {
            warnings.add("We detected that your account is logged in multiple devices");
        }

        StringJoiner stringJoiner = new StringJoiner(" - ");
        warnings.forEach(stringJoiner::add);
        return  stringJoiner.toString();
    }

    private void connectWithNewDevice(String username) {
        connectedDevices.put(username, connectedDevices.get(username) +1);
    }

    public void addUser(String username, String password) {
        users.put(username, password);
        attempts.put(username, 0);
        connectedDevices.put(username, 0);
    }

    public String loginWithAndroid(String username, String password) {
        if (isAccountBlacklisted(username))
            return "Your account is blacklisted, contact the CRC to resolve the problem.";

        boolean areCredentialsValid = areCredentialsValid(username, password);
        if (areCredentialsValid) {
            return validateLogin(username, password);
        } else {
            return invalidateLogin(username);
        }
    }

    public void blacklist(String sqli) {
        blacklistUser.add(sqli);
    }

    private boolean isPasswordWeak(String password) {
        return password.length() <= 2;
    }

    private boolean doesUserExists(String username) {
        return users.containsKey(username);
    }

    private boolean areCredentialsValid(String username, String password) {
        return users.get(username).equals(password);
    }

    private void lockAccount(String username) {
        attempts.put(username, attempts.get(username) + 1);
    }

    private boolean isAccountLocked(String username) {
        return attempts.get(username) >= 2;
    }

    private boolean isAccountBlacklisted(String username) {
        return blacklistUser.contains(username);
    }

    private boolean isLoggedInMultipleDevices(String username) {
        return connectedDevices.get(username) > 1;
    }
}
