package ma.sqli.brute.force.validator;

import ma.sqli.brute.force.Device;
import ma.sqli.brute.force.User;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class BlacklistedLoginValidator implements LoginValidator {
    public static final String ACCOUNT_BLACKLISTED = "Your account is blacklisted, contact the CRC to resolve the problem.";
    private final LoginValidator loginValidator;

    public BlacklistedLoginValidator(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    @Override
    public String validate(User user, String username, String password, Device deviceName) {
        if (user.isBlacklisted()) {
            return ACCOUNT_BLACKLISTED;
        }
        return loginValidator.validate(user, username, password, deviceName);
    }
}
