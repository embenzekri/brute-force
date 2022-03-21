package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
    private Authenticator authenticator = new Authenticator();
    private Set<String> authenticatedUsers = new HashSet<>();

    public String login(String username, String password) {
        //if(authenticatedUsers.contains(username)) return "We detected that your account is logged in multiple devices";
        String result = authenticator.authenticate(username, password);
        authenticatedUsers.add(username);
        return result;
    }

    public void addUser(String username, String password) {
        Storage.addUser(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        //if(authenticatedUsers.contains(username)) return "We detected that your account is logged in multiple devices";
        String result = authenticator.authenticate(username, password);
        authenticatedUsers.add(username);
        return result;
    }

    public void blacklist(String username){
        Storage.blacklist(username);
    }
}
