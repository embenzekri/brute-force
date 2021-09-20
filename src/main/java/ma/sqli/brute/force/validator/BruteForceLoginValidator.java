package ma.sqli.brute.force.validator;

import static ma.sqli.brute.force.LoginValidationError.MULTIPLE_ERRONEOUS_CREDENTIALS;
import ma.sqli.brute.force.Device;
import ma.sqli.brute.force.User;
import ma.sqli.brute.force.WarningsCollector;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class BruteForceLoginValidator implements LoginValidator {
    private final LoginValidator loginValidator;

    public BruteForceLoginValidator(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    @Override
    public boolean validate(User user, String username, String password, Device deviceName, WarningsCollector warnings) {
        if (user.maxAttemptsExceeded(deviceName)) {
            warnings.addWarning(MULTIPLE_ERRONEOUS_CREDENTIALS);
            return false;
        }
        return loginValidator.validate(user, username, password, deviceName, warnings);
    }
}
