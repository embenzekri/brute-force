package ma.sqli.brute.force;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/


/*
        procedural approach
 */
public class BruteForceApp {


    public Map<String,String> user = new HashMap<String, String>() ;
    public Map<String, Integer> increment_user = new HashMap<String, Integer>();


    public String login(String admin, String password) {
        if(user.containsKey(admin)){
            if(user.get(admin).equals(password)) {
                increment_user.put(admin, 0);
                return "Welcome Admin!";
            }

        }else
        {
            increment_user.put(admin,increment_user.get(admin)+1);
            if(increment_user.get(admin)>2)
                return "Multiple erroneous credentials, your account is locked";
        }


        return"User or password are incorrect.";
    }

    public void addUser(String admin, String s) {
            user.put(admin,s);
            increment_user.put(admin,0);
    }
}
