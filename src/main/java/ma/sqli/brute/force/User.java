package ma.sqli.brute.force;

public class User {
    private String username;
    private String password;
    private Attempt loginAttempts;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
