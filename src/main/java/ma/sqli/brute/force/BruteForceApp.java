package ma.sqli.brute.force;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private UsersRegistry usersRegistry = new UsersRegistry();

    public String login(String username, String password) {
        return this.usersRegistry.logUser(username, password);
    }

    public void addUser(String username, String password) {
        this.usersRegistry.registerUser(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        return "";
//        this.usersRegistry.loginWithAndroid(username, password);
    }

    public void blacklist(String sqli) {

    }
}
