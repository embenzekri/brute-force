package ma.sqli.brute.force;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {


    public static final String ACCOUNT_BLACKLISTED = "Your account is blacklisted, contact the CRC to resolve the problem.";

    public static final String USER_OR_PASSWORD_ARE_INCORRECT = "User or password are incorrect.";
    public static final String WELCOME_ADMIN = "Welcome %s!";
    public static final String MULTIPLE_ERRONEOUS_CREDENTIALS = "Multiple erroneous credentials, your account is locked.";
    public static final String PASSWORD_TOO_WEAK = "Your password is too weak, please update it by going to your my account.";
    private List<User> users = new ArrayList<>();

    public String login(String username, String password) {
        return doLogin(username, password, Device.WEB);
    }

    public void addUser(String username, String password) {
        users.add(new User(username, password));
    }

    public String loginWithAndroid(String username, String password) {
        return doLogin(username, password, Device.ANDROID);
    }

    private String doLogin(String username, String password, Device deviceName) {
        Optional<User> user = findUser(username);
        if (!user.isPresent()) {
            return USER_OR_PASSWORD_ARE_INCORRECT;
        }
        if (user.get().isBlacklisted()) {
            return ACCOUNT_BLACKLISTED;
        }
        if (isValidCredentials(username, password)) {
            if (password.length() < 3) {
                return PASSWORD_TOO_WEAK;
            }
            user.get().resetLoginAttempts(deviceName);
            return format(WELCOME_ADMIN, username);
        } else if (user.get().maxAttemptsExceeded(deviceName)) {
            return MULTIPLE_ERRONEOUS_CREDENTIALS;
        }
        return USER_OR_PASSWORD_ARE_INCORRECT;
    }

    public void blacklist(String username) {
        Optional<User> user = findUser(username);
        user.ifPresent(user1 -> user1.blacklist());
    }

    private boolean isValidCredentials(final String username, String password) {
        Optional<User> user = findUser(username);
        if (!user.isPresent()) {
            return false;
        }
        return user.get().hasPassword(password);
    }

    private Optional<User> findUser(String username) {
        return users.stream().filter(u -> u.hasUsername(username)).findFirst();
    }
}
