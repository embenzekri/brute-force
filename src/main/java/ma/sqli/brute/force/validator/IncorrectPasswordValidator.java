package ma.sqli.brute.force.validator;

import ma.sqli.brute.force.Device;
import ma.sqli.brute.force.LoginValidationError;
import ma.sqli.brute.force.User;
import ma.sqli.brute.force.WarningsCollector;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class IncorrectPasswordValidator implements LoginValidator {

    @Override
    public boolean validate(User user, String username, String password, Device deviceName, WarningsCollector warnings) {
        warnings.addWarning(LoginValidationError.USER_OR_PASSWORD_ARE_INCORRECT);
        return false;
    }
}
