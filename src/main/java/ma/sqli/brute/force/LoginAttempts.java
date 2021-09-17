package ma.sqli.brute.force;

import java.util.EnumMap;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/17/21, ven.
 **/
public class LoginAttempts {
    private EnumMap<Device, Integer> attemptsByDevice = new EnumMap<>(Device.class);

    void resetLoginAttempts(Device deviceName) {
        attemptsByDevice.put(deviceName, 0);
    }

    boolean maxAttemptsExceeded(Device deviceName) {
        if (attemptsByDevice.containsKey(deviceName)) {
            attemptsByDevice.put(deviceName, attemptsByDevice.get(deviceName) + 1);
        } else {
            attemptsByDevice.put(deviceName, 1);
        }
        if (attemptsByDevice.get(deviceName) >= 3) {
            return true;
        }
        return false;
    }
}
