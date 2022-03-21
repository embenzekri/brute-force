package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private final UserDatabase userDatabase = UserDatabase.getInstance();
    private static final String LOGIN_FAILED = "User or password are incorrect.";
    private static final int MAX_LOGINS = 3;

    public String login(String username, String password) {

        User user = userDatabase.getUsers()
            .stream()
            .filter(u -> u.getUsername().equals(username))
            .findFirst()
            .orElse(null);

        if(user != null && user.getPassword().equals(password)){
            return "Welcome "+username+"!";
        }

        return LOGIN_FAILED;
    }

    public void addUser(String username, String password) {
        userDatabase.addUser(new User(username, password));
    }

    public String loginWithAndroid(String username, String password) {
        return "";
    }

    public void blacklist(String sqli) {

    }
}
