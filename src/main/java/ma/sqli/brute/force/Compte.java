package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

public class Compte {
    private String username;
    private String password;


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Compte(String username, String password) {
        this.password=password;
        this.username=username;

    }
}
