package ma.sqli.brute.force.core.validator;

import static ma.sqli.brute.force.core.LoginValidationError.ACCOUNT_BLACKLISTED;
import ma.sqli.brute.force.core.User;
import ma.sqli.brute.force.core.WarningsCollector;

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
    public boolean validate(User user, LoginParams loginParams, WarningsCollector warnings) {
        if (user.isBlacklisted()) {
            warnings.addWarning(ACCOUNT_BLACKLISTED);
            return false;
        }
        return loginValidator.validate(user, loginParams, warnings);
    }
}
