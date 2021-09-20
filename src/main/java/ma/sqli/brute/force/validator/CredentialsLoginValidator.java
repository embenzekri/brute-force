package ma.sqli.brute.force.validator;

import static java.lang.String.format;
import ma.sqli.brute.force.Device;
import ma.sqli.brute.force.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class CredentialsLoginValidator implements LoginValidator {
    public static final String WELCOME_ADMIN = "Welcome %s!";
    public static final String PASSWORD_TOO_WEAK = "Your password is too weak, please update it by going to your my account.";
    private final LoginValidator loginValidator;

    public CredentialsLoginValidator(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    @Override
    public String validate(User user, String username, String password, Device deviceName) {
        if (user.hasPassword(password)) {
            List<String> warnings = new ArrayList<>();
            if (password.length() < 3) {
                warnings.add(PASSWORD_TOO_WEAK);
            }
            user.loggedSuccess(deviceName);
            if (user.isLoggedInMultipleDevices()) {
                warnings.add("We detected that your account is logged in multiple devices");
            }
            return warnings.isEmpty() ? format(WELCOME_ADMIN, username) : warnings.stream().collect(Collectors.joining(" - "));
        }
        return loginValidator.validate(user, username, password, deviceName);
    }
}
