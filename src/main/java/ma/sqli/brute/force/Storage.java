package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Storage {

    private Map<String, String> users = new HashMap<>();
    private List<String> blacklist = new LinkedList<>();

    public Map<String, String> getUsers(){
        users = new HashMap<>();
        users.put("admin", "123");
        users.put("sqli", "0000");

        return users;
    }

    public void addUser(String username, String password){
        users.put(username, password);
    }

    public void blacklist(String username){
        blacklist.add(username);
    }


    public boolean isBlacklisted(final String username){
        boolean result = blacklist.contains(username);
        return result;
    }
}
