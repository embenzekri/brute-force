package ma.sqli.brute.force.model;

public class User {
    private String username;
    private String password;
    private int failedLoginAttempts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void incrementFailedLoginAttempts() {
        failedLoginAttempts++;
    }

    public void resetFailedLoginAttempts() {
        failedLoginAttempts = 0;
    }
}
