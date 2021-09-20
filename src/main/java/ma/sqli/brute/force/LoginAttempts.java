package ma.sqli.brute.force;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class LoginAttempts {
    public static final int MIN_ATTEMPT_COUNT = 1;
    public static final int MAX_ATTEMPT_COUNT = 3;
    public static final int ONE = 1;
    private EnumMap<Device, Integer> attemptsByDevice = new EnumMap<>(Device.class);
    private Set<Device> loggedInDevices = new HashSet<>();

    void loginSuccess(Device deviceName) {
        attemptsByDevice.put(deviceName, 0);
        loggedInDevices.add(deviceName);
    }

    boolean maxAttemptsExceeded(Device deviceName) {
        if (attemptsByDevice.containsKey(deviceName)) {
            attemptsByDevice.put(deviceName, attemptsByDevice.get(deviceName) + ONE);
        } else {
            attemptsByDevice.put(deviceName, MIN_ATTEMPT_COUNT);
        }
        if (attemptsByDevice.get(deviceName) >= MAX_ATTEMPT_COUNT) {
            return true;
        }
        return false;
    }

    public boolean isLoggedInMultipleDevices() {
        return loggedInDevices.size() > 1;
    }
}
