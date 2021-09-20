package ma.sqli.brute.force.core.persistence;

import ma.sqli.brute.force.core.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/20/21, lun.
 **/
public class UserStore {
    List<User> users = new ArrayList<>();

    public Optional<User> findUser(String username) {
        return users.stream().filter(u -> u.hasUsername(username)).findFirst();
    }

    public void addUser(User user) {
        users.add(user);
    }
}
