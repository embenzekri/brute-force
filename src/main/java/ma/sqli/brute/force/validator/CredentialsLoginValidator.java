package ma.sqli.brute.force.validator;

import ma.sqli.brute.force.Device;
import ma.sqli.brute.force.LoginValidationError;
import ma.sqli.brute.force.User;
import ma.sqli.brute.force.WarningsCollector;

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
    public boolean validate(User user, String username, String password, Device device, WarningsCollector warnings) {
        if (user.hasPassword(password)) {
            if (password.length() < 3) {
                warnings.addWarning(LoginValidationError.PASSWORD_TOO_WEAK);
            }

            if (user.isLoggedInAnotherDevice(device)) {
                warnings.addWarning(LoginValidationError.MULTIPLE_DEVICES_LOGIN);
            }
            return true;
        }
        return loginValidator.validate(user, username, password, device, warnings);
    }
}
