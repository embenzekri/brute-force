package ma.sqli.brute.force;

import ma.sqli.brute.force.validation.LoginParams;
import ma.sqli.brute.force.validation.LoginValidator;
import ma.sqli.brute.force.validation.LoginValidatorFactory;
import ma.sqli.brute.force.validation.WarningsCollector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class BruteForceApp {
    private Map<String, String> usernameAndPasswords = new HashMap<>();
    private Map<DeviceEnum, UserLoginAttempts> attemptsByDevice;
    private Set<String> loggedInUsers = new HashSet<>();

    public BruteForceApp() {
        this.attemptsByDevice = new HashMap<>();
        this.attemptsByDevice.put(DeviceEnum.WEB, new UserLoginAttempts());
        this.attemptsByDevice.put(DeviceEnum.ANDROID, new UserLoginAttempts());
    }

    public String login(String username, String password) {
        return loginWithDevice(username, password, DeviceEnum.WEB);
    }

    public String loginWithAndroid(String username, String password) {
        return loginWithDevice(username, password, DeviceEnum.ANDROID);
    }

    private String loginWithDevice(String username, String password, DeviceEnum deviceEnum) {

        LoginValidator validator = new LoginValidatorFactory().createValidators(usernameAndPasswords,loggedInUsers, attemptsByDevice);
        return validator.validate(new LoginParams(username, password, deviceEnum), new WarningsCollector());
    }


    private List<String> oldLoginWithDevice(String username, String password, DeviceEnum deviceEnum) {
        List<String> warnings = new ArrayList<>();
        if (getAttemptsforDevice(deviceEnum).isBlacklisted(username)) {
            loggedInUsers.remove(username);
            warnings.add("Your account is blacklisted, contact the CRC to resolve the problem.");
        } else if (isValidCredentials(username, password)) {
            getAttemptsforDevice(deviceEnum).resetAttemptsForUser(username);
            if (loggedInUsers.contains(username)) {
                warnings.add("We detected that your account is logged in multiple devices");
            } else {
                loggedInUsers.add(username);
                if (password.length() < 2) {
                    warnings.add("Your password is too weak, please update it by going to your my account.");
                } else {
                    warnings.add(String.format("Welcome %s!", username));
                }
            }

        } else if (getAttemptsforDevice(deviceEnum).isMaxloginErrorsExceeded(username)) {
            loggedInUsers.remove(username);
            warnings.add("Multiple erroneous credentials, your account is locked.");
        } else {
            getAttemptsforDevice(deviceEnum).loginErrorForUser(username);
            loggedInUsers.remove(username);
            warnings.add("User or password are incorrect.");
        }
        return warnings;
    }

    private UserLoginAttempts getAttemptsforDevice(DeviceEnum deviceEnum) {
        return attemptsByDevice.get(deviceEnum);
    }

    private boolean isValidCredentials(String username, String password) {
        return usernameAndPasswords.containsKey(username) &&
                usernameAndPasswords.get(username).equals(password);
    }

    public void addUser(String username, String password) {
        usernameAndPasswords.put(username, password);
        getAttemptsforDevice(DeviceEnum.WEB).registerUser(username);
        getAttemptsforDevice(DeviceEnum.ANDROID).registerUser(username);
    }

    public void blacklist(String username) {
        getAttemptsforDevice(DeviceEnum.WEB).blacklist(username);
        getAttemptsforDevice(DeviceEnum.ANDROID).blacklist(username);
    }
}
