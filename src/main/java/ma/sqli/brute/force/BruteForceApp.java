package ma.sqli.brute.force;

import java.util.HashMap;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private Users users = new Users() ;
    private int count;

    public String login(String admin, String password) {
        if (users.getUsers().get(admin).equals(password)){
            count = 0;
            return users.rightCredentials(admin, password);
        }
        else {
            count++ ;
            return users.wrongCredentials(admin, password, count) ;
        }
    }

    public void addUser(String admin, String s) {
        users.getUsers().put(admin, s) ;
    }


}
