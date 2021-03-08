package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : MAKHLOUF Soufiane
 * @since : 3/8/21, dim.
 **/
public class BruteForceApp {

    private Map<String, String> users;
    private static int counter = 0;
    private static final String WELCOME_ADMIN = "Welcome admin!";
    private static final String AUTHENTIFICATION_FAILED = "User or password are incorrect.";
    private static final String MULTIPLE_ERRONEOUS = "Multiple erroneous credentials, your account is locked.";
    private static final String WELCOME_SQLI = "Welcome sqli!";

    public BruteForceApp(){
        init();
    }

    private void init(){
        users = new HashMap<String, String>();
        users.put("admin", "123");
        users.put("sqli", "0000");
    }

    private boolean fetchUser(String admin, String password) {
        return users.get(admin).equals(password);
    }

    private String adminType(String admin){
        if(admin == "sqli")
            return WELCOME_SQLI;

        return WELCOME_ADMIN;
    }


    public String login(String admin, String password) {

        if(fetchUser(admin, password)){
            counter = 0;
            return adminType(admin);
        }
        else if(!fetchUser(admin, password) && counter < 2){
            counter++;
            return AUTHENTIFICATION_FAILED;
        }else{
            return MULTIPLE_ERRONEOUS;
        }
    }

    public void addUser(String admin, String s) {
        getUsers().put(admin,s);
    }

    public Map<String, String> getUsers() {
        return users;
    }
}
