package ma.sqli.brute.force;

import java.util.ArrayList;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
    private String message;
    private ArrayList<String> black;
    private ArrayList<User> users;
    private ArrayList<User> usersAndroid;

    public BruteForceApp() {
        this.black = new ArrayList<String>();
        this.users = new ArrayList<User>();
        this.usersAndroid = new ArrayList<User>();
    }

    public String login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                if (u.getPassword().length() <= 1) {
                    message = "Your password is too weak, please update it by going to your my account.";
                } else {
                    message = "Welcome " + u.getUsername() + "!";
                }
            } else {
                message = "User or password are incorrect.";
            }
        }
        if (black.contains(username)) {
            message = "Your account is blacklisted, contact the CRC to resolve the problem.";
        }

        return message;
    }

    public void addUser(String username, String password) {
        users.add(new User(username, password));
    }

    public String loginWithAndroid(String username, String password) {
        usersAndroid.add(new User(username, password));
        for (User u : usersAndroid) {
            if (users.contains(u)) {
                message += " - We detected that your account is logged in multiple devices";
            }
        }
        return message;
    }

    public void blacklist (String sqli){
        black.add(sqli);
    }
}
