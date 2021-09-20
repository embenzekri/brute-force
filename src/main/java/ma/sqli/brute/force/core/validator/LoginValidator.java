package ma.sqli.brute.force.core.validator;

import ma.sqli.brute.force.core.User;
import ma.sqli.brute.force.core.WarningsCollector;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public interface LoginValidator {
    boolean validate(User user, LoginParams loginParams, WarningsCollector warnings);

    static LoginValidator newValidators() {
        LoginValidator incorrectPasswordValidator = new IncorrectPasswordValidator();
        LoginValidator bruteForceLoginValidator = new BruteForceLoginValidator(incorrectPasswordValidator);
        LoginValidator credentialsLoginValidator = new CredentialsLoginValidator(bruteForceLoginValidator);
        return new BlacklistedLoginValidator(credentialsLoginValidator);
    }
}
