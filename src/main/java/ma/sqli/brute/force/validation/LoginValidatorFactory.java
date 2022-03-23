package ma.sqli.brute.force.validation;

import ma.sqli.brute.force.DeviceEnum;
import ma.sqli.brute.force.UserLoginAttempts;

import java.util.Map;
import java.util.Set;

public class LoginValidatorFactory {

    public LoginValidator createValidators(Map<String, String> usernameAndPasswords, Set<String> loggedInUsers, Map<DeviceEnum, UserLoginAttempts> attemptsByDevice) {
        LoginValidator lockedValidator = new LockedValidator(loggedInUsers, attemptsByDevice);
        CredentialsValidator credentialsValidator = new CredentialsValidator(usernameAndPasswords,
                lockedValidator,
                attemptsByDevice);
        BlacklistedValidator blacklistedValidator = new BlacklistedValidator(loggedInUsers,
                attemptsByDevice,
                credentialsValidator);

        return blacklistedValidator;
    }
}
