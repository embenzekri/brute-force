package ma.sqli.brute.force.validator;

import ma.sqli.brute.force.Device;
import ma.sqli.brute.force.User;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class BruteForceLoginValidator implements LoginValidator {
    public static final String MULTIPLE_ERRONEOUS_CREDENTIALS = "Multiple erroneous credentials, your account is locked.";
    private final LoginValidator loginValidator;

    public BruteForceLoginValidator(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    @Override
    public String validate(User user, String username, String password, Device deviceName) {
        if (user.maxAttemptsExceeded(deviceName)) {
            return MULTIPLE_ERRONEOUS_CREDENTIALS;
        }
        return loginValidator.validate(user, username, password, deviceName);
    }
}
