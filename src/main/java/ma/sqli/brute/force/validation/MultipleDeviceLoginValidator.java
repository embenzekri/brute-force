package ma.sqli.brute.force.validation;


import java.util.HashSet;
import java.util.Set;

/**
 * @author : El Mahdi Benzekri
 * @since : 22/03/2022, mar.
 **/
public class MultipleDeviceLoginValidator implements LoginValidator {
    private Set<String> loggedInUsers = new HashSet<>();

    public String validate(LoginParams loginParams, WarningsCollector warnings) {
        if (loggedInUsers.contains(loginParams.getUsername())) {
            warnings.addWarning("We detected that your account is logged in multiple devices");
        }
        return "";
    }
}
