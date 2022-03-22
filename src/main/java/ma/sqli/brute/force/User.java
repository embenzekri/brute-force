package ma.sqli.brute.force;

/**
 * @author : El Mahdi Benzekri
 * @since : 22/03/2022, mar.
 **/
public class User {
    private static final int INITIAL_ATTEMPTS = 0;
    public static final int MAX_LOGIN_ATTEMPTS_BEFORE_LOCKED = 2;
    private String userName;
    private int attemptsCount;
    private boolean isBlacklisted;

    public User(String userName) {
        this.userName = userName;
        this.attemptsCount = 0;
        this.isBlacklisted = false;
    }


    public boolean hasUsername(String username) {
        return this.userName.equals(username);
    }

    public void resetAttempts() {
        attemptsCount = INITIAL_ATTEMPTS;
    }

    public boolean isLocked() {
        return attemptsCount >= MAX_LOGIN_ATTEMPTS_BEFORE_LOCKED;
    }

    public void loginError() {
        attemptsCount++;
    }

    public void blacklist() {
        isBlacklisted = true;
    }

    public boolean isBlacklisted() {
        return isBlacklisted;
    }
}
