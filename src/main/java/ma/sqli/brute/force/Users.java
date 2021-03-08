package ma.sqli.brute.force;

import java.util.HashMap;

public class Users {

    private HashMap<String, String> users = new HashMap<String, String>();

    public String wrongCredentials(String admin, String password, int count){
        if (count >= 3){
            return "Multiple erroneous credentials, your account is locked." ;
        }
        else {
            return "User or password are incorrect.";
        }
    }

    public String rightCredentials(String admin, String password){
        return "Welcome " + admin + "!" ;
    }

    public HashMap<String, String> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, String> users) {
        this.users = users;
    }

}
