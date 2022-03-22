package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

public class BruteForceApp {

    Map<String,String> users = new HashMap<>();
    Map<String,Integer> attemps = new HashMap<>();
    Map<String,Integer> attemptsAndroid = new HashMap<>();
    public String login(String username, String password) {
        if (users.containsKey(username)&& users.get(username).equals(password)){
            attemps.put(username,0);
            return "Welcome "+username+"!";
        }else if (users.get(username)!=password){
            attemps.put(username,attemps.get(username)+1);
            if (attemps.get(username)>2){
                return "Multiple erroneous credentials, your account is locked.";
            }
            return "User or password are incorrect.";
        }
        return "";
    }

    public void addUser(String username, String password) {
        users.put(username,password);
        attemps.put(username,0);
        attemptsAndroid.put(username,0);
    }

    public String loginWithAndroid(String username, String password) {
        if (users.containsKey(username)&& users.get(username).equals(password)){
            attemptsAndroid.put(username,0);
            return "Welcome "+username+"!";
        }else if (users.get(username)!=password){
            attemptsAndroid.put(username,attemptsAndroid.get(username)+1);
            if (attemptsAndroid.get(username)>2){
                return "Multiple erroneous credentials, your account is locked.";
            }
            return "User or password are incorrect.";
        }
        return "";
    }

    public void blacklist(String sqli) {
    }
}
