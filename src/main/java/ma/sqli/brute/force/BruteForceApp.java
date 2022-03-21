package ma.sqli.brute.force;

import ma.sqli.brute.force.DAO.DAOUsers;
import ma.sqli.brute.force.model.LoginAttempt;
import ma.sqli.brute.force.model.User;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private DAOUsers daoUsers = new DAOUsers();

    public void addUser(String username , String password){
        daoUsers.addUser(new User(username , password));
    }

    public String login(String username , String password){
        LoginAttempt user = daoUsers.UserIfExist(username);

        if (user.getPassword()==password){
            user.resetNbLoginAttempt();
            return "Welcome "+username+"!";
        }else{
            if (user.isNbLoginAttemptreached()){
                return "Multiple erroneous credentials, your account is locked.";
            }else{
                user.increaseNbLoginAttempt();
                return "User or password are incorrect.";
            }
        }


    }




    public String loginWithAndroid(String username, String password) {
        LoginAttempt user = daoUsers.UserIfExist(username);

        if (user.getPassword()==password){
            user.resetNbAndroidLoginAttempt();;
            return "Welcome "+username+"!";
        }else{
            if (user.isNbLoginAndroidAttemptreached()){
                return "Multiple erroneous credentials, your account is locked.";
            }else{
                user.increaseNbAndroidLoginAttempt();
                return "User or password are incorrect.";
            }
        }
    }

    public void blacklist(String str){

    }
}
