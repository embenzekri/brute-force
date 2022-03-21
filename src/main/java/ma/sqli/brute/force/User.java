package ma.sqli.brute.force;

public class User {
    private static final int MAX_ATTEMPTS = 3;
    private String username;
    private String password;
    private int wrongAttempts = 0;
    private int wrongAttemptsAndroid = 0;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void resetAttempts() {
        this.wrongAttempts = 0;
    }

    public void incrementAttemptsCounter() {
        this.wrongAttempts++;
    }

    public boolean isLocked() {
        return this.wrongAttempts >= MAX_ATTEMPTS;
    }

    public void resetAttemptsAndroid() {
        this.wrongAttemptsAndroid = 0;
    }

    public void incrementAttemptsCounterAndroid() {
        this.wrongAttemptsAndroid++;
    }

    public boolean isLockedAndroid() {
        return this.wrongAttemptsAndroid >= MAX_ATTEMPTS;
    }
}
