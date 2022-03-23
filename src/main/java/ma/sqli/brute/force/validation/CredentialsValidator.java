package ma.sqli.brute.force.validation;

import static java.lang.String.format;

import ma.sqli.brute.force.DeviceEnum;
import ma.sqli.brute.force.UserLoginAttempts;

import java.util.Map;

public class CredentialsValidator implements LoginValidator {
    private final Map<String, String> usernameAndPasswords;
    private LoginValidator loginValidator;
    private Map<DeviceEnum, UserLoginAttempts> attemptsByDevice;

    public CredentialsValidator(Map<String, String> usernameAndPasswords,
                                LoginValidator loginValidator,
                                Map<DeviceEnum, UserLoginAttempts> attemptsByDevice) {
        this.usernameAndPasswords = usernameAndPasswords;
        this.loginValidator = loginValidator;
        this.attemptsByDevice = attemptsByDevice;
    }

    public String validate(LoginParams loginParams, WarningsCollector warnings) {
        if (isValidCredentials(loginParams.getUsername(), loginParams.getPassword())) {
            attemptsByDevice.get(loginParams.getDeviceEnum()).resetAttemptsForUser(loginParams.getUsername());
            return format("Welcome %s!", loginParams.getUsername());
        }

        return loginValidator.validate(loginParams, warnings);
    }

    private boolean isValidCredentials(String username, String password) {
        return usernameAndPasswords.containsKey(username) &&
                usernameAndPasswords.get(username).equals(password);
    }

}
