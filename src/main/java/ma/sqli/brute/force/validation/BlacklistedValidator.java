package ma.sqli.brute.force.validation;


import ma.sqli.brute.force.DeviceEnum;
import ma.sqli.brute.force.UserLoginAttempts;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BlacklistedValidator implements LoginValidator {
    private Set<String> loggedInUsers = new HashSet<>();
    private Map<DeviceEnum, UserLoginAttempts> attemptsByDevice;

    public String validate(LoginParams loginParams, WarningsCollector warnings) {
        if (attemptsByDevice.get(loginParams.getDeviceEnum()).isBlacklisted(loginParams.getUsername())) {
            loggedInUsers.remove(loginParams.getUsername());
            warnings.addWarning("Your account is blacklisted, contact the CRC to resolve the problem.");
        }
        return "";
    }
}
