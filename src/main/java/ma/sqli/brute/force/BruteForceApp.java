package ma.sqli.brute.force;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    SecureLogin secureLogin = new SecureLogin();

    public String login(String admin, String password) {
        return secureLogin.login(admin, password);
    }


    public void addUser(String admin, String s) {
        secureLogin.signup(admin, s);
    }
}
