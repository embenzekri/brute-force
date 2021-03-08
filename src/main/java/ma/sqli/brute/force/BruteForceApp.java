package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private User user;
    private List<User> users = new ArrayList<User>();

    public String login(String username, String password) {

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    user.setBruteForceDetector(0);
                    return user.toString();
                } else if (user.getBruteForceDetector() == 2) {
                    return "Multiple erroneous credentials, your account is locked.";
                } else {
                    user.setBruteForceDetector(user.getBruteForceDetector());
                    return "User or password are incorrect.";
                }
            }
        }

        return "User or password are incorrect.";
    }


    public void addUser(String username, String password) {
        boolean isExist = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                isExist = true;
            }
        }

        if (!isExist) {
            user = new User(username, password);
            users.add(user);
        }
    }
}
