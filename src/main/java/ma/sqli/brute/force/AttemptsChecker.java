package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

public class AttemptsChecker {

    private Storage storage = new Storage();
    private Map<String, Integer> wrongAttempts = new HashMap<>();


    private int wrongAttempts(String username){
        if(!wrongAttempts.containsKey(username)) {
            wrongAttempts.put(username, 1);
            return 1;
        }
        int wrongAttemptsTotal = wrongAttempts.get(username) + 1;
        wrongAttempts.put(username, wrongAttemptsTotal);
        return wrongAttemptsTotal;
    }

    public String checkAttempts(String username){
        int attempts = wrongAttempts(username);
        if(attempts < 3) {
            return "User or password are incorrect.";
        } else {
            return "Multiple erroneous credentials, your account is locked.";
        }

    }

    public void resetAttempts(String username) {
        wrongAttempts.put(username, 0);
    }
}
