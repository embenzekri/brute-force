package ma.sqli.brute.force;

import ma.sqli.brute.force.Model.Login;
import ma.sqli.brute.force.Model.User;
import ma.sqli.brute.force.Storage.UserStorage;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/

public class BruteForceApp implements BruteForce{

    private final UserStorage userStorage;

    public BruteForceApp() {
        this.userStorage=new UserStorage();

    }

    @Override
    public String login(String username, String password) {
        Login newLogiAttempt=new Login(username,password,userStorage);

        return  newLogiAttempt.login();





       /* if(user==null) return "User or password are incorrect.";
        else if(!user.getPassword().equals(password)) {
            counter++;
            return "User or password are incorrect.";
        }
        else if(username.equals("admin")){
            if(user.isBlocked()) return  "Multiple erroneous credentials, your account is locked.";
            else if(counter==3){
                user.setBlocked(true);
                return "Multiple erroneous credentials, your account is locked.";
            }
            counter=0;

            return "Welcome admin!";
        }
        return "Welcome";*/
    }

    @Override
    public void addUser(String username, String password) {
        User newUser=new User(username,password);
        userStorage.saveUser(newUser);

    }

    @Override
    public String loginWithAndroid(String username, String password) {
        return null;
    }

    @Override
    public void blacklist(String sqli) {

    }
}
