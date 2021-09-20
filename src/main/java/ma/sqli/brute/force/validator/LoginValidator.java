package ma.sqli.brute.force.validator;

import ma.sqli.brute.force.Device;
import ma.sqli.brute.force.User;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public interface LoginValidator {
    String validate(User user, String username, String password, Device deviceName);

    static LoginValidator newValidators() {
        LoginValidator incorrectPasswordValidator = new IncorrectPasswordValidator();
        LoginValidator bruteForceLoginValidator = new BruteForceLoginValidator(incorrectPasswordValidator);
        LoginValidator credentialsLoginValidator = new CredentialsLoginValidator(bruteForceLoginValidator);
        return new BlacklistedLoginValidator(credentialsLoginValidator);
    }
}
