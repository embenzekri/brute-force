package ma.sqli.brute.force;

import java.util.Map;

public class Authenticator {
    private Storage storage = new Storage();
    private AttemptsChecker attemptsChecker = new AttemptsChecker();


    public String authenticate(String username, String password){
        if(storage.isBlacklisted(username)) {
            return "Your account is blacklisted, contact the CRC to resolve the problem.";
        }
        if(checkCredentials(username, password)){
            attemptsChecker.resetAttempts(username);
            return "Welcome " + username + "!";
        } else {
            String result = attemptsChecker.checkAttempts(username);
            return result;
        }
    }

    private boolean checkCredentials(String username, String password){
        Map<String, String> users = storage.getUsers();
        return users.containsKey(username) && users.get(username).equals(password);
    }

}
