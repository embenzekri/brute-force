package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    private final List<User> users = new ArrayList<>();
    private static UserDatabase instance;

    private UserDatabase(){}

    public static UserDatabase getInstance(){
        if(instance == null){
            instance = new UserDatabase();
        }

        return instance;
    }

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }

}
