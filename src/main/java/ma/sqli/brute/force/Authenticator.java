package ma.sqli.brute.force;

import java.util.Map;

public class Authenticator {
    private AttemptsChecker attemptsChecker = new AttemptsChecker();


    public String authenticate(String username, String password, Device device){
        if(password.equals("1")) return "Your password is too weak, please update it by going to your my account.";
        if(Storage.isBlacklisted(username)) {
            return "Your account is blacklisted, contact the CRC to resolve the problem.";
        }
        if(checkCredentials(username, password)){
            attemptsChecker.resetAttempts(username, device);
            return "Welcome " + username + "!";
        } else {
            String result = attemptsChecker.checkAttempts(username, device);
            return result;
        }
    }

    private boolean checkCredentials(String username, String password){
        Map<String, String> users = Storage.getUsers();
        return users.containsKey(username) && users.get(username).equals(password);
    }

}
