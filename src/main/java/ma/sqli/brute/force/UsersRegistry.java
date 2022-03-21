package ma.sqli.brute.force;

import java.util.HashMap;
import java.util.Map;

public class UsersRegistry {

    private final String LOGIN_SUCCESS_MESSAGE = "Welcome ";
    private final String LOGIN_FAILED_MESSAGE = "User or password are incorrect.";
    private final String BRUTE_FORCE_DENIED_LOGIN_MESSAGE = "Multiple erroneous credentials, your account is locked.";

    private final Map<String, User> usersMap = new HashMap<>();


    public void registerUser(String username, String password) {
        this.usersMap.put(username, new User(username,password));
    }

    public String logUser(String username, String password) {
        if (!doUserNameMatch(username)){
            return LOGIN_FAILED_MESSAGE;
        }
        if (doPasswordMatch(this.usersMap.get(username), password)){
            return LOGIN_SUCCESS_MESSAGE + username + "!";
        }
        if (isAccountLocked(this.usersMap.get(username))){
            return BRUTE_FORCE_DENIED_LOGIN_MESSAGE;
        }
        return LOGIN_FAILED_MESSAGE;
    }

    private boolean doUserNameMatch(String username) {
        return this.usersMap.containsKey(username);
    }

    private boolean isAccountLocked(User user) {
        return user.isLocked();
    }

    private boolean doPasswordMatch(User user, String password) {
        boolean logAttemptSuccess = user.getPassword().equals(password);
        user.incrementAttemptsCounter();
        if (logAttemptSuccess) {
            user.resetAttempts();
            return true;
        }
        return false;
    }

//    public String loginWithAndroid(String username, String password, S) {
//        if (!doUserNameMatch(username)){
//            return LOGIN_FAILED_MESSAGE;
//        }
//        if (doPasswordMatch(this.usersMap.get(username), password)){
//            return LOGIN_SUCCESS_MESSAGE + username + "!";
//        }
//        if (isAccountLocked(this.usersMap.get(username))){
//            return BRUTE_FORCE_DENIED_LOGIN_MESSAGE;
//        }
//        return LOGIN_FAILED_MESSAGE;
//    }
}
