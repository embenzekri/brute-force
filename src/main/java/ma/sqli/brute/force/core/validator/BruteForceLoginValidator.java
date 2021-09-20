package ma.sqli.brute.force.core.validator;

import static ma.sqli.brute.force.core.LoginValidationError.MULTIPLE_ERRONEOUS_CREDENTIALS;
import ma.sqli.brute.force.core.User;
import ma.sqli.brute.force.core.WarningsCollector;

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
    public boolean validate(User user, LoginParams loginParams, WarningsCollector warnings) {
        if (user.maxAttemptsExceeded(loginParams.getDevice())) {
            warnings.addWarning(MULTIPLE_ERRONEOUS_CREDENTIALS);
            return false;
        }
        return loginValidator.validate(user, loginParams, warnings);
    }
}
