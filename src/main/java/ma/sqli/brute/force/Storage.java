package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Storage {

    private static Map<String, String> users = new HashMap<>();
    private static List<String> blacklist = new LinkedList<>();

    public static Map<String, String> getUsers(){
        users = new HashMap<>();
        users.put("admin", "123");
        users.put("sqli", "0000");

        return users;
    }

    public static void addUser(String username, String password){
        users.put(username, password);
    }

    public static void blacklist(String username){
        blacklist.add(username);
    }


    public static boolean isBlacklisted(final String username){
        boolean result = blacklist.contains(username);
        return result;
    }
}
