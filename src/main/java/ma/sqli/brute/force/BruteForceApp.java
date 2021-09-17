package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    List<Person> users = new ArrayList<>();
    List<String> blackList = new ArrayList<>();
    int multipleErroneousNumber = 0;

    public String login(String username, String password) {

        if(isUser(username, password)){
            if(isBlackListed(username)) return "Your account is blacklisted, contact the CRC to resolve the problem.";
            if(isPasswordWeak(password)) return "Your password is too weak, please update it by going to your my account.";
            if(isMultipleErroneousCredentials(multipleErroneousNumber)) multipleErroneousNumber = 0;
            return "Welcome "+ username + "!";
        }

        multipleErroneousNumber++;
        if(isMultipleErroneousCredentials(multipleErroneousNumber)) return "Multiple erroneous credentials, your account is locked.";

        return "User or password are incorrect.";
    }

    public void addUser(String username, String password) {
        users.add(new Person(username, password));
    }

    public String loginWithAndroid(String username, String password) {
        if(isUser(username, password)){
            return "Welcome "+ username + "!";
        }
        return "User or password are incorrect.";
    }

    public void blacklist(String username){
        blackList.add(username);
    }

    public Boolean isUser(String username, String password){
        if (users.contains(new Person(username,password)) ) return true;
        return false;
    }

    public Boolean isMultipleErroneousCredentials(int numberOfTry){
        if(numberOfTry > 2) return true;
        return false;
    }

    public Boolean isBlackListed(String username){
        if (blackList.contains(username)) return true;
        return false;
    }

    public Boolean isPasswordWeak(String password){
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        if (password.matches(pattern)) return true;
        return false;
    }
}
