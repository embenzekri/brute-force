package ma.sqli.brute.force.core.validator;

import ma.sqli.brute.force.core.LoginValidationError;
import ma.sqli.brute.force.core.User;
import ma.sqli.brute.force.core.WarningsCollector;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class CredentialsLoginValidator implements LoginValidator {
    private final LoginValidator loginValidator;

    public CredentialsLoginValidator(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    @Override
    public boolean validate(User user, LoginParams loginParams, WarningsCollector warnings) {
        if (user.hasPassword(loginParams.getPassword())) {
            if (loginParams.getPassword().length() < 3) {
                warnings.addWarning(LoginValidationError.PASSWORD_TOO_WEAK);
            }

            if (user.isLoggedInAnotherDevice(loginParams.getDevice())) {
                warnings.addWarning(LoginValidationError.MULTIPLE_DEVICES_LOGIN);
            }
            return true;
        }
        return loginValidator.validate(user, loginParams, warnings);
    }
}
