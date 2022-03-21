package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
//    private String username;
//    private String password;
    private HashMap<String,String> users = new HashMap<String ,String >();
    private HashSet BlackList = new HashSet<String>();
    private static int counter = 0;

    public String login(String username, String password) {

            if(BlackList.contains(username)){
                return "Your account is blacklisted, contact the CRC to resolve the problem.";
            }
            if(users.get(username).length() == 1){
                return "Your password is too weak, please update it by going to your my account.";
            }
            String result;
            if(users.get(username).equals(password)){
                counter = 0;
                result = "Welcome "+username+"!";
            }else {
                result = "User or password are incorrect.";
                counter++;
                if(counter >= 3){
                    result = "Multiple erroneous credentials, your account is locked.";
                }
            }
        return result;
    }

//    public boolean isPasswordWeak(){
//        if(users.)
//    }

    public void addUser(String username, String password) {
        users.put(username,password);
    }

    public String loginWithAndroid(String username, String password) {
        String result;
        if(users.get(username).equals(password)){
            result = "Welcome "+username+"!";
        }else{
            result = "User or password are incorrect.";
        }
        return result;
    }

    public void blacklist(String sqli) {
//        if(BlackList.contains(sqli)){
//            System.out.println("Your account is blacklisted, contact the CRC to resolve the problem.");
//        }
        BlackList.add(sqli);
    }
}
