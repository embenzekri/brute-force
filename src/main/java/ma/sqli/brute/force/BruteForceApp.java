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
    private final Login login;

    public BruteForceApp() {
        this.userStorage=new UserStorage();
        this.login=new Login(userStorage);

    }

    @Override
    public String login(String username, String password) {
        User user= new User(username,password);
        return  login.attempt(user);





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
