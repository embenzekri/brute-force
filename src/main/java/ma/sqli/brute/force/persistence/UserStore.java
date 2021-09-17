package ma.sqli.brute.force.persistence;

import ma.sqli.brute.force.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public User findBy(String username, String password) {
        return users.stream()
                .filter(user -> username.equals(user.getUsername()) && password.equals(user.getPassword())).findFirst().orElse(null);
    }

    public User findBy(String username) {
        return users.stream()
                .filter(user -> username.equals(user.getUsername())).findFirst().orElse(null);
    }

    public void incrementUserFailedLoginAttempts(String username){
        users.stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst()
                .ifPresent(User::incrementFailedLoginAttempts);
    }

    public void resetUserFailedLoginAttempts(String username) {
        users.stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst()
                .ifPresent(User::resetFailedLoginAttempts);
    }
}
