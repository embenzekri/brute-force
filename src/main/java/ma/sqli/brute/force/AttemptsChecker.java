package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

public class AttemptsChecker {

    private Map<String, Integer> wrongAttemptsWeb = new HashMap<>();
    private Map<String, Integer> wrongAttemptsAndroid = new HashMap<>();


    private int wrongAttempts(String username, Device device ){
        Map<String, Integer> wrongAttempts = getWrongAttemptsByDevice(device);
        if(!wrongAttempts.containsKey(username)) {
            wrongAttempts.put(username, 1);
            return 1;
        }
        int wrongAttemptsTotal = wrongAttempts.get(username) + 1;
        wrongAttempts.put(username, wrongAttemptsTotal);
        return wrongAttemptsTotal;
    }

    public String checkAttempts(String username, Device device){
        int attempts = wrongAttempts(username, device);
        if(attempts < 3) {
            return "User or password are incorrect.";
        } else {
            return "Multiple erroneous credentials, your account is locked.";
        }

    }

    public void resetAttempts(String username, Device device) {
        if(device == Device.WEB) {
            wrongAttemptsWeb.put(username, 0);
        } else {
            wrongAttemptsAndroid.put(username, 0);
        }
    }

    private Map<String, Integer> getWrongAttemptsByDevice(Device device) {
        return device == Device.WEB ? wrongAttemptsWeb : wrongAttemptsAndroid;
    }
}
