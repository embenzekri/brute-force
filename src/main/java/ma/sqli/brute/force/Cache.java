package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<String , Integer> tentativesUser;

    public Cache(){
        tentativesUser=new HashMap<String, Integer>();
    }

    public Map<String, Integer> getTentatives() {
        return tentativesUser;
    }

    public void setTentatives(String user, Integer tentatives) {
        this.tentativesUser.put(user, tentatives);
    }
}
