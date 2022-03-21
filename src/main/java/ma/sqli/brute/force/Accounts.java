package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Accounts {
    Map<String,String> accountsMap = new HashMap<>();

    public boolean login(String username, String password) {
        return Objects.equals(accountsMap.get(username), password);
    }


    public void add(String username, String password) {
        accountsMap.put(username,password);
    }
}
