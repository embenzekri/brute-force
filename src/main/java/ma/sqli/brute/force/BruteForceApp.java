package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

    private Map<String, String> users;
    private Cache cache;

    BruteForceApp(){
        this.users=new HashMap<String, String>();
        this.cache=new Cache();
    }

    public String login(String admin, String password) {

        // initialised the cache with the user
        if (!this.cache.getTentatives().containsKey(admin))
            this.cache.setTentatives(admin, 0);

        // 3 attempts successifs
        if(this.cache.getTentatives().get(admin)<3){
            for(String compte : users.keySet())
                if(compte==admin && users.get(compte)==password ){
                    // reset the attempts of the compte
                    this.cache.setTentatives(admin, 0);
                    return "Welcome "+compte+"!";
                }
            this.cache.setTentatives(admin, this.cache.getTentatives().get(admin).intValue()+1);
        }

        // more than 3 attempts in the same compte
        if(this.cache.getTentatives().get(admin)>=3) {
            return "Multiple erroneous credentials, your account is locked.";
        }

        return "User or password are incorrect.";
    }

    public void addUser(String admin, String password) {
        this.users.put(admin, password);
    }
}
