package ma.sqli.brute.force;

import java.util.HashSet;
import java.util.Set;

public class UserLoginAttempts {
    private Set<User> users = new HashSet<>();

    public void resetAttemptsForUser(String username) {
        getUserByUsername(username).resetAttempts();
    }

    public boolean isMaxloginErrorsExceeded(String username) {
        return getUserByUsername(username).isLocked();
    }

    public void loginErrorForUser(String username) {
        getUserByUsername(username).loginError();
    }

    public void registerUser(String username) {
        users.add(new User(username));
        resetAttemptsForUser(username);
    }

    public boolean isBlacklisted(String username) {
        return getUserByUsername(username).isBlacklisted();
    }

    public void blacklist(String username) {
        getUserByUsername(username).blacklist();
    }

    private User getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.hasUsername(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Provided username doesn't exists."));
    }
}
