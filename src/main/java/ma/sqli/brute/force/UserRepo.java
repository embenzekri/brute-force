package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepo {
    List<User> users = new ArrayList<User>();
    HashMap<String, Integer> loginAttempt= new HashMap<String, Integer>();

    public String login(String admin, String password) {
        List<User> CurrentUser = users.stream()
                .filter(c -> c.getUsername() == admin && c.getPassword() == password)
                .collect(Collectors.toList());
        if(CurrentUser.isEmpty()){
            loginAttempt.put(admin, loginAttempt.get(admin) + 1 );

            if(loginAttempt.get(admin) >= 3){
                System.out.println(loginAttempt.get(admin));
                return "Multiple erroneous credentials, your account is locked.";
            }
            else {
                return "User or password are incorrect.";
            }
        }
        else {
            loginAttempt.put(admin, 0);
            return "Welcome " + CurrentUser.get(0).getUsername() + "!";
        }
    }


    public void addUser(String admin, String s) {
        User user = new User(admin, s);
        loginAttempt.put(admin, 0);
        users.add(user);
    }
}
