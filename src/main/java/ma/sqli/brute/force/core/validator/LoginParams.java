package ma.sqli.brute.force.core.validator;

import ma.sqli.brute.force.core.Device;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/20/21, lun.
 **/
public class LoginParams {
    private String username;
    private String password;
    private Device device;

    public LoginParams(String username, String password, Device device) {
        this.username = username;
        this.password = password;
        this.device = device;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
