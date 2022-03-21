package ma.sqli.brute.force.Storage;

import java.util.HashMap;
import java.util.Map;

import ma.sqli.brute.force.Model.User;

public class UserStorage {
    private Map<String, User> usersList =new HashMap<>();

    public User loadUser(String name){ return usersList.get(name);}
    public User saveUser(User user){
        return usersList.put(user.getName(),user);
    }
}
