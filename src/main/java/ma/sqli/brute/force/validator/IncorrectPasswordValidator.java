package ma.sqli.brute.force.validator;

import ma.sqli.brute.force.Device;
import ma.sqli.brute.force.User;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class IncorrectPasswordValidator implements LoginValidator {
    public static final String USER_OR_PASSWORD_ARE_INCORRECT = "User or password are incorrect.";

    @Override
    public String validate(User user, String username, String password, Device deviceName) {
        return USER_OR_PASSWORD_ARE_INCORRECT;
    }
}
