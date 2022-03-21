package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.List;

public class ListUsers {
    List<User> users ;

    public ListUsers(){
        this.users = new ArrayList<User>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public List<User> getUsers(){
        return this.users;
    }

    public User getUser(User target){
        return this.users.stream()
            .filter(user -> target.getName().equals(user.getName()) && target.getPassword().equals(user.getPassword()))
            .findAny()
            .orElse(null);
    }

    public User getUserByUsername(String username){
        return this.users.stream()
            .filter(user -> username.equals(user.getName()))
            .findAny()
            .orElse(null);
    }
}
