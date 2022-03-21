package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

public class Attempt {
    Map<String, Integer> atm = new HashMap<String, Integer>();

    public int firstError(String username) {
        if (atm.containsKey(username)) {
            int i = atm.get(username) + 1;
            atm.put(username, i);
        } else {
            atm.put(username, 0);
        }
        return atm.get(username);
    }

    public String checkAttempt(String username) {
        firstError(username);

        if (atm.get(username) > 3) {
            return "Multiple erroneous credentials, your account is locked.";
        }
        return "Welcome admin!";
    }
}
