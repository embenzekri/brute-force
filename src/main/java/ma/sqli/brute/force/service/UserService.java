package ma.sqli.brute.force.service;

import ma.sqli.brute.force.model.User;
import ma.sqli.brute.force.persistence.UserStore;

public class UserService {
    public static final String PARAMETRIZED_AUTHENTICATION_SUCCESS_MESSAGE = "Welcome %s!";
    public static final String AUTHENTICATION_FAILURE_MESSAGE = "User or password are incorrect.";
    public static final String MULTIPLE_LOGIN_ATTEMPTS_MESSAGE = "Multiple erroneous credentials, your account is locked.";
    public static final int MAXIMUM_LOGIN_ATTEMPTS = 3;
    private UserStore userStore;

    public UserService(UserStore userStore) {
        this.userStore = userStore;
    }

    public void addUser(String username, String password) {
        userStore.add(new User(username, password));
    }

    public String login(String username, String password) {
        User user = userStore.findBy(username);
        if(isUserPasswordIncorrect(password, user)) {
            return buildAuthenticationFailureMessage(user);
        }
        return buildAuthenticationSuccessMessage(user);
    }

    private String buildAuthenticationFailureMessage(User user) {
        userStore.incrementUserFailedLoginAttempts(user.getUsername());
        return isMaxLoginAttemptsReached(user) ? AUTHENTICATION_FAILURE_MESSAGE : MULTIPLE_LOGIN_ATTEMPTS_MESSAGE;
    }

    private String buildAuthenticationSuccessMessage(User user) {
        userStore.resetUserFailedLoginAttempts(user.getUsername());
        return String.format(PARAMETRIZED_AUTHENTICATION_SUCCESS_MESSAGE, user.getUsername());
    }

    private boolean isUserPasswordIncorrect(String password, User user) {
        return user == null || !password.equals(user.getPassword());
    }

    private boolean isMaxLoginAttemptsReached(User user) {
        return user != null && user.getFailedLoginAttempts() < MAXIMUM_LOGIN_ATTEMPTS;
    }
}
