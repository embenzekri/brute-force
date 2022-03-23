package ma.sqli.brute.force.validation;


import ma.sqli.brute.force.DeviceEnum;
import ma.sqli.brute.force.UserLoginAttempts;

import java.util.Map;
import java.util.Set;

public class BlacklistedValidator implements LoginValidator {
    private final Set<String> loggedInUsers;
    private final Map<DeviceEnum, UserLoginAttempts> attemptsByDevice;
    private final LoginValidator newValidator;

    public BlacklistedValidator(Set<String> loggedInUsers,
                                Map<DeviceEnum, UserLoginAttempts> attemptsByDevice,
                                LoginValidator newValidator) {
        this.loggedInUsers = loggedInUsers;
        this.attemptsByDevice = attemptsByDevice;
        this.newValidator = newValidator;
    }

    public String validate(LoginParams loginParams, WarningsCollector warnings) {
        if (attemptsByDevice.get(loginParams.getDeviceEnum()).isBlacklisted(loginParams.getUsername())) {
            loggedInUsers.remove(loginParams.getUsername());
            return "Your account is blacklisted, contact the CRC to resolve the problem.";
        }
        return newValidator.validate(loginParams, warnings);
    }
}
