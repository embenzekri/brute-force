package ma.sqli.brute.force;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    UserRepo userRepo = new UserRepo();

    public String login(String admin, String password) {
        return userRepo.login(admin, password);
    }


    public void addUser(String admin, String s) {
        userRepo.addUser(admin, s);
    }
}
