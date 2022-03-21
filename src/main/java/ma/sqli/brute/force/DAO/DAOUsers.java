package ma.sqli.brute.force.DAO;

import ma.sqli.brute.force.model.LoginAttempt;
import ma.sqli.brute.force.model.User;

import java.util.ArrayList;
import java.util.List;

public class DAOUsers {
    private List<LoginAttempt> users = new ArrayList<>();

    public void addUser(User user){
        users.add(new LoginAttempt(user));
    }

    public LoginAttempt UserIfExist(String username) {
        LoginAttempt user = findUserIfExist(username);
        if (user ==null){
            return null;
        }
        return user;
    }

    public LoginAttempt findUserIfExist(String username){
        for (LoginAttempt user:users) {
            if (user.getUsername().equals(username)){
                return  user;
            }
        }
        return null;
    }
}
