package ma.sqli.brute.force;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
    private Authenticator authenticator = new Authenticator();
    private List<String> authenticatedUsers = new LinkedList<>();

    public String login(String username, String password) {
        String result = authenticator.authenticate(username, password, Device.WEB);
        authenticatedUsers.add(username);
        return result;
    }

    public void addUser(String username, String password) {
        Storage.addUser(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        String result = authenticator.authenticate(username, password, Device.ANDROID);
        authenticatedUsers.add(username);
        return result;
    }

    public void blacklist(String username){
        Storage.blacklist(username);
    }
}
