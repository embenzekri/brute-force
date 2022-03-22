package ma.sqli.brute.force.validation;

import ma.sqli.brute.force.DeviceEnum;

public class LoginParams {
    private final String username;
    private final String password;
    private final DeviceEnum deviceEnum;

    public LoginParams(String username, String password, DeviceEnum deviceEnum) {
        this.username = username;
        this.password = password;
        this.deviceEnum = deviceEnum;
    }

    public boolean passwordLengthHigherThan(int length) {
        return password.length() > length;
    }

    public DeviceEnum getDeviceEnum() {
        return deviceEnum;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
