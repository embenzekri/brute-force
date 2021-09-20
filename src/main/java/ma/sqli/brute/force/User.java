package ma.sqli.brute.force;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class User {
    private final String username;
    private final String password;
    private boolean blacklisted;
    private LoginAttempts attempts = new LoginAttempts();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean hasUsername(String username) {
        return this.username.equals(username);
    }

    public boolean hasPassword(String password) {
        return this.password.equals(password);
    }

    public void blacklist() {
        blacklisted = true;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void loggedSuccess(Device deviceName) {
        attempts.loginSuccess(deviceName);
    }

    public boolean maxAttemptsExceeded(Device deviceName) {
        return attempts.maxAttemptsExceeded(deviceName);
    }

    public boolean isLoggedInMultipleDevices() {
        return attempts.isLoggedInMultipleDevices();
    }
}
