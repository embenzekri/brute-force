package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepo {

    private static UserRepo single_instance = null;

    List<User> users = new ArrayList<User>();

    public static UserRepo getInstance()
    {
        if (single_instance == null)
            single_instance = new UserRepo();

        return single_instance;
    }

    public List<User> findUserByNameAndPassword(String admin, String password){
        List<User> CurrentUser = users.stream()
                .filter(c -> c.getUsername() == admin && c.getPassword() == password)
                .collect(Collectors.toList());
        return CurrentUser;
    }

    public void addUser(String admin, String s) {
        User user = new User(admin, s);
        users.add(user);
    }

}
