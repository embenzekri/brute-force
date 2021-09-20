package ma.sqli.brute.force.validator;

import static ma.sqli.brute.force.LoginValidationError.ACCOUNT_BLACKLISTED;
import ma.sqli.brute.force.Device;
import ma.sqli.brute.force.User;
import ma.sqli.brute.force.WarningsCollector;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class BlacklistedLoginValidator implements LoginValidator {
    private final LoginValidator loginValidator;

    public BlacklistedLoginValidator(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    @Override
    public boolean validate(User user, String username, String password, Device deviceName, WarningsCollector warnings) {
        if (user.isBlacklisted()) {
            warnings.addWarning(ACCOUNT_BLACKLISTED);
            return false;
        }
        return loginValidator.validate(user, username, password, deviceName, warnings);
    }
}
