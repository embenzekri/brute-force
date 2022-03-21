package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    Map<String,String> users=new HashMap<>();
    List<String> listLocked=new ArrayList<>();
    List<String> black=new ArrayList<>();
    int count =0;
    public String login(String username, String password) {
        if(black.contains(username)){
            return "Your account is blacklisted, contact the CRC to resolve the problem.";
        }
        else{
            if(users.get(username).length()<3){
                return "Your password is too weak, please update it by going to your my account.";
            }
            if(users.containsKey(username) && users.get(username)==password ){
                listLocked.removeAll(listLocked);
                return "Welcome "+username+"!";
            }
            else if(listLocked.size()>=2){
                return "Multiple erroneous credentials, your account is locked.";
            }
            else{
                listLocked.add(username);
                return "User or password are incorrect.";
            }
        }
    }

    public void addUser(String username, String password) {
            users.put(username,password);
    }

    public String loginWithAndroid(String username, String password) {
        return "";
    }

    public void blacklist(String sqli) {
        black.add(sqli);
    }
}
