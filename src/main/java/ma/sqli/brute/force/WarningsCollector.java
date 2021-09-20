package ma.sqli.brute.force;

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

    public String buildResponse(boolean canLogin, String username) {
        StringBuilder response = new StringBuilder();
        if (canLogin && warnings.isEmpty()) {
            response.append(String.format(WELCOME_ADMIN, username));
        }
        String warningMessages = warnings.stream().map(loginValidationError -> {
            switch (loginValidationError) {
                case PASSWORD_TOO_WEAK:
                    return PASSWORD_TOO_WEAK_MSG;
                case MULTIPLE_DEVICES_LOGIN:
                    return MULTIPLE_DEVICES_LOGIN_MSG;
                case ACCOUNT_BLACKLISTED:
                    return ACCOUNT_BLACKLISTED_MSG;
                case MULTIPLE_ERRONEOUS_CREDENTIALS:
                    return MULTIPLE_ERRONEOUS_CREDENTIALS_MSG;
                case USER_OR_PASSWORD_ARE_INCORRECT:
                    return USER_OR_PASSWORD_ARE_INCORRECT_MSG;
                default:
                    throw new IllegalArgumentException("Login error not supported");
            }
        }).collect(Collectors.joining(" - "));
        return response + warningMessages;
    }
}
