package ma.sqli.brute.force.core.validator;

import ma.sqli.brute.force.core.LoginValidationError;
import ma.sqli.brute.force.core.User;
import ma.sqli.brute.force.core.WarningsCollector;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class IncorrectPasswordValidator implements LoginValidator {

    @Override
    public boolean validate(User user, LoginParams loginParams, WarningsCollector warnings) {
        warnings.addWarning(LoginValidationError.USER_OR_PASSWORD_ARE_INCORRECT);
        return false;
    }
}
