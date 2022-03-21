package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
    List<User> userList = new ArrayList<>();
    List<String> blackList = new ArrayList<>();


    public String login(String username, String password) {
        if(passwordWeak(password))
            return "Your password is too weak, please update it by going to your my account.";
        if(!this.blackList.contains(username)) {
            for (User user : userList) {
                if (user.equalsUserName(username) && user.equalsPassword(password)) {
                    user.setAttempt(0);
                    return "Welcome " + username + "!";
                }
                if(user.equalsUserName(username))
                    user.setAttempt(user.getAttempt()+1);
            }

            return "User or password are incorrect.";
        } else {

            return "Your account is blacklisted, contact the CRC to resolve the problem.";
        }


    }
    public boolean passwordWeak(String password) {
        return password.length() < 3 ;
    }

    public void addUser(String username, String password) {
        User user = new User(username,password);
        userList.add(user);
    }

    public String loginWithAndroid(String username, String password) {
        return "";
    }

    public void blacklist(final String blackUserName) {
         blackList.add(blackUserName);
    }
}
