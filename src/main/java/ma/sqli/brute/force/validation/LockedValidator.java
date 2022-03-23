package ma.sqli.brute.force.validation;


import ma.sqli.brute.force.DeviceEnum;
import ma.sqli.brute.force.UserLoginAttempts;

import java.util.Map;
import java.util.Set;

public class LockedValidator implements LoginValidator {
    private final Set<String> loggedInUsers;
    private final Map<DeviceEnum, UserLoginAttempts> attemptsByDevice;

    public LockedValidator(Set<String> loggedInUsers, Map<DeviceEnum, UserLoginAttempts> attemptsByDevice) {
        this.loggedInUsers = loggedInUsers;
        this.attemptsByDevice = attemptsByDevice;
    }

    public String validate(LoginParams loginParams, WarningsCollector warnings) {
        if (attemptsByDevice.get(loginParams.getDeviceEnum()).isMaxloginErrorsExceeded(loginParams.getUsername())) {
            loggedInUsers.remove(loginParams.getUsername());
            return "Multiple erroneous credentials, your account is locked.";
        }
        attemptsByDevice.get(loginParams.getDeviceEnum()).loginErrorForUser(loginParams.getUsername());
        return "User or password are incorrect.";
    }
}
