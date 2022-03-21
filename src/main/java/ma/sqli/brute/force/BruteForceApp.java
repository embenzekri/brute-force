package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
    static Map<String,String> users = new HashMap<>();
    static Map<String,Integer> attempts = new HashMap<>();
    public String login(String username, String password) {
        if (users.containsKey(username)&& users.get(username)==password){
            return "Welcome "+username+"!";
        }
        if (users.containsKey(username)&&  users.get(username)!=password){
            attempts.merge(username,1,Integer::sum);
            return "User or password are incorrect.";
        }
        if(attempts.get(username)==2){
            return "Multiple erroneous credentials, your account is locked.";
        }




        return "";


    }

    public void addUser(String username, String password) {
        if (!users.containsKey(username)&& password.length()>2){
            users.put(username,password);
        }
    }

    public String loginWithAndroid(String username, String password) {
        return "";
    }

    public void blacklist(String sqli) {
    }
}
