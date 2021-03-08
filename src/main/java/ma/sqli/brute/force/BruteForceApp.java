package ma.sqli.brute.force;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    BruteForceChecker bruteForceChecker;
    User user = new User();
    public String login(String username, String password) {


        user.setName(username);
        user.setPassword(password);
        bruteForceChecker = new BruteForceChecker();
        return bruteForceChecker.login(user);

    }

    public void addUser(String admin, String s) {
        Data.users.put(admin, s);
    }

    public void shouldLogin(){

    }
}
