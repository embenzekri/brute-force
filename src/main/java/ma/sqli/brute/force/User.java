package ma.sqli.brute.force;

public class User {

    private String username;
    private String password;
    private int bruteForceDetector;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bruteForceDetector = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBruteForceDetector() {
        return bruteForceDetector;
    }

    public void setBruteForceDetector(int bruteForceDetector) {
        this.bruteForceDetector++;
    }

    @Override
    public String toString() {
        return "Welcome " + username + "!";
    }
}
