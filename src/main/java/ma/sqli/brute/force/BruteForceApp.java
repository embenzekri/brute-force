package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
    public static Map<String,String> accounts;
    public static Map<String,Integer> bruteForceByUser;

    static{
        accounts=new HashMap<String, String>();
        bruteForceByUser=new HashMap<String, Integer>();
    }

    public String login(String admin, String password) {
        if(admin==null || password==null) throw new RuntimeException("Are you serious?");
        if(accounts.containsKey(admin)){

            if(accounts.get(admin).equals(password)){

                bruteForceByUser.put(admin,0);
                return "Welcome "+admin+"!";

            }else{

                int nbrOfErr=bruteForceByUser.get(admin);
                bruteForceByUser.put(admin,nbrOfErr+1);

                nbrOfErr=bruteForceByUser.get(admin);
                if(nbrOfErr>2) return "Multiple erroneous credentials, your account is locked.";
            }

        }

        return "User or password are incorrect.";
    }

    public void addUser(String admin, String s) {
        accounts.put(admin,s);
        bruteForceByUser.put(admin,0);
    }
}
