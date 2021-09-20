package ma.sqli.brute.force.validator;

import ma.sqli.brute.force.Device;
import ma.sqli.brute.force.User;
import ma.sqli.brute.force.WarningsCollector;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public interface LoginValidator {
    boolean validate(User user, String username, String password, Device deviceName, WarningsCollector warnings);

    static LoginValidator newValidators() {
        LoginValidator incorrectPasswordValidator = new IncorrectPasswordValidator();
        LoginValidator bruteForceLoginValidator = new BruteForceLoginValidator(incorrectPasswordValidator);
        LoginValidator credentialsLoginValidator = new CredentialsLoginValidator(bruteForceLoginValidator);
        return new BlacklistedLoginValidator(credentialsLoginValidator);
    }
}
