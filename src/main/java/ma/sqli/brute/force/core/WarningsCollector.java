package ma.sqli.brute.force.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/20/21, lun.
 **/
public class WarningsCollector {
    public static final String WELCOME_ADMIN = "Welcome %s!";
    public static final String PASSWORD_TOO_WEAK_MSG = "Your password is too weak, please update it by going to your my account.";
    public static final String MULTIPLE_DEVICES_LOGIN_MSG = "We detected that your account is logged in multiple devices";
    public static final String ACCOUNT_BLACKLISTED_MSG = "Your account is blacklisted, contact the CRC to resolve the problem.";
    public static final String MULTIPLE_ERRONEOUS_CREDENTIALS_MSG = "Multiple erroneous credentials, your account is locked.";
    public static final String USER_OR_PASSWORD_ARE_INCORRECT_MSG = "User or password are incorrect.";

    private List<LoginValidationError> warnings = new ArrayList<>();

    public void addWarning(LoginValidationError warning) {
        warnings.add(warning);
    }

    public List<LoginValidationError> getWarnings() {
        return warnings;
    }
}
