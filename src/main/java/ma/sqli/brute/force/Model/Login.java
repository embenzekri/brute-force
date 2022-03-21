package ma.sqli.brute.force.Model;

import java.util.HashMap;
import java.util.Map;

import ma.sqli.brute.force.Storage.UserStorage;

public class Login {

    private Map<String,Integer> attempts=new HashMap<>();
    private final UserStorage userStorage;


    public Login(UserStorage userStorage) {
        this.userStorage = userStorage;


    }




    public String attempt(User user){
        if(attempts.containsKey(user.getName())){
            Integer count=attempts.get(user.getName());


                User _user=this.userStorage.loadUser(user.getName());
                if(_user==null || _user.getPassword()!=user.getPassword()){
                    attempts.put(user.getName(),count+1);
                    if(count>=2){
                        return  "Multiple erroneous credentials, your account is locked.";
                    }
                    return "User or password are incorrect.";
                }
                attempts.put(user.getName(),0);
                return "Welcome "+_user.getName()+"!";


        }
        else {
            User _user=this.userStorage.loadUser(user.getName());
            if(_user==null || _user.getPassword()!=user.getPassword()){
                attempts.put(user.getName(),1);
                return "User or password are incorrect.";
            }
            attempts.put(user.getName(),0);

            return "Welcome "+_user.getName()+"!";
        }






    }
}
