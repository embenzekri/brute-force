package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruteForceApp {

    Map<String,String> users = new HashMap<>();
    Map<String,Integer> attemptsWeb = new HashMap<>();
    Map<String,Integer> attemptsAndroid = new HashMap<>();
    List<String> blackList = new ArrayList<>();
    public String login(String username, String password) {
        return verification(username, password, attemptsWeb);
    }

    public String verification(String username, String password, Map<String, Integer> attempts) {
        if(blackList.contains(username)){
            return "Your account is blacklisted, contact the CRC to resolve the problem.";
        }
        if (users.containsKey(username)&& users.get(username).equals(password)){
            attempts.put(username,0);
            if(password.length()==1){
                return "Your password is too weak, please update it by going to your my account.";
            }
            return "Welcome "+username+"!";
        }else if (users.get(username)!=password){
            attempts.put(username, attempts.get(username)+1);
            if (attempts.get(username)>2){
                return "Multiple erroneous credentials, your account is locked.";
            }
            return "User or password are incorrect.";
        }
        return "";
    }

    public void addUser(String username, String password) {
        users.put(username,password);
        attemptsWeb.put(username,0);
        attemptsAndroid.put(username,0);
    }

    public String loginWithAndroid(String username, String password) {
        return verification(username, password, attemptsAndroid);
    }

    public void blacklist(String username) {
        blackList.add(username);
    }
}
