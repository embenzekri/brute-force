package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
    Map<String, BruteForce> users = new HashMap<String, BruteForce>();

    public BruteForceApp() {

    }

    public String login(String admin, String password) {
        BruteForce user = users.get(admin);
        int attempt = user.getAttempt();
        if (user.getAdmin().equals(admin) && user.getPassword().equals(password)) {
            user.setAttempt(0);
            return "Welcome " + user.getAdmin() + "!";
        } else {

            if (attempt < 2) {
                user.setAttempt(user.getAttempt() + 1);
                System.out.println(user.getAdmin() + user.getAttempt());
                return "User or password are incorrect.";

            } else {
                return "Multiple erroneous credentials, your account is locked.";
            }
        }


    }

    public void addUser(String admin, String s) {
        BruteForce bruteForce = new BruteForce(admin, s);
        users.put(admin, bruteForce);
    }
}
