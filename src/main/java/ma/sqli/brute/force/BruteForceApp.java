package ma.sqli.brute.force;

import ma.sqli.brute.force.model.User;
import ma.sqli.brute.force.service.UserService;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private final UserService userService;

    public BruteForceApp(UserService userService) {
        this.userService = userService;
    }

    public String login(String username, String password) {
        return userService.login(username, password);
    }

    public void addUser(String username, String password) {
        userService.addUser(username, password);
    }

    public String loginWithAndroid(String username, String password) {
        return "";
    }
}
