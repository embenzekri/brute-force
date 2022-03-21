package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;




public class Login_Attempt {
     public Map<String,String> Accounts=new HashMap<>();

    public void setAccounts(String username, String password) {
        Accounts.put(username, password);
    }

    boolean Check(String username, String password){
         if(Accounts.get(username).contains(password)) {
             return true;
         }else return  false;
     }
}
